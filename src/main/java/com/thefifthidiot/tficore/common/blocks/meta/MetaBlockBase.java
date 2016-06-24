package com.thefifthidiot.tficore.common.blocks.meta;

import java.util.List;

import com.thefifthidiot.tficore.core.interfaces.IMetaBlockName;

import com.thefifthidiot.tficore.lib.EnumCompressed;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

@SuppressWarnings("deprecation, unchecked")
public class MetaBlockBase extends Block implements IMetaBlockName{
	public MetaBlockBase(Material material) {
        super(material);
        /*  Add this line here too:
         *      this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumCompressed.SINGLE));
         */
    }
	
	@Override
	protected BlockStateContainer createBlockState() {
        return null;
        /*  Usage in class extending this:
	     *      return new BlockStateContainer(this, new IProperty[] { TYPE });
	     */
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
	    return this.getDefaultState();
        /*  Usage in class extending this:
         *      return this.getDefaultState().withProperty(TYPE, EnumCompressed.byMetadata(meta));
         */
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return 0;
        /*  Usage in class extending this:
         *  return ((EnumType) state.getValue(TYPE)).getMetadata();
         */
	}
	
	@Override
	public int damageDropped(IBlockState state) {
        return 0;
        /*  Usage in class extending this:
         *  return ((EnumType) state.getValue(TYPE)).getMetadata();
         */
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
        /*  Usage in class extending this:
         *  for (EnumType type : EnumType.values()) {
         *      list.add(new ItemStack(item, 1, type.getMetadata()))
         *  }
         */
	}

	@Override
	public String getSpecialName(ItemStack stack) {
	    return null;
        /*  Example of usage 1:
         *      if (stack.getItemDamage() == 0)
         *          return "name1";
         *      else if (stack.getItemDamage() == 1)
         *          return "name2";
         *      else if (stack.getItemDamage() == 2)
         *          return "name3"
         *      else
         *          return "name1"
         *
         *  Example of usage 2:
         *      return stack.getItemDamage() == 0 ? "name1" :
         *              (stack.getItemDamage() == 1 ? "name2" :
         *                  (stack.getItemDamage() == 2 ? "name3" : "name1"));
         */
	}
}
