package net.zffu.worldmanager;

import org.bukkit.plugin.java.JavaPlugin;

public class WorldManagerPlugin extends JavaPlugin {

    public static WorldManagerPlugin INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {

    }
}
