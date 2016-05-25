package com.thefifthidiot.tficore.init;

import java.util.HashSet;
import java.util.Set;

import com.thefifthidiot.tficore.utility.LogHelper;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TFIItems {
	public static final Set<Item> ITEMS = new HashSet<>();
	
	public static <T extends Item> T registerItem(T item) {
		GameRegistry.register(item);
		ITEMS.add(item);
		
		LogHelper.info("Added item: " + item);
		
		return item;
	}
}
