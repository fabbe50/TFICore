package com.thefifthidiot.tficore.core.gui;

import com.google.common.collect.Lists;
import com.thefifthidiot.tficore.core.handler.ConfigurationHandler;
import com.thefifthidiot.tficore.core.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.Language;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.server.gui.StatsComponent;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * Created by fabbe50 on 06/09/2016.
 */
public class ConfigGUI extends GuiConfig {
    @SuppressWarnings("deprecation")
    public ConfigGUI(GuiScreen parentScreen) {
        super(parentScreen, getConfigElements(), Reference.MOD_ID, false, false, I18n.translateToLocal(String.format("%s.%s", Reference.MOD_ID.toLowerCase(Locale.US), "configgui.title")));
    }

    private static List<IConfigElement> getConfigElements() {
        List<IConfigElement> list = Lists.newArrayList();

        list.add(new ConfigElement(ConfigurationHandler.general));
        list.add(new ConfigElement(ConfigurationHandler.rainvoting));
        list.add(new ConfigElement(ConfigurationHandler.blocks));

        return list;
    }
}
