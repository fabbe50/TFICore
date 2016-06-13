package com.thefifthidiot.tficore.utility;

import com.mojang.authlib.yggdrasil.response.MinecraftProfilePropertiesResponse;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.UserListOps;
import net.minecraft.server.management.UserListOpsEntry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.List;
import java.util.Random;

/**
 * Created by fabbe50 on 09/06/2016.
 */
public class LogicHelper {
    static UserListOps userListOps;

    public static boolean isPlayerOP (EntityPlayer player) {
        List<String> ops = null;

        if (!Minecraft.getMinecraft().isSingleplayer()) {
            for (int i = 0; i < userListOps.getKeys().length; i++) {
                ops.add(userListOps.getKeys()[i]);
            }

            if (ops.contains(player.getDisplayNameString())) {
                return true;
            } else {
                return false;
            }
        }
        else if (Minecraft.getMinecraft().isSingleplayer()) {
            return false;
        }
        else {
            return false;
        }
    }

    public static boolean serverVote (int count, MinecraftServer server) {
        if (count > (server.getPlayerList().getCurrentPlayerCount() / 2)) { //Gets if the majority of the players online wants to skip rain.
            return true;
        }
        else {
            return false;
        }
    }

    public static int getRainTime () {
        Random random = new Random();
        return random.nextInt(168000) + 12000;
    }
}
