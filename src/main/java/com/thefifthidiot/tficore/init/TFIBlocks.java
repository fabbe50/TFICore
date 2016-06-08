package com.thefifthidiot.tficore.init;

import javax.annotation.Nullable;

import com.thefifthidiot.tficore.TFICore;
import com.thefifthidiot.tficore.common.blocks.base.BlockBase;
import com.thefifthidiot.tficore.common.items.ItemBlockMetaBase;
import com.thefifthidiot.tficore.core.reference.Reference;
import com.thefifthidiot.tficore.utility.LogHelper;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.discovery.asm.ModAnnotation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TFIBlocks {
	public static final Set<Block> blocks = new HashSet<>();
	
    public static <T extends Block> void addBlock(T blockClass) {
        try {
        	registerBlock(blockClass);
        }
        catch(Exception e) {
        	LogHelper.error(e);
        }
    }

    protected static <T extends Block> T registerBlock(T block) {
        return registerBlock(block, ItemBlock::new);
    }

    protected static <BLOCK extends Block> BLOCK registerBlock(BLOCK block, @Nullable Function<BLOCK, ItemBlock> itemFactory) {
        GameRegistry.register(block);

        if (itemFactory != null) {
            final ItemBlock itemBlock = itemFactory.apply(block);

            GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
        }

        blocks.add(block);
        return block;
    }
    
    public static void registerMetaBlock(int id, ResourceLocation location, Block block) {
    	//GameRegistry.register((block).setHardness(hardness).setResistance(resistance));
    	
    	//block.setUnlocalizedName(block.getRegistryName().toString());
    	
    	Block.REGISTRY.register(id, location, block);
    	
    	ItemBlock ie = new ItemBlockMetaBase(block);
    	
    	GameRegistry.register(ie.setRegistryName(block.getRegistryName()).setUnlocalizedName(block.getRegistryName().getResourcePath()));
    	
//    	Function<Block, ItemBlock> itemFactory = ItemBlock::new;
//    	if (itemFactory != null) {
//            final ItemBlock itemBlock = itemFactory.apply(block);
//            
//            
//            
//            GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
//        }
    	
    	blocks.add(block);
    }
}
