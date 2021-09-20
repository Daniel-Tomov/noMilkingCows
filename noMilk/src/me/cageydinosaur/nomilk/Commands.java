package me.cageydinosaur.nomilk;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor{

	Main plugin;
	public Commands(Main plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("nomilk")) {
			if (!sender.hasPermission("nomilk")) {
				sender.sendMessage(ChatColor.RED + "You cannot use this plugin!");

			} else if (sender.hasPermission("nomilk.use")) {
				if (args.length == 0) {
					sender.sendMessage(ChatColor.RED + "Usage:");
					sender.sendMessage(ChatColor.RED + "/nomilk true");
					sender.sendMessage(ChatColor.RED + "/nomilk false");
					return true;
				}

				if (args.length > 0) {
					if (args[0].equalsIgnoreCase("false")) {
						sender.sendMessage(ChatColor.GREEN + "Disabling Milking");
						plugin.toggleMilk = false;
						return true;

					} else if (args[0].equalsIgnoreCase("true")) {
						sender.sendMessage(ChatColor.GREEN + "Enabling Milking");
						plugin.toggleMilk = true;
						return true;
					}
				}
			}
		}
		return true;
	}
}
