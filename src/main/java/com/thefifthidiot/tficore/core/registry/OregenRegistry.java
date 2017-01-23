package com.thefifthidiot.tficore.core.registry;

import com.thefifthidiot.tficore.common.world.gen.GenWorldVeins;
import com.thefifthidiot.tficore.lib.Configs;
import net.minecraft.init.Blocks;

import java.util.Random;

/**
 * Created by fabbe50 on 22/09/2016.
 */
public class OregenRegistry {
    public static void init() {
        addOverworldOres();
        addNetherOres();
        addEndOres();
    }

    private static void addOverworldOres() {
        if (!Configs.disableFuseRock) {GenWorldVeins.addToOverworld(BlockRegistry.fuseRock, 2, 8, 4, 5, 68, Blocks.STONE);}
    }

    private static void addNetherOres() {
        if (!Configs.disableFuseRock) {GenWorldVeins.addToNether(BlockRegistry.fuseRockNether, 6, 14, 6, 10, 120, Blocks.NETHERRACK);}
    }

    private static void addEndOres() {
        if (!Configs.disableFuseRock) {GenWorldVeins.addToEnd(BlockRegistry.fuseRockEnd, 3, 11, 8, 10, 120, Blocks.END_STONE);}
    }
}
