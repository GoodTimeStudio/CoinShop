package com.coinshop.client.color;

import com.coinshop.config.Config;
import com.coinshop.item.Coin;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;

public class ItemColors {

    public static void register(Item item, int color){
        Config config = Config.getInstance();

        HashMap<String,Integer> COLOR_MAP = config.colorsCode;

        if(COLOR_MAP.putIfAbsent(item.getTranslationKey(),color)==null){
            config.save();
        }

        ColorProviderRegistry.ITEM.register(new ItemColorProvider() {
            @Override
            public int getColor(ItemStack stack, int tintIndex) {
                return COLOR_MAP.get(item.getTranslationKey());
            }
        }, item);
    }


}
