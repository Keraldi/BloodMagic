package wayoftime.bloodmagic.command.sub;

import net.minecraft.command.CommandException;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.ServerPlayerEntity;

public class SubCommandBind
{
	public ServerPlayerEntity player;

//	static ArgumentBuilder<CommandSource, ?> register()
//    {
//        return Commands.literal("generate")
//            .requires(cs->cs.hasPermissionLevel(4)) //permission
//            .then(Commands.argument("pos", BlockPosArgument.blockPos())
//                .then(Commands.argument("count", IntegerArgumentType.integer(1))
//                    .then(Commands.argument("dim", DimensionArgument.getDimension())
//                        .then(Commands.argument("interval", IntegerArgumentType.integer())
//                            .executes(ctx -> execute(ctx.getSource(), BlockPosArgument.getBlockPos(ctx, "pos"), getInt(ctx, "count"), DimensionArgument.getDimensionArgument(ctx, "dim"), getInt(ctx, "interval")))
//                        )
//                        .executes(ctx -> execute(ctx.getSource(), BlockPosArgument.getBlockPos(ctx, "pos"), getInt(ctx, "count"), DimensionArgument.getDimensionArgument(ctx, "dim"), -1))
//                    )
//                    .executes(ctx -> execute(ctx.getSource(), BlockPosArgument.getBlockPos(ctx, "pos"), getInt(ctx, "count"), ctx.getSource().getWorld(), -1))
//                )
//            );
//    }

//	public ITextComponent getInfo()
//	{
//		return player.getName();
//	}
//
//	@Override
//	public String getName()
//	{
//		return "bind";
//	}
//
//	@Override
//	public String getUsage(ICommandSender commandSender)
//	{
//		return "commands.bloodmagic.bind.usage";
//	}
//
//	public String getHelp()
//	{
//		return "commands.bloodmagic.bind.help";
//	}
//
//	@Override
//	public int getRequiredPermissionLevel()
//	{
//		return 2;
//	}

	public static int execute(CommandSource source, String[] args)
			throws CommandException
	{
//		if (args.length == 1 && (args[0].equals("?") || args[0].equals("help")))
//		{
//			sender.sendMessage(new TranslationTextComponent(getHelp()));
//			return;
//		}
//		if (sender.getEntityWorld().isRemote)
//			return;
//		ServerPlayerEntity player = args.length < 2 ? getCommandSenderAsPlayer(sender)
//				: getPlayer(server, sender, args[0]);
//		ItemStack held = player.getHeldItemMainhand();
//		boolean bind = true;
//		if (held.getItem() instanceof IBindable)
//		{
//			Binding binding = ((IBindable) held.getItem()).getBinding(held);
//			if (binding != null)
//				bind = false;
//			if (args.length < 2)
//				if (args.length == 1)
//					if (isBoolean(args[0]))
//						bind = Boolean.parseBoolean(args[0]);
//					else
//						player = getPlayer(server, sender, args[0]);
//			if (bind)
//			{
//				if (binding.getOwnerName().equals(player.getName()))
//				{
//					sender.sendMessage(new TranslationTextComponent("commands.bloodmagic.bind.error.ownerEqualsTarget"));
//					return;
//				}
//				binding = new Binding(player.getGameProfile().getId(), player.getGameProfile().getName());
//				BindableHelper.applyBinding(held, binding);
//				this.player = player;
//				sender.sendMessage(new TranslationTextComponent("commands.bloodmagic.bind.success", getInfo()));
//			} else
//			{
//				if (binding == null)
//				{
//					sender.sendMessage(new TranslationTextComponent("commands.bloodmagic.bind.error.notBound"));
//				}
//				held.getTagCompound().removeTag("binding");
//				sender.sendMessage(new TranslationTextComponent("commands.bloodmagic.bind.remove.success"));
//			}
//		} else
//			sender.sendMessage(new TranslationTextComponent("commands.bloodmagic.bind.error.notBindable"));

		return 1;
	}

	private boolean isBoolean(String string)
	{
		return string.equalsIgnoreCase("true") || string.equalsIgnoreCase("false");
	}
}
