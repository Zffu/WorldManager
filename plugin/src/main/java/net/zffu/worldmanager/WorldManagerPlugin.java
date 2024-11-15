package net.zffu.worldmanager;

import net.zffu.worldmanager.commands.impl.MainCommand;
import net.zffu.worldmanager.commands.impl.WorldsCommand;
import net.zffu.worldmanager.worlds.PluginWorld;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WorldManagerPlugin extends JavaPlugin {

    public static WorldManagerPlugin INSTANCE;
    public static int LOADED;

    public List<PluginWorld> worlds = new ArrayList<>();

    @Override
    public void onEnable() {
        INSTANCE = this;
        saveDefaultConfig();

        this.getLogger().info("Loading configuration...");
        new Messages(getConfig());
        new Permissions(getConfig());

        this.getLogger().info("Loading worlds...");
        ConfigurationSection section = getConfig().getConfigurationSection("worlds");

        for(String key : section.getKeys(false)) {
            String origin = section.getString(key + ".origin");

            if(origin == null) {
                this.getLogger().warning("The config world " + key + " doesn't have the origin property even tough it is required!");
                continue;
            }

            PluginWorld world = new PluginWorld(new File(origin), key, section.getBoolean(key + ".clear-on-stop", true), section.getBoolean(key + ".autoload", false));

            if(world.loadOnStart) {
                try {
                    world.load();
                } catch (Exception e) {
                    this.getLogger().severe("Error while loading world! ");
                    e.printStackTrace();
                }
            }

            this.worlds.add(world);
        }
        this.getLogger().info("Loaded " + worlds.size() + " worlds!");

        this.getLogger().info("Hooking up commands...");
        this.getCommand("worldmanager").setExecutor(new MainCommand());
        this.getCommand("worlds").setExecutor(new WorldsCommand());
    }

    @Override
    public void onDisable() {

    }
}
