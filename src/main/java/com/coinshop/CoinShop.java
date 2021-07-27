package com.coinshop;


import com.coinshop.client.color.ItemColors;
import com.coinshop.item.Coin;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CoinShop implements ModInitializer {

	private static final String MODID = "coinshop";

	public static final ItemGroup COINSHOP = FabricItemGroupBuilder.create(
			new Identifier("coinshop", "coinshop"))
			.icon(() -> new ItemStack(Coin.COIN))
			.build();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registry.ITEM,new Identifier("coinshop","coin"),Coin.COIN);
		ItemColors.register(Coin.COIN, 0xDAA520, 0xFFFFFF);
	}
}