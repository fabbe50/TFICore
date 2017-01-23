package com.thefifthidiot.tficore.utility;

import com.thefifthidiot.tficore.lib.Configs;

/**
 * Created by fabbe50 on 27/09/2016.
 */
public class Debugger {
    public static void debug() {
        LogHelper.info(Configs.dimensionBlacklisted.get(0));
    }
}
