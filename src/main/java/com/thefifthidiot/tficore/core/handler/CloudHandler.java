package com.thefifthidiot.tficore.core.handler;

import com.thefifthidiot.tficore.lib.Configs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by fabbe50 on 27/09/2016.
 */
@SideOnly(Side.CLIENT)
public class CloudHandler extends IRenderHandler {
    private static final ResourceLocation CLOUD_TEXTURE = new ResourceLocation("textures/environment/clouds.png");
    public static final CloudHandler INSTANCE = new CloudHandler();

    private float getCloudHeight() {
        return Configs.cloudHeight;
    }

    float red = Configs.cloudColorRed;
    float green = Configs.cloudColorGreen;
    float blue = Configs.cloudColorBlue;
    float alpha = Configs.cloudColorAlpha;

    private int cloudTick = 0;

    @Override
    public void render(float partTicks, WorldClient world, Minecraft minecraft) {
        if (world.provider.isSurfaceWorld()) {
            if (minecraft.gameSettings.clouds == 2) {
                this.renderFancyClouds(partTicks, world, minecraft);
            }
            else {
                GlStateManager.disableCull();
                float f = (float)(minecraft.getRenderViewEntity().lastTickPosY + (minecraft.getRenderViewEntity().posY - minecraft.getRenderViewEntity().lastTickPosY) * (double)partTicks);
                int i = 32;
                int j = 8;
                Tessellator tessellator = Tessellator.getInstance();
                VertexBuffer vertexBuffer = tessellator.getBuffer();
                minecraft.renderEngine.bindTexture(CLOUD_TEXTURE);
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                Vec3d vec3d = world.getCloudColour(partTicks);
                float f1 = (float)vec3d.xCoord;
                float f2 = (float)vec3d.yCoord;
                float f3 = (float)vec3d.zCoord;
                if(minecraft.gameSettings.anaglyph) {
                    float f4 = (f1 * 30 + f2 * 59 + f3 * 11) / 100;
                    float f5 = (f1 * 30 + f2 * 70) / 100;
                    float f6 = (f1 * 30 + f3 * 70) / 100;
                    f1 = f4;
                    f2 = f5;
                    f3 = f6;
                }
                float f10 = 4.8828125E-4F;
                double d2 = (double)((float)this.cloudTick + partTicks);
                double d0 = minecraft.getRenderViewEntity().prevPosX + (minecraft.getRenderViewEntity().posX - minecraft.getRenderViewEntity().prevPosX) * (double)partTicks + d2 * 0.029999999329447746D;
                double d1 = minecraft.getRenderViewEntity().prevPosZ + (minecraft.getRenderViewEntity().posZ - minecraft.getRenderViewEntity().prevPosZ) * (double)partTicks;
                int k = MathHelper.floor_double(d0 / 2048.0D);
                int l = MathHelper.floor_double(d1 / 2048.0D);
                d0 = d0 - (double)(k * 2048);
                d1 = d1 - (double)(l * 2048);
                float f7 = getCloudHeight() - f + 0.33F;
                float f8 = (float)(d0 * 4.8828125E-4D);
                float f9 = (float)(d1 * 4.8828125E-4D);
                vertexBuffer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                for(int index = -256; index < 256; index += 32) {
                    for(int jindex = -256; jindex < 256; jindex += 32) {
                        vertexBuffer.pos((double)(index + 0), (double)f7, (double)(jindex + 32)).tex((double)((float)(index + 0) * 4.8828125E-4F + f8), (double)((float)(jindex + 32) * 4.8828125E-4F + f9)).color(f1, f2, f3, 0.8F).endVertex();
                        vertexBuffer.pos((double)(index + 32), (double)f7, (double)(jindex + 32)).tex((double)((float)(index + 32) * 4.8828125E-4F + f8), (double)((float)(jindex + 32) * 4.8828125E-4F + f9)).color(f1, f2, f3, 0.8F).endVertex();
                        vertexBuffer.pos((double)(index + 32), (double)f7, (double)(jindex + 0)).tex((double)((float)(index + 32) * 4.8828125E-4F + f8), (double)((float)(jindex + 0) * 4.8828125E-4F + f9)).color(f1, f2, f3, 0.8F).endVertex();
                        vertexBuffer.pos((double)(index + 0), (double)f7, (double)(jindex + 0)).tex((double)((float)(index + 0) * 4.8828125E-4F + f8), (double)((float)(jindex + 0) * 4.8828125E-4F + f9)).color(f1, f2, f3, 0.8F).endVertex();
                    }
                }
                tessellator.draw();
                GlStateManager.color(red, green, blue, alpha);
                GlStateManager.disableBlend();
                GlStateManager.enableCull();
            }
        }
    }

