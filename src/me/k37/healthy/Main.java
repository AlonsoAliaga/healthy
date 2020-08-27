package me.k37.healthy;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		//startup
		
		this.getCommand("Hearts").setExecutor(new Hearts());
		this.getCommand("FoodPoints").setExecutor(new FoodPoints());
		this.getCommand("Saturation").setExecutor(new Saturation());
		this.getCommand("Potion").setExecutor(new Potion());
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Healthy]: Enabled!");
		//reloads
		//plugin reloads
	}
	
	@Override
	public void onDisable() {
		//shutdown
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Healthy]: Disabled!");
		//reloads
		//plugin reloads
	}
	
	
}
	
	

