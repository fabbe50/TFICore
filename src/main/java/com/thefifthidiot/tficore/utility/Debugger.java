package com.thefifthidiot.tficore.utility;

import com.thefifthidiot.tficore.lib.Configs;
import com.thefifthidiot.tficore.utility.helper.LogHelper;

/**
 * Created by fabbe50 on 27/09/2016.
 */
public class Debugger {
    public static void debug() {
        LogHelper.info(Configs.dimensionBlacklisted.get(0));
    }
}
