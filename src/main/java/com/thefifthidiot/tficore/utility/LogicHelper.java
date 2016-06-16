package com.thefifthidiot.tficore.utility;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.UserListOps;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by fabbe50 on 09/06/2016.
 */
public class LogicHelper {
    static UserListOps userListOps;

    //Checking if the player is OP on the server.
    public static boolean isPlayerOP (EntityPlayer player, World world) {
        AtomicReference<List<String>> ops = new AtomicReference<List<String>>();
        ops.set(null);

        try {
            if (!world.getMinecraftServer().getServer().isSinglePlayer()) {
                for (int i = 0; i < userListOps.getKeys().length; i++) {
                    ops.get().add(userListOps.getKeys()[i]);
                }

                return ops.get() != null && ops.get().contains(player.getDisplayNameString());
            } else {
                return false;
            }
        }
        catch (Exception e) {
            LogHelper.trace(e);
            return false;
        }
    }

    //Checks for the Majority of online players
    public static boolean serverVote (int count, MinecraftServer server) {
        //Gets if the majority of the players online wants to skip rain.
        return count > (server.getPlayerList().getCurrentPlayerCount() / 2);
    }

    //Calculates an amount of time it can rain matching vanilla behaviour
    public static int getRainTime () {
        Random random = new Random();
        return random.nextInt(168000) + 12000;
    }
}
