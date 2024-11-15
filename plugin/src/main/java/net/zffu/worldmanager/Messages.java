package net.zffu.worldmanager;

import org.bukkit.configuration.file.FileConfiguration;

/**
 * <p>Stores the messages values.</p>
 */
public class Messages {

    public static String PREFIX = "";
    public static String NO_PERMISSION = "";
    public static String LOADED_WORLD = "";
    public static String ERROR_LOADING_WORLD = "";
    public static String UNLOADED_WORLD = "";
    public static String ERROR_UNLOADING_WORLD = "";

    /**
     * <p>Initiates the messages values.</p>
     * @param configuration the configuration file.
     */
    public Messages(FileConfiguration configuration) {
        PREFIX = configuration.getString("messages.prefix");
        NO_PERMISSION = configuration.getString("messages.no-permissions");
        LOADED_WORLD = configuration.getString("messages.loaded-world");
        ERROR_LOADING_WORLD = configuration.getString("messages.error-loading-world");
        UNLOADED_WORLD = configuration.getString("messages.unloaded-world");
        ERROR_UNLOADING_WORLD = configuration.getString("messages.error-unloading-world");
    }

}
