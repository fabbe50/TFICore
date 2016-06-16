package com.thefifthidiot.tficore.core.proxy;

import com.thefifthidiot.tficore.init.TFIGamerules;
import com.thefifthidiot.tficore.core.registry.BlockRegistry;
import com.thefifthidiot.tficore.core.registry.ItemRegistry;
import com.thefifthidiot.tficore.core.registry.RecipeRegistry;
import com.thefifthidiot.tficore.core.registry.SmeltingRegistry;

import com.thefifthidiot.tficore.init.TFICommands;
import com.thefifthidiot.tficore.init.TFIWorldEvents;
import net.minecraftforge.fml.common.event.*;

/*	This is the CommonProxy class, it is used for:
 * 
 * 	Registering
 * 		blocks
 * 		entities
 * 		items
 * 		tile entities
 */
public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		BlockRegistry.init();	//Initialize Blocks
		ItemRegistry.init();	//Initialize Items
	}
	
    public void init(FMLInitializationEvent event) {
    	RecipeRegistry.registerRecipe();
    	SmeltingRegistry.registerSmelting();
    }
    
    public void postInit(FMLPostInitializationEvent event) {
    	
    }

    public void onServerStarting(FMLServerStartingEvent event) {
        TFIGamerules.init();
        TFICommands.init(event);
    }

    public void onServerStarted(FMLServerStartedEvent event) {
        TFIWorldEvents.init();
    }
}