    public void renderFancyClouds(float partTicks, WorldClient world, Minecraft minecraft) {
        GlStateManager.disableCull();
        float f = (float)(minecraft.getRenderViewEntity().lastTickPosY + (minecraft.getRenderViewEntity().posY - minecraft.getRenderViewEntity().lastTickPosY) * (double)partTicks);
        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer vertexBuffer = tessellator.getBuffer();
        float f1 = 12.0F;
        float f2 = 4.0F;
        double d0 = (double)((float)this.cloudTick + partTicks);
        double d1 = (minecraft.getRenderViewEntity().prevPosX + (minecraft.getRenderViewEntity().posX - minecraft.getRenderViewEntity().prevPosX) * (double)partTicks + d0 * 0.029999999329447746D) / 12.0D;
        double d2 = (minecraft.getRenderViewEntity().prevPosZ + (minecraft.getRenderViewEntity().posZ - minecraft.getRenderViewEntity().prevPosZ) * (double)partTicks) / 12.0D + 0.33000001311302185D;
        float f3 = getCloudHeight() - f + 0.33F;
        int i = MathHelper.floor_double(d1 / 2048.0D);
        int j = MathHelper.floor_double(d2 / 2048.0D);
        d1 = d1 - (double)(i * 2048);
        d2 = d2 - (double)(j * 2048);
        minecraft.renderEngine.bindTexture(CLOUD_TEXTURE);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        Vec3d vec3 = world.getCloudColour(partTicks);
        float f4 = (float)vec3.xCoord;
        float f5 = (float)vec3.yCoord;
        float f6 = (float)vec3.zCoord;
        if (minecraft.gameSettings.anaglyph) {
            float f7 = (f4 * 30.0F + f5 * 59.0F + f6 * 11.0F) / 100.0F;
            float f8 = (f4 * 30.0F + f5 * 70.0F) / 100.0F;
            float f9 = (f4 * 30.0F + f6 * 70.0F) / 100.0F;
            f4 = f7;
            f5 = f8;
            f6 = f9;
        }
        float f26 = f4 * 0.9F;
        float f27 = f5 * 0.9F;
        float f28 = f6 * 0.9F;
        float f10 = f4 * 0.7F;
        float f11 = f5 * 0.7F;
        float f12 = f6 * 0.7F;
        float f13 = f4 * 0.8F;
        float f14 = f5 * 0.8F;
        float f15 = f6 * 0.8F;
        float f16 = 0.00390625F;
        float f17 = (float)MathHelper.floor_double(d1) * 0.00390625F;
        float f18 = (float)MathHelper.floor_double(d2) * 0.00390625F;
        float f19 = (float)(d1 - (double)MathHelper.floor_double(d1));
        float f20 = (float)(d2 - (double)MathHelper.floor_double(d2));
        int k = 8;
        int l = 4;
        float f21 = 9.765625E-4F;
        GlStateManager.scale(12.0F, 1.0F, 12.0F);
        for (int index = 0; index < 2; index++) {
            if (index == 0) {
                GlStateManager.colorMask(false, false, false, false);
            }
            else if (minecraft.gameSettings.anaglyph) {
                if (EntityRenderer.anaglyphField == 0) {
                    GlStateManager.colorMask(false, true, true, true);
                }
                else {
                    GlStateManager.colorMask(true, false, false, true);
                }
            }
            else {
                GlStateManager.colorMask(true, true, true, true);
            }
            for (int jindex = -3; jindex <= 4; jindex++) {
                for (int kindex = -3; kindex <= 4; kindex++) {
                    vertexBuffer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL);
                    float f22 = (float)(jindex * 8);
                    float f23 = (float)(kindex * 8);
                    float f24 = f22 - f19;
                    float f25 = f23 - f20;
                    if (f3 > -5.0F) {
                        vertexBuffer.pos((double)(f24 + 0.0F), (double)(f3 + 0.0F), (double)(f25 + 8.0F)).tex((double)((f22 + 0.0F) * 0.00390625F + f17), (double)((f23 + 8.0F) * 0.00390625F + f18)).color(f10, f11, f12, 0.8F).normal(0.0F, -1.0F, 0.0F).endVertex();
                        vertexBuffer.pos((double)(f24 + 8.0F), (double)(f3 + 0.0F), (double)(f25 + 8.0F)).tex((double)((f22 + 8.0F) * 0.00390625F + f17), (double)((f23 + 8.0F) * 0.00390625F + f18)).color(f10, f11, f12, 0.8F).normal(0.0F, -1.0F, 0.0F).endVertex();
                        vertexBuffer.pos((double)(f24 + 8.0F), (double)(f3 + 0.0F), (double)(f25 + 0.0F)).tex((double)((f22 + 8.0F) * 0.00390625F + f17), (double)((f23 + 0.0F) * 0.00390625F + f18)).color(f10, f11, f12, 0.8F).normal(0.0F, -1.0F, 0.0F).endVertex();
                        vertexBuffer.pos((double)(f24 + 0.0F), (double)(f3 + 0.0F), (double)(f25 + 0.0F)).tex((double)((f22 + 0.0F) * 0.00390625F + f17), (double)((f23 + 0.0F) * 0.00390625F + f18)).color(f10, f11, f12, 0.8F).normal(0.0F, -1.0F, 0.0F).endVertex();
                    }
                    if (f3 <= 5.0F) {
                        vertexBuffer.pos((double)(f24 + 0.0F), (double)(f3 + 4.0F - 9.765625E-4F), (double)(f25 + 8.0F)).tex((double)((f22 + 0.0F) * 0.00390625F + f17), (double)((f23 + 8.0F) * 0.00390625F + f18)).color(f4, f5, f6, 0.8F).normal(0.0F, 1.0F, 0.0F).endVertex();
                        vertexBuffer.pos((double)(f24 + 8.0F), (double)(f3 + 4.0F - 9.765625E-4F), (double)(f25 + 8.0F)).tex((double)((f22 + 8.0F) * 0.00390625F + f17), (double)((f23 + 8.0F) * 0.00390625F + f18)).color(f4, f5, f6, 0.8F).normal(0.0F, 1.0F, 0.0F).endVertex();
                        vertexBuffer.pos((double)(f24 + 8.0F), (double)(f3 + 4.0F - 9.765625E-4F), (double)(f25 + 0.0F)).tex((double)((f22 + 8.0F) * 0.00390625F + f17), (double)((f23 + 0.0F) * 0.00390625F + f18)).color(f4, f5, f6, 0.8F).normal(0.0F, 1.0F, 0.0F).endVertex();
                        vertexBuffer.pos((double)(f24 + 0.0F), (double)(f3 + 4.0F - 9.765625E-4F), (double)(f25 + 0.0F)).tex((double)((f22 + 0.0F) * 0.00390625F + f17), (double)((f23 + 0.0F) * 0.00390625F + f18)).color(f4, f5, f6, 0.8F).normal(0.0F, 1.0F, 0.0F).endVertex();
                    }
                    if (jindex > -1) {
                        for (int lindex = 0; lindex < 8; lindex++) {
                            vertexBuffer.pos((double)(f24 + (float)lindex + 0.0F), (double)(f3 + 0.0F), (double)(f25 + 8.0F)).tex((double)((f22 + (float)lindex + 0.5F) * 0.00390625F + f17), (double)((f23 + 8.0F) * 0.00390625F + f18)).color(f26, f27, f28, 0.8F).normal(-1.0F, 0.0F, 0.0F).endVertex();
                            vertexBuffer.pos((double)(f24 + (float)lindex + 0.0F), (double)(f3 + 4.0F), (double)(f25 + 8.0F)).tex((double)((f22 + (float)lindex + 0.5F) * 0.00390625F + f17), (double)((f23 + 8.0F) * 0.00390625F + f18)).color(f26, f27, f28, 0.8F).normal(-1.0F, 0.0F, 0.0F).endVertex();
                            vertexBuffer.pos((double)(f24 + (float)lindex + 0.0F), (double)(f3 + 4.0F), (double)(f25 + 0.0F)).tex((double)((f22 + (float)lindex + 0.5F) * 0.00390625F + f17), (double)((f23 + 0.0F) * 0.00390625F + f18)).color(f26, f27, f28, 0.8F).normal(-1.0F, 0.0F, 0.0F).endVertex();
                            vertexBuffer.pos((double)(f24 + (float)lindex + 0.0F), (double)(f3 + 0.0F), (double)(f25 + 0.0F)).tex((double)((f22 + (float)lindex + 0.5F) * 0.00390625F + f17), (double)((f23 + 0.0F) * 0.00390625F + f18)).color(f26, f27, f28, 0.8F).normal(-1.0F, 0.0F, 0.0F).endVertex();
                        }
                    }
                    if (jindex <= 1) {
                        for (int index2 = 0; index2 < 8; index2++) {
                            vertexBuffer.pos((double)(f24 + (float)index2 + 1.0F - 9.765625E-4F), (double)(f3 + 0.0F), (double)(f25 + 8.0F)).tex((double)((f22 + (float)index2 + 0.5F) * 0.00390625F + f17), (double)((f23 + 8.0F) * 0.00390625F + f18)).color(f26, f27, f28, 0.8F).normal(1.0F, 0.0F, 0.0F).endVertex();
                            vertexBuffer.pos((double)(f24 + (float)index2 + 1.0F - 9.765625E-4F), (double)(f3 + 4.0F), (double)(f25 + 8.0F)).tex((double)((f22 + (float)index2 + 0.5F) * 0.00390625F + f17), (double)((f23 + 8.0F) * 0.00390625F + f18)).color(f26, f27, f28, 0.8F).normal(1.0F, 0.0F, 0.0F).endVertex();
                            vertexBuffer.pos((double)(f24 + (float)index2 + 1.0F - 9.765625E-4F), (double)(f3 + 4.0F), (double)(f25 + 0.0F)).tex((double)((f22 + (float)index2 + 0.5F) * 0.00390625F + f17), (double)((f23 + 0.0F) * 0.00390625F + f18)).color(f26, f27, f28, 0.8F).normal(1.0F, 0.0F, 0.0F).endVertex();
                            vertexBuffer.pos((double)(f24 + (float)index2 + 1.0F - 9.765625E-4F), (double)(f3 + 0.0F), (double)(f25 + 0.0F)).tex((double)((f22 + (float)index2 + 0.5F) * 0.00390625F + f17), (double)((f23 + 0.0F) * 0.00390625F + f18)).color(f26, f27, f28, 0.8F).normal(1.0F, 0.0F, 0.0F).endVertex();
                        }
                    }
                    if (kindex > -1) {
                        for (int jindex2 = 0; jindex2 < 8; jindex2++) {
                            vertexBuffer.pos((double)(f24 + 0.0F), (double)(f3 + 4.0F), (double)(f25 + (float)jindex2 + 0.0F)).tex((double)((f22 + 0.0F) * 0.00390625F + f17), (double)((f23 + (float)jindex2 + 0.5F) * 0.00390625F + f18)).color(f13, f14, f15, 0.8F).normal(0.0F, 0.0F, -1.0F).endVertex();
                            vertexBuffer.pos((double)(f24 + 8.0F), (double)(f3 + 4.0F), (double)(f25 + (float)jindex2 + 0.0F)).tex((double)((f22 + 8.0F) * 0.00390625F + f17), (double)((f23 + (float)jindex2 + 0.5F) * 0.00390625F + f18)).color(f13, f14, f15, 0.8F).normal(0.0F, 0.0F, -1.0F).endVertex();
                            vertexBuffer.pos((double)(f24 + 8.0F), (double)(f3 + 0.0F), (double)(f25 + (float)jindex2 + 0.0F)).tex((double)((f22 + 8.0F) * 0.00390625F + f17), (double)((f23 + (float)jindex2 + 0.5F) * 0.00390625F + f18)).color(f13, f14, f15, 0.8F).normal(0.0F, 0.0F, -1.0F).endVertex();
                            vertexBuffer.pos((double)(f24 + 0.0F), (double)(f3 + 0.0F), (double)(f25 + (float)jindex2 + 0.0F)).tex((double)((f22 + 0.0F) * 0.00390625F + f17), (double)((f23 + (float)jindex2 + 0.5F) * 0.00390625F + f18)).color(f13, f14, f15, 0.8F).normal(0.0F, 0.0F, -1.0F).endVertex();
                        }
                    }
                    if (kindex <= 1) {
                        for (int kindex2 = 0; kindex2 < 8; kindex2++) {
                            vertexBuffer.pos((double)(f24 + 0.0F), (double)(f3 + 4.0F), (double)(f25 + (float)kindex2 + 1.0F - 9.765625E-4F)).tex((double)((f22 + 0.0F) * 0.00390625F + f17), (double)((f23 + (float)kindex2 + 0.5F) * 0.00390625F + f18)).color(f13, f14, f15, 0.8F).normal(0.0F, 0.0F, 1.0F).endVertex();
                            vertexBuffer.pos((double)(f24 + 8.0F), (double)(f3 + 4.0F), (double)(f25 + (float)kindex2 + 1.0F - 9.765625E-4F)).tex((double)((f22 + 8.0F) * 0.00390625F + f17), (double)((f23 + (float)kindex2 + 0.5F) * 0.00390625F + f18)).color(f13, f14, f15, 0.8F).normal(0.0F, 0.0F, 1.0F).endVertex();
                            vertexBuffer.pos((double)(f24 + 8.0F), (double)(f3 + 0.0F), (double)(f25 + (float)kindex2 + 1.0F - 9.765625E-4F)).tex((double)((f22 + 8.0F) * 0.00390625F + f17), (double)((f23 + (float)kindex2 + 0.5F) * 0.00390625F + f18)).color(f13, f14, f15, 0.8F).normal(0.0F, 0.0F, 1.0F).endVertex();
                            vertexBuffer.pos((double)(f24 + 0.0F), (double)(f3 + 0.0F), (double)(f25 + (float)kindex2 + 1.0F - 9.765625E-4F)).tex((double)((f22 + 0.0F) * 0.00390625F + f17), (double)((f23 + (float)kindex2 + 0.5F) * 0.00390625F + f18)).color(f13, f14, f15, 0.8F).normal(0.0F, 0.0F, 1.0F).endVertex();
                        }
                    }
                    tessellator.draw();
                }
            }
        }
        GlStateManager.color(red, green, blue, alpha);
        GlStateManager.disableBlend();
        GlStateManager.enableCull();
    }
}
