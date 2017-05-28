package com.thefifthidiot.tficore.core.handler;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by fabbe50 on 28/04/2017.
 */
public class ChatHandler {
    @SubscribeEvent
    public void readChat(ServerChatEvent event) {
        String[] strings = event.getMessage().split(" ");
        for (String string : strings) {
            if (event.getMessage().toLowerCase().equals("what's my ping?") || event.getMessage().toLowerCase().equals("what's my ping") || event.getMessage().toLowerCase().equals("what is my ping?") || event.getMessage().toLowerCase().equals("what is my ping")) {
                MinecraftServer server = event.getPlayer().getServer();
                if (server != null) {
                    server.getPlayerList().sendMessage(new TextComponentString("<" + event.getPlayer().getDisplayName().getFormattedText() + "> " + event.getMessage()));
                    server.getPlayerList().sendMessage(new TextComponentString("<Server> " + event.getPlayer().getDisplayName().getFormattedText() + ", your ping is: " + event.getPlayer().ping));
                }
                event.setCanceled(true);
                return;
            } else if (string.toLowerCase().equals("ping")) {
                MinecraftServer server = event.getPlayer().getServer();
                if (server != null) {
                    server.getPlayerList().sendMessage(new TextComponentString("<" + event.getPlayer().getDisplayName().getFormattedText() + "> " + event.getMessage()));
                    server.getPlayerList().sendMessage(new TextComponentString("<Server> pong!"));
                }
                event.setCanceled(true);
                return;
            }
        }
    }
}
