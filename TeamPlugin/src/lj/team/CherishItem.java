package lj.team;

import org.bukkit.entity.Item;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by LJ on 2016/3/23.
 * Describe : This class is responsible for
 */
public enum CherishItem
{
    INSTANCE;
    private Set<String> setItem = null;

    public boolean isCherishItem(Item item)
    {
        if(setItem == null)
            setItem = initCommonItemSet();
        return setItem.contains(item.getName());
    }

    private Set<String> initCommonItemSet()
    {
        Set<String> set = new HashSet<>();
        set.add("item.item.swordDiamond");
        set.add("item.item.helmetDiamond");
        set.add("item.item.chestplateDiamond");
        set.add("item.item.leggingsDiamond");
        set.add("item.item.bootsDiamond");
        set.add("item.tile.oreGold");
        set.add("item.tile.oreIron");
        return set;
    }
}
