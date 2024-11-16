package net.zffu.worldmanager.commands.impl;

import net.zffu.worldmanager.Permissions;
import net.zffu.worldmanager.WorldManagerPlugin;
import net.zffu.worldmanager.commands.WorldManagerCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 * <p>Handles the "/worlds" command </p>
 */
public class WorldsCommand extends WorldManagerCommand {

    public WorldsCommand() {
        super(Permissions.WORLD_COMMAND_PERMISSION);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!super.onCommand(commandSender, command, s, strings)) return false;

        commandSender.sendMessage("§7");
        commandSender.sendMessage("§fWorlds handled trough WorldManager: §b" + WorldManagerPlugin.INSTANCE.worlds.size());
        commandSender.sendMessage("§fCurrently loaded: §b" + WorldManagerPlugin.LOADED);
        commandSender.sendMessage("§7");

        return true;
    }
}
