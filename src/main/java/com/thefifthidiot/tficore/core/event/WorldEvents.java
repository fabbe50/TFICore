package com.thefifthidiot.tficore.core.event;

import com.thefifthidiot.tficore.TFICore;
import com.thefifthidiot.tficore.lib.Configs;
import com.thefifthidiot.tficore.utility.LogHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class WorldEvents {
	@SubscribeEvent(priority=EventPriority.HIGH)
	public void disableRain(TickEvent.ServerTickEvent event) {
		MinecraftServer server = Minecraft.getMinecraft().getIntegratedServer().getServer();
		World world = server.worldServers[0];
		
		if (!world.isRemote) {
			int i = 1000000;
			WorldInfo worldinfo = world.getWorldInfo();
				
			if (worldinfo.getCleanWeatherTime() <= 1000) {
				worldinfo.setCleanWeatherTime(i);
				worldinfo.setRainTime(0);
				worldinfo.setThunderTime(0);
				worldinfo.setRaining(false);
				worldinfo.setThundering(false);
				LogHelper.info("Rain Blocked!");
			}
		}
	}
}