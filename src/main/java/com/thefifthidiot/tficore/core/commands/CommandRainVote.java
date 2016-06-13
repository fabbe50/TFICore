package com.thefifthidiot.tficore.core.commands;

import com.thefifthidiot.tficore.utility.LogHelper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

/**
 * Created by fabbe50 on 08/06/2016.
 */
public class CommandRainVote extends CommandBase implements IEntityLivingData {
    ITextComponent message;

    @Override
    public String getCommandName() {
        return "wantrain";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "<true|false>";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        World world = server.getEntityWorld();
        Entity player = sender.getCommandSenderEntity();

        if (player instanceof EntityPlayer) {
            if (!world.isRemote) {
                try {
                    if (player.getTags().contains("norain") && args[0] == "true") {
                        removeTag(player);
                    } else if (!player.getTags().contains("norain") && args[0] == "false") {
                        addTag(player);
                    } else {
                        LogHelper.info("Command failed! Called by: " + player.getDisplayName().getUnformattedText());
                    }
                }
                catch (Exception e) {
                    if (player.getTags().contains("norain")) {
                        removeTag(player);
                    } else if (!player.getTags().contains("norain")) {
                        addTag(player);
                    } else {
                        LogHelper.info("Command failed! Called by: " + player.getDisplayName().getUnformattedText());
                    }
                }
            }
        }
    }

    private void addTag(Entity player) {
        player.addTag("norain");
        player.addChatMessage(new TextComponentString("Rain will no longer appear in the world you're in!"));
        LogHelper.info("Added tag \"norain\" to player: " + player.getDisplayName().getUnformattedText());
    }

    private void removeTag(Entity player) {
        player.removeTag("norain");
        player.addChatMessage(new TextComponentString("Rain will now appear in the world you're in!"));
        LogHelper.info("Removed tag \"norain\" from player: " + player.getDisplayName().getUnformattedText());
    }
}