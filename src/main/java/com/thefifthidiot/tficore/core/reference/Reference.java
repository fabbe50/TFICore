package com.thefifthidiot.tficore.core.reference;

/*	The reference-class
 * 	
 * 	This is used for recurring Strings, that are used throughout your code.
 * 	A good example for this is the main mod-class.
 */
public class Reference {
	public static final String MOD_ID = "tficore"; 													//Mod ID, this is your unique mod identifier.
	public static final String MOD_NAME = "TFICore";												//Mod Name, this is the name of your mod.
	public static final String BUILD = "@BUILD@";												//Build, this is the build.
	public static final String VERSION = "@VERSION@" + BUILD;									//Version, this is the version.
	
	public static final String CLIENT_PROXY = "com.thefifthidiot.tficore.core.proxy.ClientProxy";	//This is the path to the ClientProxy class.
	public static final String COMMON_PROXY = "com.thefifthidiot.tficore.core.proxy.CommonProxy";	//This is the path to the CommonProxy class.
}
