package com.thefifthidiot.tficore.common.items.tools;

import javax.annotation.Nullable;

import com.thefifthidiot.tficore.common.creativetabs.TFITab;
import com.thefifthidiot.tficore.core.reference.Reference;
import com.thefifthidiot.tficore.lib.Configs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.Item.ToolMaterial;

public class TestHoe extends ItemHoe {

	public TestHoe(String unlocalizedName, ToolMaterial material, @Nullable CreativeTabs tab) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(Reference.MOD_ID, unlocalizedName);
		this.setCreativeTab(tab != null ? tab : (Configs.tfitabs == true ? TFITab.itemTab : null));
	}
}
