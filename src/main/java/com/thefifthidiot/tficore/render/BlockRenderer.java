package com.thefifthidiot.tficore.render;

import com.thefifthidiot.tficore.core.reference.Reference;
import com.thefifthidiot.tficore.core.registry.BlockRegistry;
import com.thefifthidiot.tficore.utility.LogHelper;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public final class BlockRenderer {
	public static void registerBlockRenderer() {
		registerBlock(BlockRegistry.testBlock, 0);
		registerMetaBlockItem(BlockRegistry.testMetaBlock, 0, "single");//, "potato_compr_single", "single");
		registerMetaBlockItem(BlockRegistry.testMetaBlock, 1, "double");//, "potato_compr_double", "double");
		registerMetaBlockItem(BlockRegistry.testMetaBlock, 2, "triple");//, "potato_compr_triple", "triple");
		registerMetaBlockItem(BlockRegistry.testMetaBlock, 3, "quadruple");//, "potato_compr_quadruple", "quadruple");
		registerMetaBlockItem(BlockRegistry.testMetaBlock, 4, "quintuple");//, "potato_compr_quintuple", "quintuple");
		registerMetaBlockItem(BlockRegistry.testMetaBlock, 5, "sextuple");//, "potato_compr_sextuple", "sextuple");
		registerMetaBlockItem(BlockRegistry.testMetaBlock, 6, "septuple");//, "potato_compr_septuple", "septuple");
		registerMetaBlockItem(BlockRegistry.testMetaBlock, 7, "octuple");//, "potato_compr_octuple", "octuple");
	}
	
	/*	Register rendering!
	 * 	
	 * 	Call method by typing this in your registerBlockRenderer-class: BlockRenderer.registerBlock(<BLOCK_VAR>)
	 * 	Example: BlockRenderer.registerBlock(BlockRegistry.TestBlock);
	 */
	public static void registerBlock(Block block, int meta) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		LogHelper.info("Registered renderdata for block with registry-name: " + block.getRegistryName());
	}
	
	public static void registerMetaBlockItem(Block block, int meta, String type) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(block.getRegistryName(), "type=" + type));
		LogHelper.info("Registered renderdata for block with registry-name: " + block.getRegistryName() + "." + type);
	}
	
	public static void registerMetaBlocks(Block block, int meta, String type) {
		//ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(block.getRegistryName(), "type=" + type));
	    //Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(Reference.MOD_ID + ":" + file, "inventory"));
	    LogHelper.info("Registered renderdata for block with registry-name: " + block.getRegistryName());
	}
	
	private static String getItemResourceLocation(Block block, String string) {
		LogHelper.info(block.getRegistryName() + "_" + string);
		return block.getRegistryName() + "_" + string;
	}
}
