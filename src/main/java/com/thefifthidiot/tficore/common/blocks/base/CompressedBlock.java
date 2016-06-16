package com.thefifthidiot.tficore.common.blocks.base;

import javax.annotation.Nullable;

import com.thefifthidiot.tficore.common.blocks.meta.MetaCompressedBase;
import com.thefifthidiot.tficore.common.creativetabs.TFITab;
import com.thefifthidiot.tficore.core.interfaces.IMetaBlockName;
import com.thefifthidiot.tficore.core.reference.Reference;
import com.thefifthidiot.tficore.lib.Configs;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class CompressedBlock extends MetaCompressedBase{
	public CompressedBlock(Material material, MapColor blockMapColor, String modID, String name, float hardness, float resistance, @Nullable CreativeTabs tab) {
		super(material);
		this.setRegistryName(modID, name);
		this.setUnlocalizedName(this.getRegistryName().getResourcePath());
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setCreativeTab(tab != null ? tab : (Configs.tfitabs == true ? TFITab.blockTab : null));
	}
}