package com.thefifthidiot.tficore.common.world.gen;

import com.thefifthidiot.tficore.core.registry.BlockRegistry;
import com.thefifthidiot.tficore.core.handler.OregenHandler;
import com.thefifthidiot.tficore.lib.OreStorage;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import scala.Int;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by fabbe50 on 27/08/2016.
 */
public class GenWorldVeins implements IWorldGenerator {
    @Override
    @SubscribeEvent
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimensionType()) {
            case OVERWORLD:
                generateOverworld(world, random, chunkX, chunkZ);
                break;
            case NETHER:
                generateNether(world, random, chunkX, chunkZ);
                break;
            case THE_END:
                generateEnd(world, random, chunkX, chunkZ);
                break;
        }
    }

    public void generateOverworld(World world, Random rand, int x, int z) {
        for (int i = 0; i < OreStorage.overworldOre.size(); i++) {
            OregenHandler.generateOre(
                    OreStorage.overworldOre.get(i),
                    world, rand, x, z,
                    OreStorage.overworldMinSize.get(i),
                    OreStorage.overworldMaxSize.get(i),
                    OreStorage.overworldChance.get(i),
                    OreStorage.overworldMinY.get(i),
                    OreStorage.overworldMaxY.get(i),
                    OreStorage.overworldSpawnIn.get(i));
        }
    }

    public void generateNether(World world, Random rand, int x, int z) {
        for (int i = 0; i < OreStorage.netherOre.size(); i++) {
            OregenHandler.generateOre(
                    OreStorage.netherOre.get(i),
                    world, rand, x, z,
                    OreStorage.netherMinSize.get(i),
                    OreStorage.netherMaxSize.get(i),
                    OreStorage.netherChance.get(i),
                    OreStorage.netherMinY.get(i),
                    OreStorage.netherMaxY.get(i),
                    OreStorage.netherSpawnIn.get(i));
        }
    }

    public void generateEnd(World world, Random rand, int x, int z) {
        for (int i = 0; i < OreStorage.endOre.size(); i++) {
            OregenHandler.generateOre(
                    OreStorage.endOre.get(i),
                    world, rand, x, z,
                    OreStorage.endMinSize.get(i),
                    OreStorage.endMaxSize.get(i),
                    OreStorage.endChance.get(i),
                    OreStorage.endMinY.get(i),
                    OreStorage.endMaxY.get(i),
                    OreStorage.endSpawnIn.get(i));
        }
    }

    /*
     *  @param block : The block you want to generate.
     *  @param minVeinSize : Minimum amount of blocks in the vein.
     *  @param maxVeinSize : Maximum amount of blocks in the vein.
     *  @param chance : How many times it's gonna try to place the vein (Higher means more veins).
     *  @param minY : How low in the world it can spawn.
     *  @param maxY : How high in the world it can spawn.
     *  @param generateIn : In what block can it spawn.
     *
     *  Example on usage at "com.thefifthidiot.tficore.core.registry.OregenRegistry"
     */
    @SuppressWarnings("unchecked")
    public static void addToOverworld(Block block, int minSize, int maxSize, int chance, int minY, int maxY, Block spawnIn) {
        int i = OreStorage.overworldOre.size();
        OreStorage.overworldOre.add(i, block);
        OreStorage.overworldMinSize.add(i, minSize);
        OreStorage.overworldMaxSize.add(i, maxSize);
        OreStorage.overworldChance.add(i, chance);
        OreStorage.overworldMinY.add(i, minY);
        OreStorage.overworldMaxY.add(i, maxY);
        OreStorage.overworldSpawnIn.add(i, spawnIn);
    }

    /*
     *  @param block : The block you want to generate.
     *  @param minVeinSize : Minimum amount of blocks in the vein.
     *  @param maxVeinSize : Maximum amount of blocks in the vein.
     *  @param chance : How many times it's gonna try to place the vein (Higher means more veins).
     *  @param minY : How low in the world it can spawn.
     *  @param maxY : How high in the world it can spawn.
     *  @param generateIn : In what block can it spawn.
     *
     *  Example on usage at "com.thefifthidiot.tficore.core.registry.OregenRegistry"
     */
    @SuppressWarnings("unchecked")
    public static void addToNether(Block block, int minSize, int maxSize, int chance, int minY, int maxY, Block spawnIn) {
        int i = OreStorage.netherOre.size();
        OreStorage.netherOre.add(i, block);
        OreStorage.netherMinSize.add(i, minSize);
        OreStorage.netherMaxSize.add(i, maxSize);
        OreStorage.netherChance.add(i, chance);
        OreStorage.netherMinY.add(i, minY);
        OreStorage.netherMaxY.add(i, maxY);
        OreStorage.netherSpawnIn.add(i, spawnIn);
    }

    /*
     *  @param block : The block you want to generate.
     *  @param minVeinSize : Minimum amount of blocks in the vein.
     *  @param maxVeinSize : Maximum amount of blocks in the vein.
     *  @param chance : How many times it's gonna try to place the vein (Higher means more veins).
     *  @param minY : How low in the world it can spawn.
     *  @param maxY : How high in the world it can spawn.
     *  @param generateIn : In what block can it spawn.
     *
     *  Example on usage at "com.thefifthidiot.tficore.core.registry.OregenRegistry"
     */
    @SuppressWarnings("unchecked")
    public static void addToEnd(Block block, int minSize, int maxSize, int chance, int minY, int maxY, Block spawnIn) {
        int i = OreStorage.endOre.size();
        OreStorage.endOre.add(i, block);
        OreStorage.endMinSize.add(i, minSize);
        OreStorage.endMaxSize.add(i, maxSize);
        OreStorage.endChance.add(i, chance);
        OreStorage.endMinY.add(i, minY);
        OreStorage.endMaxY.add(i, maxY);
        OreStorage.endSpawnIn.add(i, spawnIn);
    }
}
