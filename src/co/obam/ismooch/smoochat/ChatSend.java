package co.obam.ismooch.smoochat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatSend {
	
	//I will only place notes in the sendGlobal method, as the other channel methods simply
	//repeat.
	/*
	 * TODO Construct a more dynamic channel handling method that allows custom defined channels
	 * Using a global sendChat(Player player, String message, String channel) method should work
	 * with a setting for a color. Will probably handle channel creation via MySQL to avoid needing 
	 * a mirrored config on each server for cross server message sending
	 */
	public static void sendGlobal(Player player, String message){
		
		//declaring the prefix and sendMessage strings.
		//they  are separate here so I can modify them separately.
		//prefix will handle Server Prefix, Title, Player Name and TODO Badges
		String prefix;
		String sendMessage;
		
		//all of the permission checks which simply apply the proper title
		//not all of these colors may be right.. or subject to change
		/*
		 * TODO Add badges / add some columns for setting badge type and
		 * color vs just beta star color to support multiple different badges
		 * 
		 * TODO When adding badges, attempt to add JSON Hover Event support for
		 * information about the badge
		 * May require an additional SQL column for the information. But should be 
		 * made using Prepared statements, with easy administration to adding new
		 * badges
		 */
		if (player.hasPermission("obam.mod")){
			
			//TODO SQL system for saving SuperStaff and Admin and adding reference in these checks
			
			//Mod perm check and adding the Dark Green color code with the [M] Title
			//TODO ?? Maybe hover event on titles ??
			prefix = String.valueOf(SmooChat.serverPrefix + " " + ChatColor.DARK_GREEN + "[M] " + player.getName());
			
		
		//using else if tree to ensure that the first permission hit gives the appropriate prefix

		}else if(player.hasPermission("obam.ult4")){

			//Ultimate Perm check and Gold color addition with the [^] title
			prefix = String.valueOf(SmooChat.serverPrefix + " " + ChatColor.GOLD + "[^] " + player.getName());
			
		}else if(player.hasPermission("obam.plus2")){
			
			//Supporter Plus Perm check and Aqua color addition with the [+] title
			prefix = String.valueOf(SmooChat.serverPrefix + " " + ChatColor.AQUA + "[+] " + player.getName());
			
		}else if(player.hasPermission("obam.supp1")){
			
			//Supporter perm check and Blue color addition with no title
			prefix = String.valueOf(SmooChat.serverPrefix + " " + ChatColor.BLUE + player.getName());
			
		}else if(player.hasPermission("obam.supporter")){
			
			//'obam.supporter' is a legacy permission only in use by the mechanic group
			//Mechanic perm check with Yellow color addition and no title
			prefix = String.valueOf(SmooChat.serverPrefix + " " + ChatColor.YELLOW + player.getName());
			
		}else{
			
			//if no other perms are found just adding the server prefix to the beginning of the user name
			prefix = String.valueOf(SmooChat.serverPrefix + " " + player.getName());
			
		}
		//appending the actual message to the prefix and preparing for sending
		sendMessage = String.valueOf(prefix + ChatColor.WHITE + ": " + message);
		
		//Enhanced for loop to run through the appropriate channel and sending to the appropriate player
		//Also sends to the console for proper log file adding
		System.out.println(sendMessage);
		
		for (Player get : ChatInteract.globalChannel){
			
			
			
			
			if(!ChatInteract.chatOffPlayers.contains(get)){
				
				get.sendRawMessage(sendMessage);
			
			}else{
				
				if(player.hasPermission("obam.mod")){
					
					get.sendRawMessage(sendMessage);
					
				}
				
			}
		}
			/*
			 * TODO add Bungee plugin messages for sending cross server
			 * 
			 * TODO add chat logging via ChatLogger
			 */
	}

	public static void sendStaff(Player player, String message) {
		
		String prefix;
		String sendMessage;
		
		if (player.hasPermission("obam.mod")){
			
			prefix = String.valueOf(SmooChat.serverPrefix + " " + ChatColor.DARK_GREEN + "[M] " + player.getName());
			
			
		}else if(player.hasPermission("obam.ult4")){
			
			prefix = String.valueOf(SmooChat.serverPrefix + " " + ChatColor.GOLD + "[^] " + player.getName());
			
		}else if(player.hasPermission("obam.plus2")){
			
			prefix = String.valueOf(SmooChat.serverPrefix + " " + ChatColor.AQUA + "[+] " + player.getName());
			
		}else if(player.hasPermission("obam.supp1")){
			
			prefix = String.valueOf(SmooChat.serverPrefix + " " + ChatColor.BLUE + player.getName());
			
		}else if(player.hasPermission("obam.supporter")){
			
			prefix = String.valueOf(SmooChat.serverPrefix + " " + ChatColor.YELLOW + player.getName());
			
		}else{
			
			prefix = String.valueOf(SmooChat.serverPrefix + " " + player.getName());
			
		}
		
		sendMessage = String.valueOf(prefix + ChatColor.LIGHT_PURPLE + ": " + message);
		
		System.out.println(sendMessage);
		
		for (Player get : ChatInteract.staffChannel){
			
			get.sendRawMessage(sendMessage);
		}
		

		
	}

	public static void sendSupporter(Player player, String message) {
		
		String prefix;
		String sendMessage;
		
		if (player.hasPermission("obam.mod")){
			
			prefix = String.valueOf(SmooChat.serverPrefix + " " + ChatColor.DARK_GREEN + "[M] " + player.getName());
			
			
		}else if(player.hasPermission("obam.ult4")){
			
			prefix = String.valueOf(SmooChat.serverPrefix + " " + ChatColor.GOLD + "[^] " + player.getName());
			
		}else if(player.hasPermission("obam.plus2")){
			
			prefix = String.valueOf(SmooChat.serverPrefix + " " + ChatColor.AQUA + "[+] " + player.getName());
			
		}else if(player.hasPermission("obam.supp1")){
			
			prefix = String.valueOf(SmooChat.serverPrefix + " " + ChatColor.BLUE + player.getName());
			
		}else if(player.hasPermission("obam.supporter")){
			
			prefix = String.valueOf(SmooChat.serverPrefix + " " + ChatColor.YELLOW + player.getName());
			
		}else{
			
			prefix = String.valueOf(SmooChat.serverPrefix + " " + player.getName());
			
		}
		
		sendMessage = String.valueOf(prefix + ChatColor.BLUE + ": " + message);
		
		System.out.println(sendMessage);
		
		for (Player get : ChatInteract.supporterChannel){
			
			
			
			if(!ChatInteract.chatOffPlayers.contains(get)){
				
				get.sendRawMessage(sendMessage);
			
			}else{
				
				if(player.hasPermission("obam.mod")){
					
					get.sendRawMessage(sendMessage);
					
				}
				
			}
		}
		
	}

	public static void sendMechanic(Player player, String message) {
		
		String prefix;
		String sendMessage;
		
		if (player.hasPermission("obam.mod")){
			
			prefix = String.valueOf(SmooChat.serverPrefix + " " + ChatColor.DARK_GREEN + "[M] " + player.getName());
			
			
		}else if(player.hasPermission("obam.ult4")){
			
			prefix = String.valueOf(SmooChat.serverPrefix + " " + ChatColor.GOLD + "[^] " + player.getName());
			
		}else if(player.hasPermission("obam.plus2")){
			
			prefix = String.valueOf(SmooChat.serverPrefix + " " + ChatColor.AQUA + "[+] " + player.getName());
			
		}else if(player.hasPermission("obam.supp1")){
			
			prefix = String.valueOf(SmooChat.serverPrefix + " " + ChatColor.BLUE + player.getName());
			
		}else if(player.hasPermission("obam.supporter")){
			
			prefix = String.valueOf(SmooChat.serverPrefix + " " + ChatColor.YELLOW + player.getName());
			
		}else{
			
			prefix = String.valueOf(SmooChat.serverPrefix + " " + player.getName());
			
		}
		
		sendMessage = String.valueOf(prefix + ChatColor.YELLOW + ": " + message);
		
		System.out.println(sendMessage);
		
		for (Player get : ChatInteract.mechanicChannel){
			
			
			
			if(!ChatInteract.chatOffPlayers.contains(get)){
				
				get.sendRawMessage(sendMessage);
			
			}else{
				
				if(player.hasPermission("obam.mod")){
					
					get.sendRawMessage(sendMessage);
					
				}
				
			}
		}
		
	}

}