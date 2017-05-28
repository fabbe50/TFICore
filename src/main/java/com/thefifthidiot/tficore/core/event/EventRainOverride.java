package com.thefifthidiot.tficore.core.event;

import com.thefifthidiot.tficore.lib.GameInfo;
import com.thefifthidiot.tficore.utility.helper.LogHelper;
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
                gameRules.setOrCreateGameRule("doWeather", "true");
                gameRules.setOrCreateGameRule("doWeatherCycle", "false");
                LogHelper.info("Switched weather GameRule over to Vanilla GameRule.");
            }
        }
        catch (Exception e) {
            LogHelper.error("Exception in RainOverride: " + e);
        }
    }
}
