package com.thefifthidiot.tficore.common.world;

/**
 * Created by fabbe50 on 11/06/2016.
 */
public class GameRules {
    static net.minecraft.world.GameRules gameRules;

    public static void init() {
        gameRules.addGameRule("doWeather", "true", net.minecraft.world.GameRules.ValueType.BOOLEAN_VALUE);
    }
}
