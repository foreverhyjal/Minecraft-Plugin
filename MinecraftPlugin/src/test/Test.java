package test;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by LJ on 2016/3/21.
 * Describe : This class is responsible for
 */
public class Test extends JavaPlugin implements Listener
{
    @Override
    public void onEnable()
    {
        super.onEnable();
        getLogger().info("Test load");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            if (label.equalsIgnoreCase("test"))
            {
                Player player = (Player) sender;
                if (args.length == 0)
                {
                    player.sendMessage("§b heeeeeelp");
                    return true;
                }
                if (args.length == 4)
                {
                    if (args[0].equals("tr"))
                    {
                        double x = Double.parseDouble(args[1]);
                        double y = Double.parseDouble(args[2]);
                        double z = Double.parseDouble(args[3]);
                        Location s = new Location(player.getLocation().getWorld(), x, y, z);
                        player.teleport(s);
                    }
                }
            }
        }
        return true;
    }

    @EventHandler
    public void onLogin(PlayerPickupItemEvent event) {
        event.getPlayer().sendMessage(event.getItem().getName());
    }

    @EventHandler
    public void onExp(PlayerExpChangeEvent event)
    {
        event.getPlayer().sendMessage(event.toString());
        System.out.println(event.getAmount());
        event.getPlayer().
    }
}
