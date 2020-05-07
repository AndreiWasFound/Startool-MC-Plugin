package me.andreisava4.Startool;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener {
	
	public List<String> list = new ArrayList<String>();
	
	
	@Override
	public void onEnable() {

		this.getServer().getPluginManager().registerEvents(new StarEvents(this), this);
	}

	@Override
	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// /startool
		if (label.equalsIgnoreCase("startool")) {
			if (!(sender instanceof Player)) {	
				sender.sendMessage("*Your the console of this server and not a player so you cannot use this command");
				return true;
				
			}
			Player player = (Player) sender;
			if (player.getInventory().firstEmpty() == -1) {
				// inventory is full
				Location loc = player.getLocation();
				World world = player.getWorld();
				
				world.dropItemNaturally(loc, getItem());
				player.sendMessage(ChatColor.GOLD + "The minecraft legends dropped you a special item.");
				return true;
			}
			player.getInventory().addItem(getItem());
			player.sendMessage(ChatColor.GOLD + "The minecraft legends gave you a special item.");
			return true;
			
			
		}

		return false;
	}
	
	
	public ItemStack getItem() {
		
		ItemStack TRIDENT = new ItemStack(Material.TRIDENT);
		ItemMeta meta = TRIDENT.getItemMeta();
		
		meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Ancient Trident");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7(Right click) &a&oSpawn minions"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7(Left click) &a&oShoot explosives"));
		meta.setLore(lore);
		
		meta.addEnchant(Enchantment.LOYALTY, 3, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.setUnbreakable(true);
		
		TRIDENT.setItemMeta(meta);

		return TRIDENT;
	}
	

	}
	




















