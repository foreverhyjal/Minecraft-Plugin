package test;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by LJ on 2016/3/21.
 * Describe : This class is responsible for
 */
public class Test extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        super.onEnable();
        getLogger().info("Test load");
    }
}
