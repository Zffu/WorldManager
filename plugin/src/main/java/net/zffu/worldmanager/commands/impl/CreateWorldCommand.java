package net.zffu.worldmanager.commands.impl;

import net.zffu.worldmanager.Messages;
import net.zffu.worldmanager.Permissions;
import net.zffu.worldmanager.WorldManagerPlugin;
import net.zffu.worldmanager.commands.WorldManagerCommand;
import net.zffu.worldmanager.worlds.PluginWorld;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.io.File;

/**
 * <p>Handles the "/world" command</p>
 */
public class CreateWorldCommand extends WorldManagerCommand {

    public CreateWorldCommand() {
        super(Permissions.CREATE_WORLD_PERMISSION);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!super.onCommand(commandSender, command, s, strings)) return false;

        if(strings.length < 2) {
            commandSender.sendMessage(Messages.PREFIX + "§cUsage: /world <worldName> <originWorld> [reset on server stop] [autoload]");
            return false;
        }

        PluginWorld world = new PluginWorld(new File(strings[1]), strings[0], (strings.length >= 3 ? parseBool(strings[2]) : false), (strings.length >= 4 ? parseBool(strings[3]) : false));
        WorldManagerPlugin.INSTANCE.worlds.put(strings[0], world);

        commandSender.sendMessage(Messages.PREFIX + Messages.CREATE_WORLD);

        WorldManagerPlugin.INSTANCE.getConfig().set("worlds." + strings[0] + ".origin", strings[1]);
        WorldManagerPlugin.INSTANCE.getConfig().set("worlds." + strings[0] + ".clear-on-stop", world.resetOnStop);
        WorldManagerPlugin.INSTANCE.getConfig().set("worlds." + strings[0] + ".autoload", world.loadOnStart);

        return true;
    }

    public boolean parseBool(String s) {
        try {
            return Boolean.parseBoolean(s);
        } catch (Exception e) {
            return false;
        }
    }
}
