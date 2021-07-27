package com.coinshop.config;

import com.google.gson.Gson;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;

public class Config {

    private static final Gson GSON = new Gson();

    public HashMap<String,Integer> colorsCode = new HashMap<>();;

    private static Config INSTANCE;

    public static Config getInstance() {
        if (INSTANCE == null) {
            INSTANCE = load();
        }
        return INSTANCE;

    }

    private static Path getPath(){
        return new File(FabricLoader.getInstance().getConfigDir().toFile(), "coin_color.json").toPath();
    }

    private Config() {
    }

    public static Config load() {

        Path config_Path = getPath();

        if (Files.exists(config_Path)) {
            try {
                return GSON.fromJson(Files.readString(config_Path), Config.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Config config = new Config();
            config.save();
            return config;
        }

        return null;

    }

    public void save() {
        try {
            Files.writeString(getPath(), GSON.toJson(this), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
