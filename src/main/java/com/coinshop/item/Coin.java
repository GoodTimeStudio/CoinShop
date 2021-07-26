package com.coinshop.item;

import com.coinshop.CoinShop;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Coin extends Item {

    public static Coin COIN = new Coin(new Item.Settings().group(CoinShop.COINSHOP));

    public static String name(){
        return COIN.getOrCreateTranslationKey();
    }

    public Coin(Settings settings) {
        super(settings);
    }

}
