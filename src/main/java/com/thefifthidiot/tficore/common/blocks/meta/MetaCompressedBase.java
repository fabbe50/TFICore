package com.thefifthidiot.tficore.common.blocks.meta;

import java.util.List;

import com.thefifthidiot.tficore.core.interfaces.IMetaBlockName;

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
	
	public enum EnumType implements IStringSerializable {
	    SINGLE(0, "single", "9"),
	    DOUBLE(1, "double", "81"),
	    TRIPLE(2, "triple", "729"),
	    QUADRUPLE(3, "quadruple", "6,561"),
	    QUINTUPLE(4, "quintuple", "59,049"),
	    SEXTUPLE(5, "sextuple", "531,441"),
	    SEPTUPLE(6, "septuple", "4,782,969"),
	    OCTUPLE(7, "octuple", "43,046,721");
		
		private static final EnumType[] META_LOOKUP = new EnumType[values().length];
		private int meta;
		private String name;
        private String tooltip;
		
		private EnumType(int meta, String name, String tooltip) {
			this.name = name;
			this.meta = meta;
            this.tooltip = tooltip;
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

        public String getTooltip() {
            return this.tooltip;
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
