package com.madgique.jeihoversearch.fabric;

import com.madgique.jeihoversearch.JEIHoverSearchMod;

import net.fabricmc.api.ModInitializer;

public class JEIHoverSearchModFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        JEIHoverSearchMod.init();
    }
}