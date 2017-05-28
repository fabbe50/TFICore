package com.thefifthidiot.tficore.init;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * Created by fabbe50 on 28/04/2017.
 */
public class TFIEntity {
    public static void createEntity(ResourceLocation registryName, Class<? extends Entity> entityClass, String entityName, Object mod, int id, int viewDistance, int updateFrequency, boolean sendVelocityUpdates,
                                    int solidColor, int spotColor, int spawnWeight, int min, int max, EnumCreatureType enumCreatureType, Biome... biomes) {
        EntityRegistry.registerModEntity(registryName, entityClass, entityName, id, mod, viewDistance, updateFrequency, sendVelocityUpdates);
        EntityRegistry.addSpawn((Class<? extends EntityLiving>)entityClass, spawnWeight, min, max, enumCreatureType, biomes);
        createEgg(registryName, solidColor, spotColor);
    }

    public static void createEntity(ResourceLocation registryName, Class<? extends Entity> entityClass, String entityName, Object mod, int id, int viewDistance, int updateFrequency, boolean sendVelocityUpdates,
                                    int spawnWeight, int min, int max, EnumCreatureType enumCreatureType, Biome... biomes) {
        EntityRegistry.registerModEntity(registryName, entityClass, entityName, id, mod, viewDistance, updateFrequency, sendVelocityUpdates);
        EntityRegistry.addSpawn((Class<? extends EntityLiving>)entityClass, spawnWeight, min, max, enumCreatureType, biomes);
    }

    public static void createEntity(ResourceLocation registryName, Class<? extends Entity> entityClass, String entityName, Object mod, int id, int viewDistance, int updateFrequency, boolean sendVelocityUpdates, int solidColor, int spotColor) {
        EntityRegistry.registerModEntity(registryName, entityClass, entityName, id, mod, viewDistance, updateFrequency, sendVelocityUpdates);
        createEgg(registryName, solidColor, spotColor);
    }

    public static void createEntity(ResourceLocation registryName, Class<? extends Entity> entityClass, String entityName, Object mod, int id, int viewDistance, int updateFrequency, boolean sendVelocityUpdates) {
        EntityRegistry.registerModEntity(registryName, entityClass, entityName, id, mod, viewDistance, updateFrequency, sendVelocityUpdates);
    }

    private static void createEgg(ResourceLocation registryName, int solidColor, int spotColor) {
        EntityList.ENTITY_EGGS.put(registryName, new EntityList.EntityEggInfo(registryName, solidColor, spotColor));
    }
}
