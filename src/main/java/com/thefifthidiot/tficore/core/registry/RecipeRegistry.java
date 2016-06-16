package com.thefifthidiot.tficore.core.registry;

import com.thefifthidiot.tficore.utility.LogHelper;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeRegistry {
	/*
	 * 
	 */
	public static void registerRecipe() {
        LogHelper.finfo("Adding Shaped Recipes");

		GameRegistry.addRecipe(new ItemStack(BlockRegistry.testBlock),
				new Object [] {
						"# #", //Top Line
						" d ", //Mid Line
						"# #", //Bottom Line
						'#', ItemRegistry.testItem, //Used Item
						'd', Blocks.DIRT //Used Item
				}); //Craft testBlock using dirt and testItem

        LogHelper.finfo("Done");
        LogHelper.finfo("Adding Shapeless Recipes");

		GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.testItem, 4),
				new Object[]{
						BlockRegistry.testBlock //Since we're making the recipe shapeless, we only have to declare the items used in the recipe.
				}); //Craft testItem using testBlock

        LogHelper.finfo("Done");
	}
}
