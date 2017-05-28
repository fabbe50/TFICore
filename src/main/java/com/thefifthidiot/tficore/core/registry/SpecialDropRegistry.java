package com.thefifthidiot.tficore.core.registry;

import com.thefifthidiot.tficore.lib.Configs;
import com.thefifthidiot.tficore.lib.SpecialDropStorage;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;
import java.util.Locale;

public class SpecialDropRegistry {
    public static void registerSpecialDrop(Item item, Block block) {
        registerSpecialDrop(block, item);
    }

    public static void registerSpecialDrop(Block block, Item item) {
        SpecialDropStorage.specialDropBlock.add(block);
        SpecialDropStorage.specialDropItem.add(item);
    }

	public static void registerSpecialDrops() {
		registerSpecialDrop(ItemRegistry.testItem, BlockRegistry.testBlock);


        //Experimental Ore-override
        if (Loader.isModLoaded(Configs.oreFromMod)) {
            List<String> oreList = getOreList();
            for (int i = 0; i < oreList.size(); i++) {
                replaceOre(oreList.get(i));
            }
        }
	}

    private static List<String> getOreList() {
        List<String> added = null;

        added.add(0, "oreCopper");
        added.add(1, "oreSilver");
        added.add(2, "oreTin");
        added.add(3, "oreLead");

        return added;
    }

    private static void replaceOre(String oreDictEntry) {
        List<ItemStack> ores = getOres2(oreDictEntry);
        for (int i = 0; i < ores.size(); i++) {
            registerSpecialDrop(getSetItem(ores), Block.getBlockFromItem(ores.get(i).getItem()));
        }
    }

    private static List<ItemStack> getOres2(String oreDictEntry) {
        return OreDictionary.getOres(oreDictEntry);
    }

    private static Item getSetItem(List<ItemStack> itemStackList) {
        for (int i = 0; i < itemStackList.size(); i++) {
            if (getModNameFromItem(itemStackList.get(i)) == Configs.oreFromMod) {
                return itemStackList.get(i).getItem();
            }
        }
        return null;
    }

    @SuppressWarnings("deprecation")
    private static String getModNameFromItem(ItemStack stack) {
        try {
            ResourceLocation resource = GameData.getItemRegistry().getNameForObject(stack.getItem());
            ModContainer mod = findModContainer(resource.getResourceDomain());
            return mod == null ? "Minecraft" : mod.getName();
        }
        catch (NullPointerException e) {
            return "";
        }
    }

    private static ModContainer findModContainer (String domain) {
        for (ModContainer mc : Loader.instance().getModList())
            if (domain.toLowerCase(Locale.US).equals(mc.getModId().toLowerCase(Locale.US)))
                return mc;
        return null;
    }
}