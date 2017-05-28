package com.thefifthidiot.tficore;

import com.thefifthidiot.tficore.core.proxy.CommonProxy;
import com.thefifthidiot.tficore.core.reference.Reference;

import com.thefifthidiot.tficore.utility.helper.LogHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;

/*	Hello and welcome to the main mod-class, this is where your mod is born.
 * 	
 * 	First off, you declare it your main modclass like below.
 * 	@param name = the name of your mod
 * 	@param modid = your mods id, this is what makes your mod unique.
 * 	@param version = this is how you tell the game what version of the mod is running.
 */

@Mod(name = Reference.MOD_NAME, modid = Reference.MOD_ID, version = Reference.VERSION, acceptedMinecraftVersions = "[1.10.*, 1.11]", guiFactory = Reference.GUI_FACTORY)
public class TFICore
{
	//Creating an instance of your mod is as simple as this:
	@Instance(Reference.MOD_ID)
	public static TFICore instance;
	
	/*	Creating a proxy is not required in a simple mod, but is very useful. 
	 * 	The CommonProxy is set to run on the game server.
	 * 	The ClientProxy is set to only run on the client side.	
	 * 	
	 *	You do this like so:
	 */
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
	public static CommonProxy proxy;
	
	/*	Now that you have your instance and proxy it's time to initialize the mod.
	 *	
	 *	Forge goes through three steps of initialization.
	 *	The Pre-Initialization which is the first step.
	 *	The Initialization which is the second step.
	 *	The Post-Initialization which is the third and last step.
	 *
	 *	Now these three steps are setup to call the proxy which will run the code on the set side.
	 */	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
        LogHelper.finfo("Pre-Initializing"); //These log-messages are not required, but it helps keeping the log tidy.
        this.proxy.preInit(event);
        LogHelper.finfo("Done");
	}
	
    @EventHandler
    public void init(FMLInitializationEvent event) {
        LogHelper.finfo("Initializing");
    	this.proxy.init(event);
        LogHelper.finfo("Done");
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LogHelper.finfo("Post-Initializing");
        this.proxy.postInit(event);
        LogHelper.finfo("Done");
    }
    
    @EventHandler
    public void onServerStarting(FMLServerStartingEvent event) {
        LogHelper.finfo("Running ServerStarting-event");
        this.proxy.onServerStarting(event);
        LogHelper.finfo("Done");
    }

    @EventHandler
    public void onServerStarted(FMLServerStartedEvent event) {
        LogHelper.finfo("Running ServerStarted-event");
        this.proxy.onServerStarted(event);
        LogHelper.finfo("Done");
    }
}
