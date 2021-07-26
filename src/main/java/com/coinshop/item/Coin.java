package com.coinshop.item;

import com.coinshop.CoinShop;
import net.minecraft.item.Item;

public class Coin extends Item {

    public static Coin COIN = new Coin(new Item.Settings().group(CoinShop.COINSHOP));

    public Coin(Settings settings) {
        super(settings);
    }

}
