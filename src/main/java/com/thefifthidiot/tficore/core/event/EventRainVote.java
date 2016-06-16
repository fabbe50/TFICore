package com.thefifthidiot.tficore.core.event;

import com.thefifthidiot.tficore.TFICore;
import com.thefifthidiot.tficore.lib.Configs;
import com.thefifthidiot.tficore.lib.GameInfo;
import com.thefifthidiot.tficore.utility.LogHelper;

import com.thefifthidiot.tficore.utility.LogicHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EventRainVote {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void clearRainOnPlayerOnline(TickEvent.ServerTickEvent event) {
		MinecraftServer server = GameInfo.server;
		World world = GameInfo.world;

		if (!world.isRemote) {
			WorldInfo worldinfo = GameInfo.worldInfo;
            String[] players = server.getPlayerList().getAllUsernames();

            try {
                if (worldinfo.getCleanWeatherTime() <= 1000 && server.getPlayerList().getCurrentPlayerCount() > 0) {    //if the weather turns to rain and the there are at least 1 player
                    for (int j = 0; j < server.getPlayerList().getCurrentPlayerCount(); j++) {
                        if (majorityDecides(server, world) || (Configs.chaacRainGod && world.playerEntities.get(j).getTags().contains("norain"))) { //If chaacRainGod is false, the majority of the server is what decides whether or not the rain will go away.
                            worldinfo.setCleanWeatherTime(LogicHelper.getRainTime());                                   //Sets the clear-weather for .5 to 7.5 Minecraft days
                            worldinfo.setRainTime(0);                                                                   //Sets the rain-time to 0
                            worldinfo.setThunderTime(0);                                                                //Sets the thunder-time to 0
                            worldinfo.setRaining(false);                                                                //Turns off rain
                            worldinfo.setThundering(false);                                                             //Turns off thunder
                            LogHelper.info("Rain Blocked for " + worldinfo.getCleanWeatherTime() + "!");                //Notifies the console
                            break;                                                                                      //Breaks the loop
                        }
                    }
                }
            }
            catch (Error e) {
                LogHelper.fatal(e);
                LogHelper.trace(e);
            }
		}
	}

    private boolean majorityDecides (MinecraftServer server, World world) {
        int count = 0;
        for (int j = 0; j < server.getPlayerList().getCurrentPlayerCount(); j++) {
            if (world.playerEntities.get(j).getTags().contains("norain")) {
                EntityPlayer player = world.playerEntities.get(j);

                if (LogicHelper.isPlayerOP((EntityPlayerMP)player, world))
                    count =+ Configs.adminVoteWorth;
                else if (!LogicHelper.isPlayerOP((EntityPlayerMP)player, world)) {
                    count =+ Configs.playerVoteWorth;
                }
            }
        }
        return LogicHelper.serverVote(count, server);
    }
}