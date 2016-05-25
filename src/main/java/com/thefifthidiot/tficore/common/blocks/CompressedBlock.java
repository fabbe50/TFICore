package com.thefifthidiot.tficore.common.blocks;

import javax.annotation.Nullable;

import com.thefifthidiot.tficore.common.creativetabs.TFITab;
import com.thefifthidiot.tficore.core.interfaces.IMetaBlockName;
import com.thefifthidiot.tficore.core.reference.Reference;
import com.thefifthidiot.tficore.lib.Configs;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class CompressedBlock extends BlockBase{
	public CompressedBlock(Material material, MapColor blockMapColor, String modID, String name, float hardness, float resistance, @Nullable CreativeTabs tab) {
		super(material, blockMapColor, name, resistance, resistance, tab);
	}
}