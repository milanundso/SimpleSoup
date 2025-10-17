package ltc.milan.simplesoup;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleSoup extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Simple Soup Plugin has been enabled!");
        getServer().getPluginManager().registerEvents(new SoupListener(), this);

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Simple Soup Plugin has been disabled!");
    }
}
