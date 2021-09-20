package me.cageydinosaur.nomilk;

import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
	public boolean toggleMilk = false;

	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new Events(this), this);
		getCommand("nomilk").setExecutor(new Commands(this));
		getCommand("nomilk").setTabCompleter(new TabCompletion(this));
	}

}