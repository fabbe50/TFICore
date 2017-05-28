package com.thefifthidiot.tficore.core.commands;

import com.thefifthidiot.tficore.lib.Configs;
import com.thefifthidiot.tficore.utility.helper.LogHelper;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabbe50 on 08/06/2016.
 */
public class CommandRainVote extends CommandBase implements IEntityLivingData {
    List<String> aliases = new ArrayList<String>();
    ITextComponent message;

    @Override
    public String getName() {
        return "wantrain";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "< true | false >";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        if (0 == getRequiredPermissionLevel()) {
            return true;
        }
        else{
            return sender.canUseCommand(this.getRequiredPermissionLevel(), this.getName());
        }
    }

    private void addAliases() {
        aliases.add("wr");
        aliases.add("rainvote");
        aliases.add("stoprain");
    }

    @Override
    public List<String> getAliases() {
        return aliases;
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
        if (Configs.chaacRainGod) {player.sendMessage(new TextComponentString("You're now a rain stopping god!"));}
        else {player.sendMessage(new TextComponentString("You're now voting against rain."));}
        LogHelper.info("Added tag \"norain\" to player: " + player.getDisplayName().getUnformattedText());
    }

    private void removeTag(Entity player) {
        player.removeTag("norain");
        if (Configs.chaacRainGod) {player.sendMessage(new TextComponentString("The stopping of rain is no longer in your control!"));}
        else {player.sendMessage(new TextComponentString("You're no longer voting against rain."));}
        LogHelper.info("Removed tag \"norain\" from player: " + player.getDisplayName().getUnformattedText());
    }
}