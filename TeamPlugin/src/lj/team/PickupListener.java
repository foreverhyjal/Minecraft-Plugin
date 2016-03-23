package lj.team;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

/**
 * Created by LJ on 2016/3/23.
 * Describe : This class is responsible for
 */
public class PickupListener implements Listener
{
    @EventHandler
    public void onPickupItem(PlayerPickupItemEvent event)
    {
        Player player = event.getPlayer();
        Item item = event.getItem();
        boolean isCommonItem = CommonItem.INSTANCE.isCommonItem(item);
        if (isCommonItem)
            player.sendMessage("§a你捡起了 " + item.getName() + " 它是普通物品");
        else
            player.sendMessage("§a你捡起了 " + item.getName() + " 它是非普通物品");

    }
}
