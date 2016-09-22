package com.thefifthidiot.tficore.core.handler;

import com.google.common.base.Converter;
import com.google.common.collect.Lists;
import com.thefifthidiot.tficore.core.reference.Reference;
import com.thefifthidiot.tficore.lib.Configs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

public class ConfigurationHandler {
    public static ConfigurationHandler configuration = new ConfigurationHandler();



    static Configuration configFile;

    public static ConfigCategory general;
    public static ConfigCategory rainvoting;
    public static ConfigCategory blocks;

    public static void load(FMLPreInitializationEvent event) {
        configFile = new Configuration(event.getSuggestedConfigurationFile(), "Alpha1", false);

        MinecraftForge.EVENT_BUS.register(configuration);

        syncConfig();
    }

    @SubscribeEvent
    public void update(ConfigChangedEvent.OnConfigChangedEvent event) {
        if(event.getModID().equals(Reference.MOD_ID)) {
            syncConfig();
        }
    }

    public static void syncConfig() {
        Property prop;

        /*General */
        {
            String cat = "General";
            List<String> propOrder = Lists.newArrayList();
            general = configFile.getCategory(cat);

            prop = configFile.get(cat, "TFI Tabs", Configs.tfitabs);
            prop.setComment("Are TFITabs a thing? (Note: Might crash mods that rely on these tabs!)");
            Configs.tfitabs = prop.getBoolean();
            propOrder.add(prop.getName());
        }
        /*Rain-voting*/
        {
            String cat = "Rain Voting";
            List<String> propOrder = Lists.newArrayList();
            rainvoting = configFile.getCategory(cat);

            prop = configFile.get(cat, "Rain Voting", Configs.rainVoting);
            prop.setComment("Allows for skipping rain by voting.");
            Configs.rainVoting = prop.getBoolean();
            propOrder.add(prop.getName());

            prop = configFile.get(cat, "Chaac: The Rain God", Configs.chaacRainGod);
            prop.setComment("Allows single player rain skipping.");
            Configs.chaacRainGod = prop.getBoolean();
            propOrder.add(prop.getName());

            prop = configFile.get(cat, "Admins are Chaac", Configs.adminOverride);
            prop.setComment("Admins can override rain");
            Configs.adminOverride = prop.getBoolean();
            propOrder.add(prop.getName());

            prop = configFile.get(cat, "Player Worth", Configs.playerVoteWorth);
            prop.setComment("How high of a value does a normal player have?");
            Configs.playerVoteWorth = prop.getInt();
            propOrder.add(prop.getName());

            prop = configFile.get(cat, "Admin Worth", Configs.adminVoteWorth);
            prop.setComment("How high of a value does an admin player have?");
            Configs.adminVoteWorth = prop.getInt();
            propOrder.add(prop.getName());

            rainvoting.setPropertyOrder(propOrder);
        }

        {
            String cat = "Blocks";
            List<String> propOrder = Lists.newArrayList();
            blocks = configFile.getCategory(cat);

            prop = configFile.get(cat, "Disable Exploding Rocks", Configs.disableFuseRock);
            prop.setComment("Disable exploding rocks from spawn underground?");
            Configs.disableFuseRock = prop.getBoolean();
            propOrder.add(prop.getName());

            prop = configFile.get(cat, "Explosion Strength", Configs.fuseRockStrength);
            prop.setComment("How big of an explosion will the rocks make?");
            Configs.fuseRockStrength = Float.parseFloat(prop.getString());
            propOrder.add(prop.getName());

            prop = configFile.get(cat, "Ore Conversion", Configs.oreFromMod);
            prop.setComment("What mod should ore-drops convert to?");
            Configs.oreFromMod = prop.getString();
            propOrder.add(prop.getName());

            blocks.setPropertyOrder(propOrder);
        }

        if(configFile.hasChanged()) {
            configFile.save();
        }
    }
}
