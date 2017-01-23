package com.thefifthidiot.tficore.lib;

import com.thefifthidiot.tficore.utility.LogHelper;

import java.util.ArrayList;
import java.util.List;

public class Configs {
    //Array<float>
    public static List<Integer> dimensionBlacklisted = new ArrayList<>();

    //Booleans
	public static boolean tfitabs = true;                       //Are the fallback tabs from TFICore active?                DEFAULT: true
	public static boolean infoLogging = true;                   //Will information notices be printed in the log?           DEFAULT: true
    public static boolean rainVoting = true;                    //Is rain-voting active?                                    DEFAULT: true
    public static boolean adminOverride = false;                //Can admins override the rain                              DEFAULT: false
    public static boolean chaacRainGod = true;                  //Is one person the deciding factor over the rain-voting?   DEFAULT: true
    public static boolean disableFuseRock = false;              //Disable Exploding Rocks                                   DEFAULT: false

    //Ints
    public static int playerVoteWorth = 1;                      //How much is a normal players vote worth?                  DEFAULT: 1
    public static int adminVoteWorth = 1;                       //How much is an OP's vote worth?                           DEFAULT: 1

    //Floats
    public static float fuseRockStrength = 3.0f;                //Explosion Strength of the exploding rocks                 DEFAULT: 3.0f
    public static float cloudHeight = 128.0f;                   //Height of where clouds are rendered                       DEFAULT: 128.0f
    public static float cloudColorRed = 1.0f;                   //Red Cloud Color                                           DEFAULT: 1.0f
    public static float cloudColorGreen = 1.0f;                 //Green Cloud Color                                         DEFAULT: 1.0f
    public static float cloudColorBlue = 1.0f;                  //Blue Cloud Color                                          DEFAULT: 1.0f
    public static float cloudColorAlpha = 1.0f;                 //Alpha CLoud Color                                         DEFAULT: 1.0f

    //Strings
    public static String oreFromMod = "IC2";                    //What mod should oregen convert to?                        DEFAULT: "IC2"


    public static void init() {
    }

    public static boolean isDimensionAllowed(int id) {
        return dimensionBlacklisted.contains(id);
    }
}
