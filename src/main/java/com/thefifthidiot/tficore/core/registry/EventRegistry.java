package com.thefifthidiot.tficore.core.registry;

import com.thefifthidiot.tficore.common.world.gen.GenWorldVeins;
import com.thefifthidiot.tficore.core.event.EventCloudRenderer;
import com.thefifthidiot.tficore.core.event.EventRainOverride;
import com.thefifthidiot.tficore.core.event.EventRainVote;
import com.thefifthidiot.tficore.core.handler.ChatHandler;
import com.thefifthidiot.tficore.core.handler.ConfigurationHandler;
import com.thefifthidiot.tficore.lib.Configs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by fabbe50 on 22/09/2016.
 */
public class EventRegistry {
    public static void init() {
        GameRegistry.registerWorldGenerator(new GenWorldVeins(), 0);
        //MinecraftForge.EVENT_BUS.register(EventCloudRenderer.class);
    }

    public static void postInit() {
        MinecraftForge.EVENT_BUS.register(ConfigurationHandler.class);
    }

    public static void onServerStarted() {
        if(Configs.rainVoting){MinecraftForge.EVENT_BUS.register(new EventRainVote());}
        MinecraftForge.EVENT_BUS.register(new EventRainOverride());
        MinecraftForge.EVENT_BUS.register(new ChatHandler());
    }
}
