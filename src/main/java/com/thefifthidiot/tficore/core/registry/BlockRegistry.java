package com.thefifthidiot.tficore.core.registry;

import com.thefifthidiot.tficore.common.blocks.TestBlock;
import com.thefifthidiot.tficore.common.blocks.CompressedBlock;
import com.thefifthidiot.tficore.common.blocks.meta.MetaCompressedBase;
import com.thefifthidiot.tficore.common.items.ItemBlockMetaBase;
import com.thefifthidiot.tficore.core.reference.Reference;
import com.thefifthidiot.tficore.init.TFIBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegistry {
	/* 	Create Blocks
	 * 
	 * 	Code: private static final Block <VAR_NAME> = new BlockClassName(material, mapColor, name, hardness, resistance, creativeTab);
	 */
	public static final Block testBlock = new TestBlock(Material.rock, MapColor.stoneColor, "testBlock", 2.0f, 10.0f, null);
	public static final Block testMetaBlock = new MetaCompressedBase(Material.cake);
	
	public static void init() {
		/* Register Blocks
		 * 
		 * Code: TFIBlocks.addBlock(<VAR_NAME>);
		 */
		TFIBlocks.addBlock(testBlock);
		
		
		//MetaBlocks
		TFIBlocks.registerMetaBlock(Reference.MOD_ID + "potato_compr", testMetaBlock, );
	}
}
