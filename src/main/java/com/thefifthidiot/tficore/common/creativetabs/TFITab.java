package com.thefifthidiot.tficore.common.creativetabs;

import com.thefifthidiot.tficore.core.reference.Reference;
import com.thefifthidiot.tficore.core.registry.BlockRegistry;
import com.thefifthidiot.tficore.core.registry.ItemRegistry;
import com.thefifthidiot.tficore.lib.Configs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TFITab {
    public static CreativeTabs blockTab = Configs.tfitabs == true ? new CreativeTabs(Reference.MOD_ID.toLowerCase() + ".blocks") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Item.getItemFromBlock(BlockRegistry.testBlock));
        }
    } : null;
	public static CreativeTabs itemTab = Configs.tfitabs == true ? new CreativeTabs(Reference.MOD_ID.toLowerCase() + ".items") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemRegistry.testItem);
        }
    } : null;
}
