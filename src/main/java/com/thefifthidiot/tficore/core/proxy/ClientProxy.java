package com.thefifthidiot.tficore.core.proxy;

import com.thefifthidiot.tficore.common.entity.EntityFuseRockPrimed;
import com.thefifthidiot.tficore.core.handler.CloudHandlerFix;
import com.thefifthidiot.tficore.lib.Configs;
import com.thefifthidiot.tficore.render.BlockRenderer;
import com.thefifthidiot.tficore.render.ItemRenderer;

import com.thefifthidiot.tficore.render.entity.RenderFuseRockPrimed;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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

    public void onServerStarted(FMLServerStartedEvent event) {
        super.onServerStarted(event);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void worldChange(WorldEvent.Load event) {
        if (Configs.isDimensionAllowed(event.getWorld().provider.getDimension())) {
            event.getWorld().provider.setCloudRenderer(CloudHandlerFix.INSTANCE);
        }
    }
}