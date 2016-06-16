package com.thefifthidiot.tficore.init;

import com.thefifthidiot.tficore.core.event.EventRainOverride;
import com.thefifthidiot.tficore.core.event.EventRainVote;
import com.thefifthidiot.tficore.lib.Configs;
import com.thefifthidiot.tficore.utility.LogHelper;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by fabbe50 on 14/06/2016.
 */
public class TFIWorldEvents {
    public static void init() {
        LogHelper.finfo("Adding EventRainVote");
        //Can be disabled
        if(Configs.rainVoting){MinecraftForge.EVENT_BUS.register(new EventRainVote());}

        //Can't be disabled
        MinecraftForge.EVENT_BUS.register(new EventRainOverride());

    }
}
