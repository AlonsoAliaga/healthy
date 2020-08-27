package me.k37.healthy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Saturation implements CommandExecutor{
	
	


	//Saturation
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
		sender.sendMessage(ChatColor.RED + "Must be in game to initiate");
		return true;
		}
		Player player = (Player) sender;
		
		// Saturation
		
		if(cmd.getName().equalsIgnoreCase("Saturation") || cmd.getName().equalsIgnoreCase("sat")) {
			if(player.hasPermission("healthy.sat") == true) {
				if (args.length == 0) {
					player.sendMessage(ChatColor.RED + "Please specify /saturation [player] [amount]");
					return true;
				}
				else if (args.length == 1) {
					if (player.getServer().getPlayer(args[0]) != null) {
						final Player targetPlayer = player.getServer().getPlayer(args[0]);
						targetPlayer.setSaturation(5);
						player.sendMessage(ChatColor.YELLOW + "Saturation adjusted for player");
						return true;
					}else {
						if (isNum(args[0])){
							int satamt = Integer.parseInt(args[0]);
							if (satamt >= 0 && satamt <= 5) {
								
								player.setSaturation(satamt);
								player.sendMessage(ChatColor.YELLOW + "No player specified, setting your saturation...");
								return true;
							}else{
								player.sendMessage(ChatColor.RED + "Specify within 0-5");
								return true;
							}

						} else {
							player.sendMessage(ChatColor.RED + "Specify within 0-5");
							return true;
						}
					}
				}
			
				else if (args.length >= 2) {
					if (player.getServer().getPlayer(args[0]) != null) {
						
						if(isNum(args[1])) {
						final Player targetPlayer = player.getServer().getPlayer(args[0]);
						
						int satamt = Integer.parseInt(args[1]);
						
						
						if (satamt >= 0 && satamt <= 5) {
							targetPlayer.setSaturation(satamt);
							player.sendMessage(ChatColor.YELLOW + "Saturation adjusted for player");
							return true;
						}else {
							player.sendMessage(ChatColor.RED + "Specify within 0-5");
							return true;
						}
						} else {
							player.sendMessage(ChatColor.RED + "Specify within 0-5");
							return true;
						}
					
				}else {
					player.sendMessage(ChatColor.RED + "Player not online!");
					return true;
				}
			}
			
			
		}else {
			player.sendMessage(ChatColor.RED + "Execute Order Sixty Si....uh no permission!");
		}
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