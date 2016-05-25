package com.thefifthidiot.tficore.render;

import com.thefifthidiot.tficore.core.reference.Reference;
import com.thefifthidiot.tficore.core.registry.BlockRegistry;
import com.thefifthidiot.tficore.utility.LogHelper;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class BlockRenderer {
	public static void registerBlockRenderer() {
		registerBlock(BlockRegistry.testBlock, 0);
		registerMetaBlocks(BlockRegistry.testMetaBlock, 0, "potato_compr_single");
		registerMetaBlocks(BlockRegistry.testMetaBlock, 1, "potato_compr_double");
		registerMetaBlocks(BlockRegistry.testMetaBlock, 2, "potato_compr_triple");
		registerMetaBlocks(BlockRegistry.testMetaBlock, 3, "potato_compr_quadruple");
		registerMetaBlocks(BlockRegistry.testMetaBlock, 4, "potato_compr_quintuple");
		registerMetaBlocks(BlockRegistry.testMetaBlock, 5, "potato_compr_sextuple");
		registerMetaBlocks(BlockRegistry.testMetaBlock, 6, "potato_compr_septuple");
		registerMetaBlocks(BlockRegistry.testMetaBlock, 7, "potato_compr_octuple");
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
	
	public static void registerMetaBlocks(Block block, int meta, String file) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(Reference.MOD_ID + ":" + file, "inventory"));
	    LogHelper.info("Registered renderdata for block with registry-name: " + block.getRegistryName());
	}
}
