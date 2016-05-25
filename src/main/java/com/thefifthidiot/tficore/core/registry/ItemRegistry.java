package com.thefifthidiot.tficore.core.registry;

import com.thefifthidiot.tficore.common.creativetabs.TFITab;
import com.thefifthidiot.tficore.common.items.TestItem;
import com.thefifthidiot.tficore.common.items.tools.TestAxe;
import com.thefifthidiot.tficore.common.items.tools.TestHoe;
import com.thefifthidiot.tficore.common.items.tools.TestPickaxe;
import com.thefifthidiot.tficore.common.items.tools.TestShovel;
import com.thefifthidiot.tficore.common.items.tools.TestSword;
import com.thefifthidiot.tficore.init.TFIItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

/*
 * 	This is the basic structure for an ItemRegistry-class.
 * 	Feel free to copy this as a template if using the API.
 */
public class ItemRegistry {
	//Tools
	public static ToolMaterial testTools = EnumHelper.addToolMaterial("testTools", 3, 2000, 12.0f, 5.0f, 10);
	
	//public static final Item testPickaxe;
	//public static final Item testSword;
	//public static final Item testAxe;
	//public static final Item testShovel;
	//public static final Item testHoe;
	
	//Variable names for items
	public static final Item testItem;
	
	static {
		/*	Register Item
		 *	
		 *	If you just want a generic item for crafting etc.
		 *	Code: <VAR_NAME> = TFIItems.registerItem(new ItemBase("itemName", creativeTab));
		 *	
		 *	If you want an item with special functionality.
		 *	Code: <VAR_NAME> = TFIItems.registerItem(new ItemClassName("itemName", creativeTab);
		 *	
		 *	@param itemName - sets the unlocalized name of the item
		 *	@param creativeTab - assigns creative tab.
		 */	
		
		//Tools
		//testPickaxe = TFIItems.registerItem(new TestPickaxe("testPickaxe", testTools, null));
		//testSword = TFIItems.registerItem(new TestSword("testSword", testTools, null));
		//testAxe = TFIItems.registerItem(new TestAxe("testAxe", testTools, null));
		//testShovel = TFIItems.registerItem(new TestShovel("testShovel", testTools, null));
		//testHoe = TFIItems.registerItem(new TestHoe("testHoe", testTools, null));
		
		//Items
		testItem = TFIItems.registerItem(new TestItem("testItem", null));
	}
	
	public static void init() {}; //Makes sure the static field is registered
}
