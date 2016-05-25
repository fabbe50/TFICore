package com.thefifthidiot.tficore.common.creativetabs;

import com.thefifthidiot.tficore.core.reference.Reference;
import com.thefifthidiot.tficore.core.registry.BlockRegistry;
import com.thefifthidiot.tficore.core.registry.ItemRegistry;
import com.thefifthidiot.tficore.init.TFIBlocks;
import com.thefifthidiot.tficore.lib.Configs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class TFITab {
    public static CreativeTabs blockTab = Configs.tfitabs == true ? new CreativeTabs(Reference.MOD_ID.toLowerCase() + ".blocks") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(BlockRegistry.testBlock);
        }
    } : null;
	public static CreativeTabs itemTab = Configs.tfitabs == true ? new CreativeTabs(Reference.MOD_ID.toLowerCase() + ".items") {
        @Override
        public Item getTabIconItem() {
            return ItemRegistry.testItem;
        }
    } : null;
}
