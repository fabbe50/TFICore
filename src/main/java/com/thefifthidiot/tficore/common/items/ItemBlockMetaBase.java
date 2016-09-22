package com.thefifthidiot.tficore.common.items;

import com.thefifthidiot.tficore.core.interfaces.IMetaBlockName;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMetaBase extends ItemBlock {
	String blockname;
	
    public ItemBlockMetaBase(Block block) {
        super(block);
        if (!(block instanceof IMetaBlockName)) {
            throw new IllegalArgumentException(String.format("The given Block %s is not an instance of IMetaBlockName!", block.getUnlocalizedName()));
        }
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.blockname = block.getRegistryName().getResourcePath();
    }

    public int getMetadata(int damage)
    {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "tile." + super.getRegistryName().getResourceDomain() + ":" + super.getRegistryName().getResourcePath() + "_" + ((IMetaBlockName)this.block).getSpecialName(stack);
    }
}
