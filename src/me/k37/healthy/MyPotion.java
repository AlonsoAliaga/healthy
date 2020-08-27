package me.k37.healthy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MyPotion implements CommandExecutor{
	
	


	//m
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
		sender.sendMessage(ChatColor.RED + "Must be in game to initiate");
		return true;
		}
		Player player = (Player) sender;
		
		// Potion
		
		if(cmd.getName().equalsIgnoreCase("MyPotion") || cmd.getName().equalsIgnoreCase("mp")) {
			if(player.hasPermission("healthy.mypotion") == true) {
				try {

					if (args.length == 3) {
						if(isNum(args[1]) && (isNum(args[2])) ) {
					
						String type = (args[0]);
						int duration = Integer.parseInt(args[1]);
						int amplifier = Integer.parseInt(args[2]);
					
					
					
						player.addPotionEffect(new PotionEffect(PotionEffectType.getByName(type), duration, amplifier));
						return true;
						}
					
					
					} else {
						player.sendMessage(ChatColor.RED + "Do /mp <type> [duration] [amplifier]");
						player.sendMessage(ChatColor.RED + "Types: ABSORPTION, BAD_OMEN, BLINDNESS, CONDUIT_POWER, CONFUSION, DAMAGE_RESISTANCE, DOLPHINS_GRACE, FAST_DIGGING, FIRE_RESISTANCE, GLOWING, HARM, HEAL, HEALTH_BOOST, HERO_OF_THE_VILLAGE, HUNGER, INCREASE_DAMAGE, INVISIBILITY, JUMP, LEVITATION, LUCK, NIGHT_VISION, POISON, REGENERATION, SATURATION, SLOW, SLOW_DIGGING, SLOW_FALLING, SPEED, UNLUCK, WATER_BREATHING, WEAKNESS ");
					}
				} catch (Exception e){
					player.sendMessage(ChatColor.RED + "Do /mp <type> [duration] [amplifier]");
					player.sendMessage(ChatColor.RED + "Types: ABSORPTION, BAD_OMEN, BLINDNESS, CONDUIT_POWER, CONFUSION, DAMAGE_RESISTANCE, DOLPHINS_GRACE, FAST_DIGGING, FIRE_RESISTANCE, GLOWING, HARM, HEAL, HEALTH_BOOST, HERO_OF_THE_VILLAGE, HUNGER, INCREASE_DAMAGE, INVISIBILITY, JUMP, LEVITATION, LUCK, NIGHT_VISION, POISON, REGENERATION, SATURATION, SLOW, SLOW_DIGGING, SLOW_FALLING, SPEED, UNLUCK, WATER_BREATHING, WEAKNESS ");
					return true;
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
