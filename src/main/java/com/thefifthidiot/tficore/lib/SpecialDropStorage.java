package com.thefifthidiot.tficore.lib;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabbe50 on 23/01/2017.
 */
public class SpecialDropStorage {
    public static List<Block> specialDropBlock;
    public static List<Item> specialDropItem;

    public static void init() {
        specialDropBlock = new ArrayList<>();
        specialDropItem = new ArrayList<>();
    }
}
