package com.thefifthidiot.tficore.render;

import com.thefifthidiot.tficore.core.registry.ItemRegistry;
import com.thefifthidiot.tficore.utility.helper.LogHelper;

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
		registerItem(item, 0);
	}
	
	public static void registerItem(Item item, int meta) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		LogHelper.info("Registered renderdata for item with registry-name: " + item.getRegistryName());
	}
}
