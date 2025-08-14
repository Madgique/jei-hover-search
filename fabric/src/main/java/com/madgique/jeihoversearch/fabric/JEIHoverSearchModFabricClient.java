package com.madgique.jeihoversearch.fabric;

import com.madgique.jeihoversearch.JEIHoverSearchClient;

import net.fabricmc.api.ClientModInitializer;

public class JEIHoverSearchModFabricClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        new JEIHoverSearchClient();
    }
}