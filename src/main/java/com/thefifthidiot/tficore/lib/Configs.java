package com.thefifthidiot.tficore.lib;

public class Configs {
    //Booleans
	public static boolean tfitabs = true;           //Are the fallback tabs from TFICore active?                        DEFAULT: true
	public static boolean infoLogging = true;       //Will information notices be printed in the log?                   DEFAULT: true
    public static boolean rainVoting = true;        //Is rain-voting active?                                            DEFAULT: true
    public static boolean adminOverride = false;    //Can admins override the rain                                      DEFAULT: false;
    public static boolean chaacRainGod = true;      //Is one person the deciding factor over the rain-voting?           DEFAULT: true
    public static boolean disableFuseRock = false;  //Disable Exploding Rocks                                           DEFAULT: false

    //Ints
    public static int playerVoteWorth = 1;          //How much is a normal players vote worth?                          DEFAULT: 1
    public static int adminVoteWorth = 1;           //How much is an OP's vote worth?                                   DEFAULT: 1;

    //Floats
    public static float fuseRockStrength = 3.0f;    //Explosion Strength of the exploding rocks                         DEFAULT: 3.0f

    //Strings
    public static String oreFromMod = "IC2";        //What mod should oregen convert to?                                DEFAULT: "IC2"

}
