package com.thefifthidiot.tficore.core.handler;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

/**
 * Created by fabbe50 on 22/09/2016.
 */
public class OregenHandler {
    /*
     *  @param block : The block you want to generate.
     *  @param world : The current world.
     *  @param random : A random.
     *  @param chunkX : Current chunk on X-Axis.
     *  @param chunkZ : Current chunk on Z-Axis.
     *  @param minVeinSize : Minimum amount of blocks in the vein.
     *  @param maxVeinSize : Maximum amount of blocks in the vein.
     *  @param chance : How many times it's gonna try to place the vein (Higher means more veins).
     *  @param minY : How low in the world it can spawn.
     *  @param maxY : How high in the world it can spawn.
     *  @param generateIn : In what block can it spawn.
     *
     *  For an example on how to use this, please refer to "com.thefifthidiot.tficore.common.world.gen.GenWorldVeins".
     */

    public static void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVeinSize, int maxVeinSize, int chance, int minY, int maxY, Block generateIn) {
        int veinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize);
        int heightRange = maxY - minY;
        WorldGenMinable gen = new WorldGenMinable(block.getDefaultState(), veinSize, BlockMatcher.forBlock(generateIn));
        for(int i = 0; i < chance; i++) {
            int xRand = chunkX * 16 + random.nextInt(16);
            int yRand = random.nextInt(heightRange) + minY;
            int zRand = chunkZ * 16 + random.nextInt(16);
            gen.generate(world, random, new BlockPos(xRand, yRand, zRand));
        }
    }
}
