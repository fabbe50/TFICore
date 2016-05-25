package com.thefifthidiot.tficore.common.items;

import java.util.function.Function;

import net.minecraft.creativetab.CreativeTabs;

public class TestItem extends ItemBase {
	public TestItem(String itemName, CreativeTabs tab) {
		super(itemName, tab);
		
		
		//this.setCreativeTab(null); //Removes the item from the creative tab, this is only used if you really don't want the item to show up in a creative tab.
	}
}
