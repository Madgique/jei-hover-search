package com.madgique.jeihoversearch.forge;

import com.madgique.jeihoversearch.JEIHoverSearchClient;
import com.madgique.jeihoversearch.JEIHoverSearchMod;
import com.madgique.jeihoversearch.forge.client.jei.JEIHoverSearchJEIPlugin;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.client.ClientRawInputEvent;
import dev.architectury.platform.forge.EventBuses;
import net.minecraft.world.item.ItemStack;
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

    // Listen Key Pressed
    ClientRawInputEvent.KEY_PRESSED.register((client, keyCode, scanCode, action, modifiers) -> {
      // Did we hovered less than 3 ticks ?
      if (!JEIHoverSearchClient.lastRenderedStack.isEmpty() && client.level != null
          && client.level.getGameTime()
              - JEIHoverSearchClient.lastTooltipTime < JEIHoverSearchClient.THREE_TICKS) {
        if (JEIHoverSearchClient.KEY.matches(keyCode, scanCode)) {
          writeToJEISearchBar(JEIHoverSearchClient.lastRenderedStack);
        }
      }
      return EventResult.pass();
    });
  }

  private void writeToJEISearchBar(ItemStack item) {
    JEIHoverSearchJEIPlugin.getRuntime().getIngredientFilter()
        .setFilterText(item.getHoverName().getString());
  }

}
