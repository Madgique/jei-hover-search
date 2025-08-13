package com.madgique.jeihoversearch.forge.client.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.runtime.IJeiRuntime;

import com.madgique.jeihoversearch.JEIHoverSearchMod;

import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class JEIHoverSearchJEIPlugin implements IModPlugin {
  private static IJeiRuntime runtime;
  private static final ResourceLocation PLUGIN_ID = new ResourceLocation(JEIHoverSearchMod.MOD_ID, "jei_plugin");

  @Override
  public void onRuntimeAvailable(IJeiRuntime runtime) {
    JEIHoverSearchJEIPlugin.runtime = runtime;
  }

  public static IJeiRuntime getRuntime() {
    return runtime;
  }

  @Override
  public ResourceLocation getPluginUid() {
    return PLUGIN_ID;
  }

}
