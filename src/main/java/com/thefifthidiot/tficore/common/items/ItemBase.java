package com.thefifthidiot.tficore.common.items;

import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import java.util.Random;
import java.util.function.Function;

import com.thefifthidiot.tficore.common.creativetabs.TFITab;
import com.thefifthidiot.tficore.core.registry.BlockRegistry;
import com.thefifthidiot.tficore.core.registry.ItemRegistry;
import com.thefifthidiot.tficore.lib.Configs;

public class ItemBase extends Item {

	public ItemBase(String itemName, CreativeTabs tab) {
		setItemName(this, itemName);
		setCreativeTab(tab != null ? tab : (Configs.tfitabs == true ? TFITab.itemTab : null));
	}
	
	public static void setItemName(Item item, String itemName) {
		item.setRegistryName(itemName);
		item.setUnlocalizedName(item.getRegistryName().toString());
	}
}
