package com.thefifthidiot.tficore.init;

import com.thefifthidiot.tficore.core.commands.CommandRainVote;
import com.thefifthidiot.tficore.core.commands.CommandWorldInfo;
import com.thefifthidiot.tficore.lib.Configs;
import com.thefifthidiot.tficore.utility.LogHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

/**
 * Created by fabbe50 on 14/06/2016.
 */
public class TFICommands {
    public static void init(FMLServerStartingEvent event) {
        LogHelper.finfo("Adding Commands");
        //Can be disabled
        if(Configs.rainVoting){event.registerServerCommand(new CommandRainVote());}

        //Can't be disabled
        event.registerServerCommand(new CommandWorldInfo());
    }
}
