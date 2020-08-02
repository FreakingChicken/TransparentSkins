package me.FreakingChicken.TransparentSkins.client.renderer.entity;

import api.player.render.RenderPlayerAPI;
import api.player.render.RenderPlayerBase;
import me.FreakingChicken.TransparentSkins.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;

public class RenderPlayerOverride extends RenderPlayerBase {

	public RenderPlayerOverride(RenderPlayerAPI renderPlayerAPI) {
		super(renderPlayerAPI);
	}

	@Override
	public void doRender(AbstractClientPlayer entity, double x, double y, double z, float entityYaw,
			float partialTicks) {
		if (Main.instance != null) {
			if (!entity.isUser() || Minecraft.getMinecraft().getRenderManager().livingPlayer == entity) {
				double d0 = y;

				if (entity.isSneaking() && !(entity instanceof EntityPlayerSP)) {
					d0 = y - 0.125D;
				}

				this.setModelVisibilities(entity);
				GlStateManager.enableBlend();
				GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
				super.doRender(entity, x, d0, z, entityYaw, partialTicks);
				GlStateManager.disableBlend();
			}
		} else {
			super.doRender(entity, x, y, z, entityYaw, partialTicks);
		}
	}

	@Override
	public void renderRightArm(AbstractClientPlayer clientPlayer) {
		if (Main.instance != null) {
			float f = 1.0F;
			GlStateManager.color(f, f, f);
			float f1 = 0.0625F;
			ModelPlayer modelplayer = this.renderPlayer.getMainModel();
			this.setModelVisibilities(clientPlayer);
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
			modelplayer.swingProgress = 0.0F;
			modelplayer.isSneak = false;
			modelplayer.setRotationAngles(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, clientPlayer);
			modelplayer.bipedRightArm.rotateAngleX = 0.0F;
			modelplayer.bipedRightArm.render(0.0625F);
			modelplayer.bipedRightArmwear.rotateAngleX = 0.0F;
			modelplayer.bipedRightArmwear.render(0.0625F);
			GlStateManager.disableBlend();
		} else {
			super.renderRightArm(clientPlayer);
		}
	}

	@Override
	public void renderLeftArm(AbstractClientPlayer clientPlayer) {
		if (Main.instance != null) {
			float f = 1.0F;
			GlStateManager.color(f, f, f);
			float f1 = 0.0625F;
			ModelPlayer modelplayer = this.renderPlayer.getMainModel();
			this.setModelVisibilities(clientPlayer);
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
			modelplayer.isSneak = false;
			modelplayer.swingProgress = 0.0F;
			modelplayer.setRotationAngles(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, clientPlayer);
			modelplayer.bipedLeftArm.rotateAngleX = 0.0F;
			modelplayer.bipedLeftArm.render(0.0625F);
			modelplayer.bipedLeftArmwear.rotateAngleX = 0.0F;
			modelplayer.bipedLeftArmwear.render(0.0625F);
			GlStateManager.disableBlend();
		} else {
			super.renderLeftArm(clientPlayer);
		}
	}

}
