package com.thefifthidiot.tficore.core.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabbe50 on 29/08/2016.
 */
public class CommandWorldInfo extends CommandBase {
    List<String> aliases = new ArrayList<String>();

    @Override
    public String getName() {
        addAliases();
        return "worldinfo";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "[ all | spawn | day | entity | seed | worldtype | difficulty | player | worldborder ]";
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
        aliases.add("wi");
    }

    @Override
    public List getAliases() {
        return aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        World world = server.getEntityWorld();
        Entity player = sender.getCommandSenderEntity();

        if (player instanceof EntityPlayer) {
            if (!world.isRemote) {
                if (args[0].equalsIgnoreCase("all")) {
                    player.sendMessage(new TextComponentString("World Spawn: " + getSpawn(world)));
                    player.sendMessage(new TextComponentString("Day: " + getDay(world)));
                    player.sendMessage(new TextComponentString("Time: " + world.getWorldTime()));
                    player.sendMessage(new TextComponentString("Living Entities: " + world.countEntities(EnumCreatureType.CREATURE, false)));
                    player.sendMessage(new TextComponentString("All Entities: " + countEntities(world)));
                    player.sendMessage(new TextComponentString("Seed: " + world.getSeed()));
                    player.sendMessage(new TextComponentString("World Type: " + world.getWorldType().getName()));
                    player.sendMessage(new TextComponentString("Difficulty: " + world.getDifficulty().name()));
                }
                else if (args[0].equalsIgnoreCase("spawn")) {
                    player.sendMessage(new TextComponentString("World Spawn: " + getSpawn(world)));
                }
                else if (args[0].equalsIgnoreCase("day") || args[0].equalsIgnoreCase("time")) {
                    player.sendMessage(new TextComponentString("Day: " + getDay(world)));
                    player.sendMessage(new TextComponentString("Time: " + world.getWorldTime()));
                }
                else if (args[0].equalsIgnoreCase("entity")) {
                    player.sendMessage(new TextComponentString("Living Entities: " + world.countEntities(EnumCreatureType.CREATURE, false)));
                    player.sendMessage(new TextComponentString("All Entities: " + countEntities(world)));
                }
                else if (args[0].equalsIgnoreCase("seed")) {
                    player.sendMessage(new TextComponentString("Seed: " + world.getSeed()));
                }
                else if (args[0].equalsIgnoreCase("worldtype")) {
                    player.sendMessage(new TextComponentString("World Type: " + world.getWorldType()));
                }
                else if (args[0].equalsIgnoreCase("difficulty")) {
                    player.sendMessage(new TextComponentString("Difficulty: " + world.getDifficulty()));
                }
                else if (args[0].equalsIgnoreCase("player")) {
                    ItemStack main = ((EntityPlayer) player).getHeldItem(EnumHand.MAIN_HAND);
                    ItemStack off = ((EntityPlayer) player).getHeldItem(EnumHand.OFF_HAND);
                    BlockPos bedLocation = ((EntityPlayer) player).getBedLocation();
                    player.sendMessage(new TextComponentString("Player Name: " + ((EntityPlayer) player).getDisplayNameString()));
                    player.sendMessage(new TextComponentString("Creative Mode: " + ((EntityPlayer) player).capabilities.isCreativeMode));
                    player.sendMessage(new TextComponentString("Items in Hands: "));
                        player.sendMessage(new TextComponentString("    [Main: " + (main == null ? "Empty" : main.getDisplayName()) + "]"));
                        player.sendMessage(new TextComponentString("    [Off: " + (off == null ? "Empty" : off.getDisplayName()) + "]"));
                    player.sendMessage(new TextComponentString("Tags Applied: " + player.getTags()));
                    player.sendMessage(new TextComponentString("Experience: " + ((EntityPlayer) player).experienceTotal));
                    player.sendMessage(new TextComponentString("Bed Location: " + (bedLocation == null ? player.getDisplayName().getUnformattedText() + " not bound to bed." : "[X: " + bedLocation.getX() + ", Y: " + bedLocation.getY() + ", Z: " + bedLocation.getZ() + "]")));
                    player.sendMessage(new TextComponentString("Team: " + (player.getTeam() == null ? player.getDisplayName().getUnformattedText() + " is not on a team." : player.getTeam())));
                }
                else if (args[0].equalsIgnoreCase("worldborder")) {
                    player.sendMessage(new TextComponentString("World Border Center: [X: " + world.getWorldBorder().getCenterX() + ", Z: " + world.getWorldBorder().getCenterZ() + "]"));
                    player.sendMessage(new TextComponentString("World Border Bounds: "));
                        player.sendMessage(new TextComponentString("    [Min X: " + world.getWorldBorder().minX() + ", Min Z: " + world.getWorldBorder().minZ() + "]"));
                        player.sendMessage(new TextComponentString("    [Max X: " + world.getWorldBorder().maxX() + ", Max Z: " + world.getWorldBorder().maxZ() + "]"));
                    player.sendMessage(new TextComponentString("World Border Size: " + world.getWorldBorder().getSize()));
                    player.sendMessage(new TextComponentString("World Border Target Size: " + world.getWorldBorder().getTargetSize()));
                }
                else if (args.length == 0) {
                    player.sendMessage(new TextComponentString("Usage: /worldinfo [ all | spawn | day | entity | seed | worldtype | difficulty | player | worldborder ]"));
                }
            }
        }
    }

    private String getDay(World world) {
        final long time = world.getTotalWorldTime();
        final String day = String.format("%.1f", time / 24000.0);
        return day;
    }

    private String getSpawn(World world) {
        return "[X: " + world.getSpawnPoint().getX() + ", Y: " + world.getSpawnPoint().getY() + ", Z: " + world.getSpawnPoint().getZ() + "]";
    }

    private int countEntities (World world) {
        return world.loadedEntityList.size();
    }
}
