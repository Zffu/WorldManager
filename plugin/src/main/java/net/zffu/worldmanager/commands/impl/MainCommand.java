package net.zffu.worldmanager.commands.impl;

import net.zffu.worldmanager.Permissions;
import net.zffu.worldmanager.commands.WorldManagerCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 * <p>Handles the "/wm" command.</p>
 */
public class MainCommand extends WorldManagerCommand {

    public MainCommand() {
        super(Permissions.HELP_PERMISSION);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!super.onCommand(commandSender, command, s, strings)) return false;

        commandSender.sendMessage("§f---------- [§bWorldManager§f] ----------");
        commandSender.sendMessage("§b/worlds§f: See the information about worlds loaded trough WorldManager.");
        commandSender.sendMessage("§b/loadworld <worldName>§f: Loads the world.");
        commandSender.sendMessage("§b/unloadworld <worldName>§f: Unloads the world.");
        commandSender.sendMessage("§f---------- [§bWorldManager§f] ----------");

        return false;
    }
}
