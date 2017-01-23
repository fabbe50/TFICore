package com.thefifthidiot.tficore.init;

import java.util.HashSet;
import java.util.Set;

import com.thefifthidiot.tficore.utility.IVariant;
import com.thefifthidiot.tficore.utility.LogHelper;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TFIItems {
	public static final Set<Item> ITEMS = new HashSet<>();
	
	public static <T extends Item> T registerItem(T item) {
		GameRegistry.register(item);
		ITEMS.add(item);
		
		LogHelper.info("Added item: " + item.getRegistryName());
		
		return item;
	}

    private static final Set<Item> itemsRegistered = new HashSet<>();

    private static <T extends IVariant> void registerVariantItemModels(Item item, String variantName, T[] variants) {
        for (T variant : variants) {
            registerItemModelForMeta(item, variant.getMeta(), variantName + "=" + variant.getName());
        }
    }

    private static void registerItemModelForMeta(Item item, int metadata, String variant) {
        registerItemModelForMeta(item, metadata, new ModelResourceLocation(item.getRegistryName(), variant));
    }

    private static void registerItemModelForMeta(Item item, int metadata, ModelResourceLocation modelResourceLocation) {
        itemsRegistered.add(item);
        ModelLoader.setCustomModelResourceLocation(item, metadata, modelResourceLocation);
    }
}
