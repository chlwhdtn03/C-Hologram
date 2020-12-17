package hologram.chlwhdtn;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Hologram extends JavaPlugin implements CommandExecutor {

	@Override
	public void onEnable() {
		getCommand("holo").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!sender.isOp()) {
			return false;
		}
		
		Player p = (Player) sender;
		if(args.length == 0) {
			p.sendMessage("§c/holo <내용>");
			return false;
		}
		String msg = "";
		for(int i = 0; i < args.length; i++) {
			msg += args[i] + " ";
		}
		msg = msg.trim();
		createHologram(p.getLocation(), msg);
		return true;
	}
	
	
	public void createHologram(Location l, String name) {
		ArmorStand as = (ArmorStand) l.getWorld().spawnEntity(l, EntityType.ARMOR_STAND);
		
		as.setSmall(true);
		as.setArms(false);
		as.setGravity(false);
		as.setVisible(false);
		as.setCustomName(ChatColor.translateAlternateColorCodes('&', name));
		as.setCustomNameVisible(true);
	}
	
}
