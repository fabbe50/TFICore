package com.thefifthidiot.tficore.init;

import javax.annotation.Nullable;

import com.thefifthidiot.tficore.common.items.ItemBlockMetaBase;
import com.thefifthidiot.tficore.render.ItemRenderer;
import com.thefifthidiot.tficore.utility.helper.LogHelper;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
        LogHelper.finfo("Added Block: " + block.getRegistryName());
        return block;
    }
    
    public static void registerMetaBlock(ResourceLocation location, Block block) {
    	Block.REGISTRY.register(0, location, block);
    	ItemBlock ie = new ItemBlockMetaBase(block);
    	GameRegistry.register(ie.setRegistryName(block.getRegistryName()));

    	blocks.add(block);
        LogHelper.finfo("Added MetaBlock: " + block.getRegistryName());
    }

    private static final Map<Block, Item> BLOCK_TO_ITEM = net.minecraftforge.fml.common.registry.GameData.getBlockItemMap();
    @SuppressWarnings("deprecation")
    public static final RegistryNamespaced<ResourceLocation, Item> REGISTRY = net.minecraftforge.fml.common.registry.GameData.getItemRegistry();;

    public static void registerBlockWithItemBlock(Block block, ItemBlock itemBlock) {
        GameRegistry.register(block);
        registerItemBlock(block, itemBlock);
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemBlockRenderer(Item item) {
        ItemRenderer.registerItem(item);
    }

    protected static void registerItemBlock(Block blockIn, Item itemIn) {
        registerItem(Block.getIdFromBlock(blockIn), (ResourceLocation)Block.REGISTRY.getNameForObject(blockIn), itemIn);
        BLOCK_TO_ITEM.put(blockIn, itemIn);
    }

    private static void registerItem(int id, String textualID, Item itemIn) {
        registerItem(id, new ResourceLocation(textualID), itemIn);
    }

    private static void registerItem(int id, ResourceLocation textualID, Item itemIn) {
        REGISTRY.register(id, textualID, itemIn);
    }
}
