package me.FreakingChicken.TransparentSkins;

import api.player.render.RenderPlayerAPI;
import me.FreakingChicken.TransparentSkins.client.renderer.entity.RenderPlayerOverride;
import me.FreakingChicken.TransparentSkins.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)

public class Main {

	private static final Logger LOGGER = LogManager.getLogger(Reference.MOD_ID);

	public static Main instance;

	private Minecraft mc;
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		
		
		
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		instance = this;

		RenderPlayerAPI.register(Reference.MOD_ID, RenderPlayerOverride.class);
		
		//RenderPlayerAPI.register(Reference.MOD_ID, TileEntitySkullRendererOverride.class);

		MinecraftForge.EVENT_BUS.register(instance);

	}
}
