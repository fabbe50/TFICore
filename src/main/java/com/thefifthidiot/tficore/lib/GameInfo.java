package com.thefifthidiot.tficore.lib;

import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.fml.common.FMLCommonHandler;

/**
 * Created by fabbe50 on 13/06/2016.
 */
public class GameInfo {
    public static MinecraftServer server = getServer();
    public static World world = server.getEntityWorld();
    public static WorldInfo worldInfo = world.getWorldInfo();
    public static GameRules gameRules = server.worldServerForDimension(0).getGameRules();


    private static MinecraftServer getServer() {
        FMLCommonHandler handler = FMLCommonHandler.instance();
        return handler.getMinecraftServerInstance();
    }
}
