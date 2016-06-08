package com.thefifthidiot.tficore.core.registry;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeRegistry {
	/*
	 * 
	 */
	public static void registerRecipe() {
		GameRegistry.addRecipe(new ItemStack(BlockRegistry.testBlock),
				new Object [] {
						"# #", //Top Line
						" d ", //Mid Line
						"# #", //Bottom Line
						'#', ItemRegistry.testItem, //Used Item
						'd', Blocks.DIRT //Used Item
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.testItem, 4),
				new Object[]{
						BlockRegistry.testBlock //Since we're making the recipe shapeless, we only have to declare the items used in the recipe.
				});
	}
}
