package com.thefifthidiot.tficore.core.registry;

import com.thefifthidiot.tficore.common.blocks.TestBlock;
import com.thefifthidiot.tficore.common.blocks.base.CompressedBlock;
import com.thefifthidiot.tficore.common.blocks.meta.MetaCompressedBase;
import com.thefifthidiot.tficore.common.creativetabs.TFITab;
import com.thefifthidiot.tficore.common.items.ItemBlockMetaBase;
import com.thefifthidiot.tficore.core.reference.Reference;
import com.thefifthidiot.tficore.init.TFIBlocks;

import com.thefifthidiot.tficore.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegistry {
	/* 	Create Blocks
	 * 
	 * 	Code: private static final Block <VAR_NAME> = new BlockClassName(material, mapColor, name, hardness, resistance, creativeTab);
	 */
	public static final Block testBlock = new TestBlock(Material.ROCK, MapColor.STONE, "testBlock", 2.0f, 10.0f, null);
	//public static final Block testMetaBlock = new MetaCompressedBase(Material.cake).setHardness(2.0f).setResistance(10.0f).setRegistryName(Reference.MOD_ID, "potato_compr").setCreativeTab(TFITab.blockTab).setUnlocalizedName("potato_compr");
	public static final Block testMetaBlock = new CompressedBlock(Material.CAKE, MapColor.BROWN, Reference.MOD_ID, "potato_compr", 2.0f, 10.0f, null);
	
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
		TFIBlocks.registerMetaBlock(0, new ResourceLocation(Reference.MOD_ID, "potato_compr"), testMetaBlock);

        LogHelper.finfo("Done");
	}
}
