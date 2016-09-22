package com.thefifthidiot.tficore.core.proxy;

import com.thefifthidiot.tficore.core.handler.ConfigurationHandler;
import com.thefifthidiot.tficore.core.registry.*;
import com.thefifthidiot.tficore.init.TFIGamerules;

import com.thefifthidiot.tficore.init.TFICommands;
import net.minecraftforge.fml.common.event.*;

/*	This is the CommonProxy class, it is used for:
 * 
 * 	Registering
 * 	    configs
 * 		blocks
 * 		entities
 * 		items
 * 		tile entities
 */
public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
        ConfigurationHandler.load(event);
		BlockRegistry.init();	//Initialize Blocks
		ItemRegistry.init();	//Initialize Items
	}
	
    public void init(FMLInitializationEvent event) {
    	RecipeRegistry.registerRecipe();
    	SmeltingRegistry.registerSmelting();
        OregenRegistry.init();
        EventRegistry.init();
    }
    
    public void postInit(FMLPostInitializationEvent event) {
        EventRegistry.postInit();
    }

    public void onServerStarting(FMLServerStartingEvent event) {
        TFIGamerules.init();
        TFICommands.init(event);
    }

    public void onServerStarted(FMLServerStartedEvent event) {
        EventRegistry.onServerStarted();
    }
}
