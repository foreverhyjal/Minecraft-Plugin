package lj.team;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Created by LJ on 2016/3/22.
 * Describe : This class is responsible for
 */
public class TeamPlugin extends JavaPlugin
{
    private FileConfiguration config;

    @Override
    public void onEnable()
    {
        if (!getDataFolder().exists())
            getDataFolder().mkdir();

        saveDefaultConfig();
        reloadConfig();
        getLogger().info("Team plugin load. Author : LJ. Version : 1.0");
        config = getConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            sender.sendMessage("§4该命令只能由玩家进行");
            return true;
        }
        Player player = (Player)sender;
        if (!label.equalsIgnoreCase("team"))
            return true;
        if (args.length == 0)
        {
            String pluginMessage = config.get("PluginMessage").toString();
            player.sendMessage(pluginMessage);
            player.sendMessage("§a/team detail 显示插件详细信息");
            player.sendMessage("§a/team invite [玩家名] 邀请[玩家名]加入队伍");
            player.sendMessage("§a/team remove [玩家名] 将[玩家名]移出队伍");
            player.sendMessage("§a/team apply [玩家名] 申请加入[玩家名]所在的队伍");
            return true;
        }
        else if (args[0].equalsIgnoreCase("detail"))
        {
            TeamDetail teamDetail = new TeamDetail(player);
            return teamDetail.command(args);
        }
        return false;
    }
}
