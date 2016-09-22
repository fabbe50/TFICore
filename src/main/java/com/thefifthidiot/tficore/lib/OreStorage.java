package com.thefifthidiot.tficore.lib;

import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabbe50 on 22/09/2016.
 */
public class OreStorage {
    public static List<Block> overworldOre = new ArrayList<>();
    public static List<Integer> overworldMinSize = new ArrayList<>();
    public static List<Integer> overworldMaxSize = new ArrayList<>();
    public static List<Integer> overworldChance = new ArrayList<>();
    public static List<Integer> overworldMinY = new ArrayList<>();
    public static List<Integer> overworldMaxY = new ArrayList<>();
    public static List<Block> overworldSpawnIn = new ArrayList<>();

    public static List<Block> netherOre = new ArrayList<>();
    public static List<Integer> netherMinSize = new ArrayList<>();
    public static List<Integer> netherMaxSize = new ArrayList<>();
    public static List<Integer> netherChance = new ArrayList<>();
    public static List<Integer> netherMinY = new ArrayList<>();
    public static List<Integer> netherMaxY = new ArrayList<>();
    public static List<Block> netherSpawnIn = new ArrayList<>();

    public static List<Block> endOre = new ArrayList<>();
    public static List<Integer> endMinSize = new ArrayList<>();
    public static List<Integer> endMaxSize = new ArrayList<>();
    public static List<Integer> endChance = new ArrayList<>();
    public static List<Integer> endMinY = new ArrayList<>();
    public static List<Integer> endMaxY = new ArrayList<>();
    public static List<Block> endSpawnIn = new ArrayList<>();
}
