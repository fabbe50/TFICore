package com.thefifthidiot.tficore.common.blocks;

import javax.annotation.Nullable;

import com.thefifthidiot.tficore.common.blocks.base.BlockBase;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class TestBlock extends BlockBase {
	public TestBlock(Material material, MapColor mapColor, String blockName, float hardness, float resistance, @Nullable CreativeTabs tab) {
		super(material, mapColor, blockName, hardness, resistance, tab);
		
		//this.setCreativeTab(null); //Removes the block from the creative tab, this is only used if you really don't want the block to show up in a creative tab.
	}

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (playerIn.isSneaking()) {
            worldIn.destroyBlock(pos, true);
            return true;
        }
        return false;
    }

}
