package me.k37.healthy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MySaturation implements CommandExecutor{
	
	


	//mysaturation
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
		sender.sendMessage(ChatColor.RED + "Must be in game to initiate");
		return true;
		}
		Player player = (Player) sender;
		
		// mysaturation
		
		if(cmd.getName().equalsIgnoreCase("MySaturation") || cmd.getName().equalsIgnoreCase("mysat")) {
			if(player.hasPermission("healthy.mysat") == true) {
	
				if (args.length == 0) {
					player.sendMessage(ChatColor.YELLOW + "Saturation set to 5(max).");
					player.setSaturation(5);
					return true;
				}else if (args.length == 1) {
					if(isNum(args[0])) {
					int satspec = Integer.parseInt(args[0]);
					if (satspec >= 0 && satspec <= 5) {
					
						player.setSaturation(satspec);
						player.sendMessage(ChatColor.YELLOW + "Saturation adjusted for player");
						return true;
					}else {
						player.sendMessage(ChatColor.RED + "Please specify amount between [0-5]");
						return true;
					}
					}
				
			}
		}else {
			player.sendMessage(ChatColor.RED + "Execute Order Sixty Si....uh no permission!");
		}
			
		return true;
		
		}
	
	return true;
	
	}
	
	public boolean isNum(String num) {
		try {
			Integer.parseInt(num);
			} catch (NumberFormatException ex) {
				
				return false;
				
			}
		return true;
	}
	

}
