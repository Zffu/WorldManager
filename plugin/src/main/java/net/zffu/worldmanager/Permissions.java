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
    public static String CREATE_WORLD_PERMISSION = "";


    public Permissions(FileConfiguration configuration) {
        HELP_PERMISSION = configuration.getString("permissions.help");
        WORLD_COMMAND_PERMISSION = configuration.getString("permissions.worlds");
        LOAD_WORLDS_PERMISSION = configuration.getString("permissions.load-world");
        UNLOAD_WORLDS_PERMISSION = configuration.getString("permissions.unload-world");
        CREATE_WORLD_PERMISSION = configuration.getString("permissions.create-world");
    }

}
