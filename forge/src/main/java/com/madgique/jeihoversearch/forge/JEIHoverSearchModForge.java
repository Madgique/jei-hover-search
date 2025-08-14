package com.madgique.jeihoversearch.forge;

import com.madgique.jeihoversearch.JEIHoverSearchClient;
import com.madgique.jeihoversearch.JEIHoverSearchMod;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(JEIHoverSearchMod.MOD_ID)
public class JEIHoverSearchModForge {

  public JEIHoverSearchModForge() {
    // Submit our event bus to let architectury register our content on the right
    // time
    EventBuses.registerModEventBus(JEIHoverSearchMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
    FMLJavaModLoadingContext.get().getModEventBus().register(this);
    JEIHoverSearchMod.init();
    // set the mod client only
    DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> JEIHoverSearchClient::new);
  }

}
