package me.cageydinosaur.nomilk;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class TabCompletion implements TabCompleter {

	Main plugin;

	public TabCompletion(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

		if (args.length == 1) {
			List<String> commands = new ArrayList<>();
			if (sender.hasPermission("nomilk")) {
				if (sender.hasPermission("nomilk.toggle")) {
					commands.add("true");
					commands.add("false");
					
					return commands;
				}
			}
		}
		return null;
	}

}