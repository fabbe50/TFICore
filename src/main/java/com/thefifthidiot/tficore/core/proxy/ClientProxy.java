package com.thefifthidiot.tficore.core.proxy;

import com.thefifthidiot.tficore.common.entity.EntityFuseRockPrimed;
import com.thefifthidiot.tficore.core.registry.BlockRegistry;
import com.thefifthidiot.tficore.render.BlockRenderer;
import com.thefifthidiot.tficore.render.ItemRenderer;

import com.thefifthidiot.tficore.render.entity.RenderFuseRockPrimed;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
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
@SuppressWarnings("deprecation")
public class ClientProxy extends CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}
	
    public void init(FMLInitializationEvent event) {
    	super.init(event);
    	
    	BlockRenderer.registerBlockRenderer(); //Register block-rendering
    	ItemRenderer.registerItemRenderer(); //Register item-rendering
        //ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRegistry.fuseRock), 0, new ModelResourceLocation(BlockRegistry.fuseRock.getRegistryName(), "inventory"));
        RenderingRegistry.registerEntityRenderingHandler(EntityFuseRockPrimed.class, new RenderFuseRockPrimed(Minecraft.getMinecraft().getRenderManager()));
    }
    
    public void postInit(FMLPostInitializationEvent event) {
    	super.postInit(event);
    }
}