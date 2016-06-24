package com.thefifthidiot.tficore.core.registry;

import com.thefifthidiot.tficore.common.blocks.TestBlock;
import com.thefifthidiot.tficore.core.reference.Reference;
import com.thefifthidiot.tficore.init.TFIBlocks;

import com.thefifthidiot.tficore.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class BlockRegistry {
	/* 	Create Blocks
	 * 
	 * 	Code: private static final Block <VAR_NAME> = new BlockClassName(material, mapColor, name, hardness, resistance, creativeTab);
	 */
	public static final Block testBlock = new TestBlock(Material.ROCK, MapColor.STONE, "testBlock", 2.0f, 10.0f, null);
	
	public static void init() {
        LogHelper.finfo("Adding Blocks");
		/* Blocks
		 * 
		 * Code: TFIBlocks.addBlock(<VAR_NAME>);
		 */
		TFIBlocks.addBlock(testBlock);

        LogHelper.finfo("Done");
		LogHelper.finfo("Adding MetaBlocks");

        /* MetaBlocks
		 * 
		 * Code: TFIBlocks.registerMetaBlock(id, new ResourceLocation(MOD_ID, <FILE_NAME>), <VAR_NAME>);
		 */

        LogHelper.finfo("Done");
	}
}
