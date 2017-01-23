package com.thefifthidiot.tficore.core.reference;

/*	The reference-class
 * 	
 * 	This is used for reoccurring Strings that are used throughout your code.
 * 	A good example for this is the main mod-class.
 */
public class Reference {
	public static final String MOD_ID = "tficore"; 													//Mod ID, this is your unique mod identifier.
	public static final String MOD_NAME = "TFICore";												//Mod Name, this is the name of your mod.
	public static final String BUILD = "@BUILD@";												    //Build, this is the build.
	public static final String VERSION = "@VERSION@";									    		//Version, this is the version.
	
	public static final String CLIENT_PROXY = "com.thefifthidiot.tficore.core.proxy.ClientProxy";	//This is the path to the ClientProxy class.
	public static final String COMMON_PROXY = "com.thefifthidiot.tficore.core.proxy.CommonProxy";	//This is the path to the CommonProxy class.
    public static final String GUI_FACTORY = "com.thefifthidiot.tficore.core.gui.GUIFactory";       //This is the path to the GUIFactory class.
}
