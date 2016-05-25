package com.thefifthidiot.tficore.core.proxy;

import com.thefifthidiot.tficore.render.BlockRenderer;
import com.thefifthidiot.tficore.render.ItemRenderer;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/*	This is the ClientProxy class, it used for:
 * 		
 * 	Registering:
 * 		particles
 * 		guis
 * 		block models and textures
 * 		item models and textures
 * 
 */
public class ClientProxy extends CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}
	
    public void init(FMLInitializationEvent event) {
    	super.init(event);
    	
    	BlockRenderer.registerBlockRenderer(); //Register block-rendering
    	ItemRenderer.registerItemRenderer(); //Register item-rendering
    }
    
    public void postInit(FMLPostInitializationEvent event) {
    	super.postInit(event);
    }
}