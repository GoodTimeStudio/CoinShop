package com.coinshop.client.color;

import com.coinshop.config.Config;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;

public class ItemColors {

    public static void register(Item item, int... colors) {
        Config config = Config.getInstance();

        HashMap<String, Integer> COLOR_MAP = config.colorsCode;

        for (int i = 0; i < colors.length; i++) {
            if (COLOR_MAP.putIfAbsent(item.getTranslationKey() + "_layer" + i, colors[i]) == null) {
                config.save();
            }

            int finalI = i;
            ColorProviderRegistry.ITEM.register(new ItemColorProvider() {
                @Override
                public int getColor(ItemStack stack, int tintIndex) {
                    if (tintIndex == finalI) {
                        return COLOR_MAP.get(item.getTranslationKey() + "_layer" + finalI);
                    } else {
                        return -1;
                    }
                }
            }, item);

        }


    }

}
