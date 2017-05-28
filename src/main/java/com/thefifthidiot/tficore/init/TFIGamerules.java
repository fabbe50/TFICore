package com.thefifthidiot.tficore.init;

import com.thefifthidiot.tficore.utility.helper.LogHelper;
import net.minecraft.world.GameRules;

/**
 * Created by fabbe50 on 11/06/2016.
 */
public class TFIGamerules {
    static GameRules gameRules = new GameRules();

    public static void init() {
        LogHelper.finfo("Adding GameRules");
        gameRules.addGameRule("doWeather", "true", GameRules.ValueType.BOOLEAN_VALUE);
    }
}
