package com.thefifthidiot.tficore.core.gui;

import com.google.common.collect.Lists;
import com.thefifthidiot.tficore.core.config.TConfigElement;
import com.thefifthidiot.tficore.core.handler.ConfigurationHandler;
import com.thefifthidiot.tficore.core.reference.Reference;
import com.thefifthidiot.tficore.lib.Configs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * Created by fabbe50 on 12/09/2016.
 */
public class GUIFactory implements IModGuiFactory {
    public static class GUIScreen extends GuiConfig {
        @SuppressWarnings("deprecation")
        public GUIScreen(GuiScreen parentScreen) {
            super(parentScreen, getConfigElements(), Reference.MOD_ID, false, false, I18n.translateToLocal(String.format("%s.%s", Reference.MOD_ID.toLowerCase(Locale.US), "configgui.title")));
        }

        private static List<IConfigElement> getConfigElements() {
            List<IConfigElement> list = Lists.newArrayList();

            list.add(new ConfigElement(ConfigurationHandler.general));
            list.add(new ConfigElement(ConfigurationHandler.rainvoting));
            list.add(new ConfigElement(ConfigurationHandler.blocks));
            list.add(new ConfigElement(ConfigurationHandler.clouds));

            return list;
        }
    }
    @Override
    public void initialize(Minecraft minecraftInstance) {

    }

    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass() {
        return GUIScreen.class;
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }

    @Override
    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
        return null;
    }

    public static Class<? extends GuiConfigEntries.IConfigEntry> getSliderClass() {
        return GuiConfigEntries.NumberSliderEntry.class;
    }
}
