package me.k37.healthy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Potion implements CommandExecutor{
	
	


	//myPotion
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
		sender.sendMessage(ChatColor.RED + "Must be in game to initiate");
		return true;
		}
		Player player = (Player) sender;
		
		// Potion
		//There is no need to check if cmd is one or the other.
		
			if(player.hasPermission("healthy.potion")) { //You don't need to check if its == true, it returns a boolean already (Suggestion: Make perms configurable)
				try {

					if (args.length == 3) {
						if(isNum(args[1]) && (isNum(args[2])) ) {
					
						String type = args[0]; //No need for parenthesis.
						int duration = Integer.parseInt(args[1]);
						int amplifier = Integer.parseInt(args[2]);
					
					
					
						player.addPotionEffect(new PotionEffect(PotionEffectType.getByName(type), duration, amplifier));
						return true;
						}
					
					
					} else if (args.length == 4){
							if (player.getServer().getPlayer(args[0]) != null) {
								if(isNum(args[2]) && (isNum(args[3])) ) {
							
									final Player targetPlayer = player.getServer().getPlayer(args[0]);

									String type = (args[1]);
									int duration = Integer.parseInt(args[2]);
									int amplifier = Integer.parseInt(args[3]);
						
						
						
									targetPlayer.addPotionEffect(new PotionEffect(PotionEffectType.getByName(type), duration, amplifier));
									return true;
							}else {
									//Suggestion: Make messages configurable
								player.sendMessage(ChatColor.RED + "Do /mp <optional:player> <type> [duration] [amplifier]");
								player.sendMessage(ChatColor.RED + "Types: ABSORPTION, BAD_OMEN, BLINDNESS, CONDUIT_POWER, CONFUSION, DAMAGE_RESISTANCE, DOLPHINS_GRACE, FAST_DIGGING, FIRE_RESISTANCE, GLOWING, HARM, HEAL, HEALTH_BOOST, HERO_OF_THE_VILLAGE, HUNGER, INCREASE_DAMAGE, INVISIBILITY, JUMP, LEVITATION, LUCK, NIGHT_VISION, POISON, REGENERATION, SATURATION, SLOW, SLOW_DIGGING, SLOW_FALLING, SPEED, UNLUCK, WATER_BREATHING, WEAKNESS ");
							}
						}else {
							player.sendMessage(ChatColor.RED + "Player not online!");
						}
					
					
					}else {
						player.sendMessage(ChatColor.RED + "Do /mp <optional:player> <type> [duration] [amplifier]");
						player.sendMessage(ChatColor.RED + "Types: ABSORPTION, BAD_OMEN, BLINDNESS, CONDUIT_POWER, CONFUSION, DAMAGE_RESISTANCE, DOLPHINS_GRACE, FAST_DIGGING, FIRE_RESISTANCE, GLOWING, HARM, HEAL, HEALTH_BOOST, HERO_OF_THE_VILLAGE, HUNGER, INCREASE_DAMAGE, INVISIBILITY, JUMP, LEVITATION, LUCK, NIGHT_VISION, POISON, REGENERATION, SATURATION, SLOW, SLOW_DIGGING, SLOW_FALLING, SPEED, UNLUCK, WATER_BREATHING, WEAKNESS ");
					}
				} catch (Exception e){
					player.sendMessage(ChatColor.RED + "Do /mp <optional:player> <type> [duration] [amplifier]");
					player.sendMessage(ChatColor.RED + "Types: ABSORPTION, BAD_OMEN, BLINDNESS, CONDUIT_POWER, CONFUSION, DAMAGE_RESISTANCE, DOLPHINS_GRACE, FAST_DIGGING, FIRE_RESISTANCE, GLOWING, HARM, HEAL, HEALTH_BOOST, HERO_OF_THE_VILLAGE, HUNGER, INCREASE_DAMAGE, INVISIBILITY, JUMP, LEVITATION, LUCK, NIGHT_VISION, POISON, REGENERATION, SATURATION, SLOW, SLOW_DIGGING, SLOW_FALLING, SPEED, UNLUCK, WATER_BREATHING, WEAKNESS ");
					return true;
				}
				
				
			}else {
				player.sendMessage(ChatColor.RED + "Execute Order Sixty Si....uh no permission!");
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
