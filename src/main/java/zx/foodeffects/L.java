package zx.foodeffects;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.plugin.Plugin;

public class L implements Listener {
    FoodEffects plugin;

    public L(FoodEffects plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, (Plugin) this.plugin);
    }
    @EventHandler
    public void Qaof(PlayerItemConsumeEvent ev){
        if(CS.fem.containsKey(ev.getItem())){
            String td = CS.fem.get(ev.getItem());
            EE.MEGOVERMENT(ev.getPlayer(),td);
        }
    }
}
