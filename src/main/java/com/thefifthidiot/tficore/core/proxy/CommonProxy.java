package com.thefifthidiot.tficore.core.proxy;

import com.thefifthidiot.tficore.core.registry.BlockRegistry;
import com.thefifthidiot.tficore.core.registry.ItemRegistry;
import com.thefifthidiot.tficore.core.registry.RecipeRegistry;
import com.thefifthidiot.tficore.core.registry.SmeltingRegistry;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
}
