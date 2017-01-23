package com.thefifthidiot.tficore.core.event;

import com.thefifthidiot.tficore.core.handler.CloudHandler;
import com.thefifthidiot.tficore.core.handler.CloudHandlerFix;
import com.thefifthidiot.tficore.lib.Configs;
import com.thefifthidiot.tficore.utility.LogHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by fabbe50 on 27/09/2016.
 */
public class EventCloudRenderer {
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void movedWorld(WorldEvent.Load event) {
        if (Configs.isDimensionAllowed(event.getWorld().provider.getDimension()) || event.getWorld().provider.getDimension() == 0) {
            LogHelper.info("Initiated custom cloud renderer");
            event.getWorld().provider.setCloudRenderer(CloudHandlerFix.INSTANCE);
        }
        else {
            LogHelper.error("Did not initiate custom cloud renderer");
        }
    }
}
