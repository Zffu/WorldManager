package net.zffu.worldmanager.commands.impl;

import net.zffu.worldmanager.Messages;
import net.zffu.worldmanager.Permissions;
import net.zffu.worldmanager.WorldManagerPlugin;
import net.zffu.worldmanager.commands.WorldManagerCommand;
import net.zffu.worldmanager.worlds.PluginWorld;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 * <p>Handles "/loadworld" command.</p>
 */
public class LoadWorldCommand extends WorldManagerCommand {

    public LoadWorldCommand() {
        super(Permissions.LOAD_WORLDS_PERMISSION);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!super.onCommand(commandSender, command, s, strings)) return false;

        if(strings.length > 1) {
            commandSender.sendMessage(Messages.PREFIX + "§cUsage: /loadworld <worlds>");
            return false;
        }

        for(String name : strings) {
            PluginWorld world = WorldManagerPlugin.INSTANCE.worlds.get(name);

            if(world == null) {
                commandSender.sendMessage(Messages.PREFIX + Messages.ERROR_LOADING_WORLD);
                continue;
            }

            try {
                world.load();
                commandSender.sendMessage(Messages.PREFIX + Messages.LOADED_WORLD.replace("%s", name));
            } catch (Exception e) {
                commandSender.sendMessage(Messages.PREFIX + Messages.ERROR_LOADING_WORLD.replace("%s", name));
                e.printStackTrace();
            }
        }

        return true;
    }
}
