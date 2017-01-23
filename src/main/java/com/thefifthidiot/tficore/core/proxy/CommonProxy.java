package com.thefifthidiot.tficore.core.proxy;

import com.thefifthidiot.tficore.core.handler.ConfigurationHandler;
import com.thefifthidiot.tficore.core.registry.*;
import com.thefifthidiot.tficore.init.TFIGamerules;

import com.thefifthidiot.tficore.init.TFICommands;
import com.thefifthidiot.tficore.lib.Configs;
import com.thefifthidiot.tficore.lib.SpecialDropStorage;
import com.thefifthidiot.tficore.utility.Debugger;
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
        Configs.init();
        ConfigurationHandler.load(event);
		BlockRegistry.init();	//Initialize Blocks
		ItemRegistry.init();	//Initialize Items
        SpecialDropStorage.init();
	}
	
    public void init(FMLInitializationEvent event) {
    	RecipeRegistry.registerRecipe();
    	SmeltingRegistry.registerSmelting();
        OregenRegistry.init();
        EventRegistry.init();
        SpecialDropRegistry.registerSpecialDrops();
    }
    
    public void postInit(FMLPostInitializationEvent event) {
        Debugger.debug();
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
