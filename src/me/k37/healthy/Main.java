package me.k37.healthy;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		//startup
		this.getCommand("MyHearts").setExecutor(new MyHearts());
		this.getCommand("Hearts").setExecutor(new Hearts());
		this.getCommand("MyFood").setExecutor(new MyFood());
		this.getCommand("FoodPoints").setExecutor(new FoodPoints());
		this.getCommand("MySaturation").setExecutor(new MySaturation());
		this.getCommand("Saturation").setExecutor(new Saturation());
		this.getCommand("MyPotion").setExecutor(new MyPotion());
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
	
	

