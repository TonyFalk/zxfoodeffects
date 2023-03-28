package zx.foodeffects;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class FoodEffects extends JavaPlugin {

    private File eeFile = new File(getDataFolder(), "ee.yml");
    private FileConfiguration eeConfig = YamlConfiguration.loadConfiguration(eeFile);
    public FileConfiguration getEEConfig() {
        return eeConfig;
    }
    public L l;

    @Override
    public void onEnable() {
        System.out.println("FoodEffects 1.0");
        this.l = new L(this);
        if (!eeFile.exists()) {
            saveResource("ee.yml", false);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
