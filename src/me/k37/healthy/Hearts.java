package me.k37.healthy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Hearts implements CommandExecutor{
	
	


	//hearts
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
		sender.sendMessage(ChatColor.RED + "Must be in game to initiate");
		return true;
		}
		Player player = (Player) sender;
		
		// hearts
		
		if(cmd.getName().equalsIgnoreCase("Hearts") || cmd.getName().equalsIgnoreCase("ht")) {
			
			if(player.hasPermission("healthy.hearts") == true) {
				if (args.length == 0) {
					player.sendMessage(ChatColor.RED + "Please specify /hearts [player] [amount]");
					return true;
				}
				else if (args.length == 1) {
					if (player.getServer().getPlayer(args[0]) != null) {
						final Player targetPlayer = player.getServer().getPlayer(args[0]);
						targetPlayer.setHealth(20);
						player.sendMessage(ChatColor.YELLOW + "Hearts adjusted for player");
						return true;
					}else {
						player.sendMessage(ChatColor.RED + "Player not online!");
						return true;
					}
				}
			
				else if (args.length >= 2) {
					if (player.getServer().getPlayer(args[0]) != null) {
						
						if(isNum(args[1])) {
							
						
						final Player targetPlayer = player.getServer().getPlayer(args[0]);
							double healthamt = Integer.parseInt(args[1]);
						
						
						if (healthamt >= 0 && healthamt <= 20) {
							targetPlayer.setHealth(healthamt);
							player.sendMessage(ChatColor.YELLOW + "Hearts adjusted for player");
							return true;
						}else {
							player.sendMessage(ChatColor.RED + "Specify within 0-20");
							return true;
						}
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
