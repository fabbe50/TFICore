package com.thefifthidiot.tficore.common.blocks.base;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.thefifthidiot.tficore.common.creativetabs.TFITab;
import com.thefifthidiot.tficore.core.registry.BlockRegistry;
import com.thefifthidiot.tficore.core.registry.ItemRegistry;
import com.thefifthidiot.tficore.lib.Configs;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/*	This is a class that holds the basic block settings.
 * 
 * 	To create a block with this API, please extend this class. (I will only help if this is the used class)
 * 	If you want to change something with this class, please override the function in that case.
 * 
 */
public class BlockBase extends Block {
	public static float hardness = 1f;
	public static float resistance = 1f;
	public static CreativeTabs tab = null;
	public static List<Block> specialDropBlock;
	public static List<Item> specialDropItem;
	
	public BlockBase(Material material, MapColor mapColor, String blockName, float hardness, float resistance, @Nullable CreativeTabs tab) {
        super(material, mapColor);
        setBlockName(this, blockName);
        this.tab = tab;
        this.setCreativeTab(tab != null ? tab : (Configs.tfitabs == true ? TFITab.blockTab : null));
        this.hardness = hardness;
        this.resistance = resistance;
        setHardness(this.hardness);
        setResistance(this.resistance);
    }

    public BlockBase(Material materialIn, String blockName) {
        this(materialIn, materialIn.getMaterialMapColor(), blockName, getHardness(), getResistance(), tab);
    }

    private static float getResistance() {
		return BlockBase.resistance;
	}
    
    private static float getHardness() {
		return BlockBase.hardness;
	}

	public static void setBlockName(Block block, String blockName) {
        block.setRegistryName(blockName);
        block.setUnlocalizedName(block.getRegistryName().toString());
    }
	
	public static void registerSpecialDrop(Item item, Block block) {
		specialDropBlock.add(block);
		specialDropItem.add(item);
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return specialDropBlock.contains(this) ? specialDropItem.get(specialDropBlock.indexOf(this)) : Item.getItemFromBlock(this);
	}
}
