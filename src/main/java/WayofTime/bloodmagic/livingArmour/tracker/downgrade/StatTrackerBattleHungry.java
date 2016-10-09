package WayofTime.bloodmagic.livingArmour.tracker.downgrade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import WayofTime.bloodmagic.api.Constants;
import WayofTime.bloodmagic.api.livingArmour.LivingArmourUpgrade;
import WayofTime.bloodmagic.api.livingArmour.StatTracker;
import WayofTime.bloodmagic.livingArmour.LivingArmour;
import WayofTime.bloodmagic.livingArmour.downgrade.LivingArmourUpgradeBattleHungry;
import WayofTime.bloodmagic.util.Utils;

public class StatTrackerBattleHungry extends StatTracker
{
    public double totalDamageDealt = 0;

    public static HashMap<LivingArmour, Double> changeMap = new HashMap<LivingArmour, Double>();
    public static int[] damageRequired = new int[] { 200, 800, 1300, 2500, 3800, 5000 };

    public static void incrementCounter(LivingArmour armour, double damage)
    {
        changeMap.put(armour, changeMap.containsKey(armour) ? changeMap.get(armour) + damage : damage);
    }

    @Override
    public String getUniqueIdentifier()
    {
        return Constants.Mod.MODID + ".tracker.battleHunger";
    }

    @Override
    public void resetTracker()
    {
        this.totalDamageDealt = 0;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag)
    {
        totalDamageDealt = tag.getDouble(Constants.Mod.MODID + ".tracker.battleHunger");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag)
    {
        tag.setDouble(Constants.Mod.MODID + ".tracker.battleHunger", totalDamageDealt);
    }

    @Override
    public boolean onTick(World world, EntityPlayer player, LivingArmour livingArmour)
    {
        if (changeMap.containsKey(livingArmour))
        {
            double change = Math.abs(changeMap.get(livingArmour));
            if (change > 0)
            {
                totalDamageDealt += Math.abs(changeMap.get(livingArmour));
                System.out.println(totalDamageDealt);
                changeMap.put(livingArmour, 0d);

                this.markDirty();

                return true;
            }
        }

        return false;
    }

    @Override
    public void onDeactivatedTick(World world, EntityPlayer player, LivingArmour livingArmour)
    {
        if (changeMap.containsKey(livingArmour))
        {
            changeMap.remove(livingArmour);
        }
    }

    @Override
    public List<LivingArmourUpgrade> getUpgrades()
    {
        List<LivingArmourUpgrade> upgradeList = new ArrayList<LivingArmourUpgrade>();

        for (int i = 0; i < 5; i++)
        {
            if (totalDamageDealt >= damageRequired[i])
            {
                upgradeList.add(new LivingArmourUpgradeBattleHungry(i));
            }
        }

        return upgradeList;
    }

    @Override
    public double getProgress(LivingArmour livingArmour, int currentLevel)
    {
        return Utils.calculateStandardProgress(totalDamageDealt, damageRequired, currentLevel);
    }

    @Override
    public boolean providesUpgrade(String key)
    {
        return key.equals(Constants.Mod.MODID + ".upgrade.battleHunger");
    }

    @Override
    public void onArmourUpgradeAdded(LivingArmourUpgrade upgrade)
    {
        if (upgrade instanceof LivingArmourUpgradeBattleHungry)
        {
            int level = upgrade.getUpgradeLevel();
            if (level < damageRequired.length)
            {
                totalDamageDealt = Math.max(totalDamageDealt, damageRequired[level]);
                this.markDirty();
            }
        }
    }

    @Override
    public boolean isTrackerDowngrade()
    {
        return true;
    }
}