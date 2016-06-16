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
        LogHelper.finfo("Adding Block-Renderer");
		registerBlock(BlockRegistry.testBlock, 0);

        LogHelper.finfo("Adding MetaBlock-Renderer");
		registerMetaBlockItem(BlockRegistry.testMetaBlock, 0, "single");
		registerMetaBlockItem(BlockRegistry.testMetaBlock, 1, "double");
		registerMetaBlockItem(BlockRegistry.testMetaBlock, 2, "triple");
		registerMetaBlockItem(BlockRegistry.testMetaBlock, 3, "quadruple");
		registerMetaBlockItem(BlockRegistry.testMetaBlock, 4, "quintuple");
		registerMetaBlockItem(BlockRegistry.testMetaBlock, 5, "sextuple");
		registerMetaBlockItem(BlockRegistry.testMetaBlock, 6, "septuple");
		registerMetaBlockItem(BlockRegistry.testMetaBlock, 7, "octuple");

	}
	
	/*	Register rendering!
	 * 	
	 * 	Call method by typing this in your registerBlockRenderer-class: BlockRenderer.registerBlock(<BLOCK_VAR>)
	 * 	Example: BlockRenderer.registerBlock(BlockRegistry.TestBlock);
	 */
	public static void registerBlock(Block block, int meta) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		LogHelper.finfo("Registered renderdata for block with registry-name: " + block.getRegistryName());
	}
	
	public static void registerMetaBlockItem(Block block, int meta, String type) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(block.getRegistryName(), "type=" + type));
		LogHelper.finfo("Registered renderdata for block with registry-name: " + block.getRegistryName() + "." + type);
	}
}
