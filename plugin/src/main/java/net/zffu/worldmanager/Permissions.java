package net.zffu.worldmanager;

import org.bukkit.configuration.file.FileConfiguration;

/**
 * <p>Stores the permissions of WorldManager.</p>
 */
public class Permissions {

    public static String HELP_PERMISSION = "";
    public static String WORLD_COMMAND_PERMISSION = "";
    public static String LOAD_WORLDS_PERMISSION = "";
    public static String UNLOAD_WORLDS_PERMISSION = "";

    public Permissions(FileConfiguration configuration) {
        HELP_PERMISSION = configuration.getString("permission.help");
        WORLD_COMMAND_PERMISSION = configuration.getString("permission.commands.worlds");
        LOAD_WORLDS_PERMISSION = configuration.getString("permission.loadworld");
        UNLOAD_WORLDS_PERMISSION = configuration.getString("permission.unloadworld");
    }

}
