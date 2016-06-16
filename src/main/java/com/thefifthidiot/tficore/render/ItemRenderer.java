package com.thefifthidiot.tficore.render;

import com.thefifthidiot.tficore.core.registry.ItemRegistry;
import com.thefifthidiot.tficore.utility.LogHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ItemRenderer {
	public static void registerItemRenderer() {
        LogHelper.finfo("Adding Item-renderer");

		registerItem(ItemRegistry.testItem);
		//registerItem(ItemRegistry.testPickaxe);
		//registerItem(ItemRegistry.testSword);
		//registerItem(ItemRegistry.testAxe);
		//registerItem(ItemRegistry.testShovel);
		//registerItem(ItemRegistry.testHoe);
	}
	
	public static void registerItem(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		LogHelper.info("Registered renderdata for item with registry-name: " + item.getRegistryName());
	}
}
