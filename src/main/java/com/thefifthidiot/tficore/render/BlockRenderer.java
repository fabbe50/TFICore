package com.thefifthidiot.tficore.render;

import com.thefifthidiot.tficore.core.registry.BlockRegistry;
import com.thefifthidiot.tficore.utility.LogHelper;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class BlockRenderer {
	public static void registerBlockRenderer() {
        LogHelper.finfo("Adding Block-Renderer");
		registerBlock(BlockRegistry.testBlock);

        LogHelper.finfo("Adding MetaBlock-Renderer");

	}
	
	/*	Register rendering!
	 * 	
	 * 	Call method by typing this in your registerBlockRenderer-class: BlockRenderer.registerBlock(<BLOCK_VAR>)
	 * 	Example: BlockRenderer.registerBlock(BlockRegistry.TestBlock);
	 */
	public static void registerBlock(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		LogHelper.finfo("Registered renderdata for block with registry-name: " + block.getRegistryName());
	}
	
	public static void registerMetaBlockItem(Block block, int meta, String type) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(block.getRegistryName(), "type=" + type));
		LogHelper.finfo("Registered renderdata for block with registry-name: " + block.getRegistryName() + "." + type);
	}

    //Call this once for registering multiple metablocks at once.
    public static void registerMetaBlock (Block block, String[] values) {
        for (int i = 0; i < values.length; i++) {
            registerMetaBlockItem(block, i, values[i]);
        }
    }
}
