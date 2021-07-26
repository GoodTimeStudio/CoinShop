package com.coinshop.client.color;

import com.coinshop.item.Coin;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.ItemStack;

public class ItemColors {

    public static void create(){
        ColorProviderRegistry.ITEM.register(new ItemColorProvider() {
            @Override
            public int getColor(ItemStack stack, int tintIndex) {
                return 0x3495EB;
            }
        }, Coin.COIN);
    }


}
