package com.thefifthidiot.tficore;

import com.thefifthidiot.tficore.common.blocks.TestBlock;
import com.thefifthidiot.tficore.core.event.WorldEvents;
import com.thefifthidiot.tficore.core.proxy.CommonProxy;
import com.thefifthidiot.tficore.core.reference.Reference;
import com.thefifthidiot.tficore.core.registry.BlockRegistry;
import com.thefifthidiot.tficore.core.registry.ItemRegistry;
import com.thefifthidiot.tficore.init.TFIBlocks;
import com.thefifthidiot.tficore.lib.Configs;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;

/*	Hello and welcome to the main mod-class, this is where your mod is born.
 * 	
 * 	First off, you declare it your main modclass like below.
 * 	@param name = the name of your mod
 * 	@param modid = your mods id, this is what makes your mod unique.
 * 	@param version = this is how you tell the game what version of the mod is running.
 */

@Mod(name = Reference.MOD_NAME, modid = Reference.MOD_ID, version = Reference.VERSION)
public class TFICore
{
	//Creating an instance of your mod is as simple as this:
	@Instance(Reference.MOD_ID)
	public static TFICore instance;
	
	/*	Creating a proxy is not required in a simple mod, but is very useful. 
	 * 	The CommonProxy is set to run on the game server.
	 * 	The ClientProxy is set to only run on the client side.	
	 * 	
	 *	You do it like so:
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
		this.proxy.preInit(event);
	}
	
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	this.proxy.init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	this.proxy.postInit(event);
    }
    
    @EventHandler
    public void onServerStart(FMLServerStartedEvent event) {
    	if(Configs.disableRain){MinecraftForge.EVENT_BUS.register(new WorldEvents());}
    }
}
