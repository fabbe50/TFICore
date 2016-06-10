package com.thefifthidiot.tficore.utility;

import com.mojang.authlib.yggdrasil.response.MinecraftProfilePropertiesResponse;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;

/**
 * Created by fabbe50 on 09/06/2016.
 */
public class LogicHelper {
    public static boolean isPlayerOP (EntityPlayer player) {
        //TODO: Add logic for OP-checking!

        return false;
    }

    public static boolean serverVote (int count, MinecraftServer server) {
        if (count > (server.getPlayerList().getCurrentPlayerCount() / 2)) { //Gets if the majority of the players online wants to skip rain.
            return true;
        }
        else {
            return false;
        }
    }
}
