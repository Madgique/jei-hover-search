package com.madgique.jeihoversearch;

import com.mojang.blaze3d.platform.InputConstants;

import dev.architectury.event.events.client.ClientTooltipEvent;
import dev.architectury.registry.client.keymappings.KeyMappingRegistry;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;

public class JEIHoverSearchClient {
    public static final int THREE_TICKS = 3;

    public static final KeyMapping KEY = new KeyMapping(
            "key.jeihoversearch.search",
            InputConstants.Type.KEYSYM,
            InputConstants.getKey("key.keyboard.y").getValue(),
            "jei.key.category.mouse.hover");

    public static ItemStack lastRenderedStack = ItemStack.EMPTY;

    public static long lastTooltipTime = 0;

    public JEIHoverSearchClient() {
        init();
    }

    private static void init() {
        KeyMappingRegistry.register(KEY);
        // Get last hovered itemStack
        ClientTooltipEvent.ITEM.register((stack, lines, flag) -> {
            if (!stack.isEmpty() && Minecraft.getInstance().level != null) {
                lastRenderedStack = stack;
                lastTooltipTime = Minecraft.getInstance().level.getGameTime();
            }
        });
    }

}
