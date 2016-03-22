package lj.team;

import org.bukkit.entity.Player;

/**
 * Created by LJ on 2016/3/22.
 * Describe : This class is responsible for
 */
public class TeamDetail
{
    private Player player;
    public TeamDetail(Player player)
    {
        this.player = player;
    }

    public boolean command(String[] args)
    {
        if (args.length == 1)
        {
            String detail = "§a一名玩家担任队长，由该名玩家邀请其他未组队的玩家。\n在队伍中的玩家平分获得的经验与物品。\n其余功能：非队长玩家可以选择传送到队长身边。";
            player.sendMessage(detail);
            player.sendMessage("§a/team detail invite 显示详细说明：邀请");
            player.sendMessage("§a/team detail exp 显示详细说明：经验分配");
            player.sendMessage("§a/team detail item 显示详细说明：物品分配");
            player.sendMessage("§a/team detail transfer 显示详细说明：传送");
        }
        else if (args.length == 2)
        {
            switch (args[1])
            {
                case "invite":
                {
                    String detail = "§a一名未组队的玩家可以邀请其余未组队的玩家。邀请成功后该名玩家担任队长，可以继续邀请其他玩家。队伍人数上限5人\n";
                    detail += "§a被邀请玩家需要输入/team confirm确认邀请。";
                    player.sendMessage(detail);
                    break;
                }
                case "exp":
                {
                    String detail = "§a组队中的玩家通过各种途径（杀怪、采矿）获取的经验值由全队平分。若经验无法平分，向上取整。";
                    player.sendMessage(detail);
                    break;
                }
                case "item":
                {
                    String detail = "§a组队中的玩家拾取到普通物品（红石、青金石、铁、金、钻石）时，该物品暂时存储于公共物品栏中。\n";
                    detail += "结束探险时，由队长输入/team loop平分所有物品，若物品无法平分，向上取整。\n";
                    detail += "珍惜物品（装备、马鞍、马铠）在获得的时候给所有队伍中的玩家提示输入/team roll，最后由roll点大的玩家获得";
                    player.sendMessage(detail);
                    break;
                }
                case "transfer":
                {
                    String detail = "§a队伍中非队长玩家可以输入/team transfer\n可以直接传送到队长的位置。但不保证该位置的安全性。";
                    player.sendMessage(detail);
                    break;
                }
                default:
                    player.sendMessage("§c/team detail 参数错误");
            }
        }
        else if (args.length > 2)
            player.sendMessage("§c/team detail 参数错误");
        return true;
    }
}
