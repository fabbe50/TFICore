package com.thefifthidiot.tficore.core.event;

import com.thefifthidiot.tficore.lib.GameInfo;
import com.thefifthidiot.tficore.utility.LogHelper;
import com.thefifthidiot.tficore.utility.LogicHelper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.GameRules;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/**
 * Created by fabbe50 on 13/06/2016.
 */
public class EventRainOverride {
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void rainOverrideGR (TickEvent.ServerTickEvent event) {
        WorldInfo worldinfo = GameInfo.worldInfo;
        GameRules gameRules = GameInfo.gameRules;

        try {
            if (!gameRules.getBoolean("doWeather")) {
                if (worldinfo.getCleanWeatherTime() <= 1000) {
                    worldinfo.setCleanWeatherTime(LogicHelper.getRainTime());                                           //Sets the clear-weather for .5 to 7.5 Minecraft days
                    worldinfo.setRainTime(0);                                                                           //Sets the rain-time to 0
                    worldinfo.setThunderTime(0);                                                                        //Sets the thunder-time to 0
                    worldinfo.setRaining(false);                                                                        //Turns off rain
                    worldinfo.setThundering(false);                                                                     //Turns off thunder
                }
            }
        }
        catch (Exception e) {
            LogHelper.error("Exception in RainOverride: " + e);
        }
    }
}
