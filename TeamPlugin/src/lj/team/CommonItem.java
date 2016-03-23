package lj.team;

import org.bukkit.entity.Item;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by LJ on 2016/3/23.
 * Describe : This class is responsible for
 */
public enum CommonItem
{
    INSTANCE;
    private Set<String> setItem = null;

    public boolean isCommonItem(Item item)
    {
        if(setItem == null)
            setItem = initCommonItemSet();
        return setItem.contains(item.getName());
    }

    private Set<String> initCommonItemSet()
    {
        Set<String> set = new HashSet<>();
        set.add("item.item.coal");
        set.add("item.item.redstone");
        set.add("item.item.diamond");
        set.add("item.item.dyePowder.blue");
        set.add("item.item.blazeRod");
        set.add("item.tile.oreGold");
        set.add("item.tile.oreIron");
        return set;
    }


}
