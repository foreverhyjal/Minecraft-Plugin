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
        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists())
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
        else if (args.length == 1)
        {
            return commandWith1Args(player, args);
        }
        return false;
    }

    private boolean commandWith1Args(Player player, String[] args)
    {
        switch (args[0])
        {
            case "detail":
            {
                String detail = "§a一名玩家担任队长，由该名玩家邀请其他未组队的玩家。\n在队伍中的玩家平分获得的经验与物品。\n对于珍惜物品（装备、马鞍等），由玩家roll进行分配\\n其余物品（矿产）平分。\n其余功能：非队长玩家可以选择传送到队长身边。";
                player.sendMessage(detail);
                return true;
            }
        }
        return true;
    }
}
