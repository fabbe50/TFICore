package com.thefifthidiot.tficore.common.blocks.base;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/**
 * Created by fabbe50 on 23/09/2016.
 */
public class BlockLayeredBase extends BlockBase {
    private static BlockRenderLayer BRL;

    public BlockLayeredBase(Material material, MapColor mapColor, String blockName, float hardness, float resistance, @Nullable CreativeTabs tab, BlockRenderLayer BRL) {
        super(material, mapColor, blockName, hardness, resistance, tab);
        this.BRL = BRL;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BRL;
    }
}
