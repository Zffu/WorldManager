package net.zffu.worldmanager.commands;

import net.zffu.worldmanager.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

/**
 * <p>A {@link CommandExecutor} made to run WorldManager commands.</p>
 */
public class WorldManagerCommand implements CommandExecutor {

    private final String permission;

    public WorldManagerCommand(String permission) {
        this.permission = permission;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof ConsoleCommandSender) && !commandSender.hasPermission(permission)) {
            commandSender.sendMessage(Messages.NO_PERMISSION);
            return false;
        }
        return true;
    }

}
