package com.thefifthidiot.tficore.common.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class TestBlock extends BlockBase {
	public TestBlock(Material material, MapColor mapColor, String blockName, float hardness, float resistance, @Nullable CreativeTabs tab) {
		super(material, mapColor, blockName, hardness, resistance, tab);
		
		//this.setCreativeTab(null); //Removes the block from the creative tab, this is only used if you really don't want the block to show up in a creative tab.
	}
}
