package net.zffu.worldmanager;

import net.zffu.worldmanager.commands.impl.MainCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class WorldManagerPlugin extends JavaPlugin {

    public static WorldManagerPlugin INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        saveDefaultConfig();

        new Messages(getConfig());
        new Permissions(getConfig());

        this.getCommand("worldmanager").setExecutor(new MainCommand());
    }

    @Override
    public void onDisable() {

    }
}
