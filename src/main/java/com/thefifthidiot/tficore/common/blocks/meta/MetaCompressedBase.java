package com.thefifthidiot.tficore.common.blocks.meta;

import java.util.List;

import javax.annotation.Nullable;

import com.thefifthidiot.tficore.common.creativetabs.TFITab;
import com.thefifthidiot.tficore.core.interfaces.IMetaBlockName;
import com.thefifthidiot.tficore.lib.Configs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

@SuppressWarnings("unchecked")
public class MetaCompressedBase extends Block implements IMetaBlockName{
	public static final PropertyEnum TYPE = PropertyEnum.create("type", MetaCompressedBase.EnumType.class);
	
	public MetaCompressedBase(Material material) {
        super(material);
        setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumType.SINGLE));
    }
	
	@Override
	protected BlockStateContainer createBlockState() {
	    return new BlockStateContainer(this, new IProperty[] { TYPE });
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
	    return this.getDefaultState().withProperty(TYPE, EnumType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumType) state.getValue(TYPE)).getMetadata();
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return ((EnumType)state.getValue(TYPE)).getMetadata();
	}
	
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		for (EnumType type : EnumType.values()) {
            list.add(new ItemStack(itemIn, 1, type.getMetadata()));
        }
	}
	
//	@Override
//	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos) {
//	    return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
//	}
	
	public enum EnumType implements IStringSerializable {
	    SINGLE(0, "single"),
	    DOUBLE(1, "double"),
	    TRIPLE(2, "triple"),
	    QUADRUPLE(3, "quadruple"),
	    QUINTUPLE(4, "quintuple"),
	    SEXTUPLE(5, "sextuple"),
	    SEPTUPLE(6, "septuple"),
	    OCTUPLE(7, "octuple");
		
		private static final EnumType[] META_LOOKUP = new EnumType[values().length];
		private int meta;
		private String name;
		
		private EnumType(int meta, String name) {
			this.name = name;
			this.meta = meta;
		}
		
		public String getUnlocalizedName() {
			return this.name;
		}
		
		public String getName() {
			return this.name;
		}
		
		public int getMetadata() {
			return this.meta;
		}

	    public static EnumType byMetadata(int meta){
	        if (meta < 0 || meta >= META_LOOKUP.length) {
	            meta = 0;
	        }
	        return META_LOOKUP[meta];
	    }
		
		static{
	        for (EnumType e : values()){
	            META_LOOKUP[e.getMetadata()] = e;
	        }
	    }
	}

	@Override
	public String getSpecialName(ItemStack stack) {
	    return stack.getItemDamage() == 0 ? "single" : 
	    	(stack.getItemDamage() == 1 ? "double" : 
	    		(stack.getItemDamage() == 2 ? "triple" : 
	    			(stack.getItemDamage() == 3 ? "quadruple" : 
	    				(stack.getItemDamage() == 4 ? "quintuple" : 
	    					(stack.getItemDamage() == 5 ? "sextuple" : 
	    						(stack.getItemDamage() == 6 ? "septuple" : 
	    							(stack.getItemDamage() == 7 ? "octuple" : "single")))))));
	}
}
