package zx.foodeffects;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CS {
    FoodEffects plugin;

    public static HashMap<ItemStack, String> fem = new HashMap<>();

    public CS(FoodEffects plugin) {
        this.plugin = plugin;
    }

    public void svf() {
        List<ConfigurationSection> v = (List<ConfigurationSection>) this.plugin.getConfig().getList("VanillaFood");
        for (Iterator<ConfigurationSection> s = v.iterator(); s.hasNext(); ) {
            ConfigurationSection c = s.next();
            String is = c.getCurrentPath().replace("VanillaFood.", "");
            List<ConfigurationSection> vfe = (List<ConfigurationSection>) this.plugin.getConfig().getList("VanillaFood." + is);
            StringBuilder stringBuilder = null;
            String effect = s.next().getCurrentPath().replace("VanillaFood." + is + ".", "");
            String effectd = this.plugin.getConfig().getCurrentPath();
            stringBuilder.append(pets(effectd, effectd) + "~");
            if (!s.hasNext()) {
                ItemStack isa = new ItemStack(Material.valueOf(is));
                fem.put(isa, stringBuilder.toString());
                System.out.println(is + " was loaded!");
            }
        }
    }
    public String pets(String effectd,String effect) {
        switch (effect) {
            case "Explosion":
                String es = this.plugin.getConfig().getString(effectd + "Size");
                String edu = this.plugin.getConfig().getString(effectd + "DamageUser");
                String ednu = this.plugin.getConfig().getString(effectd + "DamageNearbyUsers");
                boolean edm = this.plugin.getConfig().getBoolean(effectd + "DamageBlocks");
                return EE.EXS(es, edu, ednu, edm);
            case "Thunder":
                String r = this.plugin.getConfig().getString(effectd + "Radius");
                String a = this.plugin.getConfig().getString(effectd + "Amount");
                boolean pm = this.plugin.getConfig().getBoolean(effectd + "PlayerMagnet");
                return EE.ts(r, a, pm);
            case "TeleportationShuffle":
                String vs = this.plugin.getConfig().getString(effectd + "Vert");
                String hs = this.plugin.getConfig().getString(effectd + "Hart");
                boolean sb = this.plugin.getConfig().getBoolean(effectd + "Solid");
                return EE.TSS(hs, vs, sb);
            case "PotionEffect":
                String as = this.plugin.getConfig().getString(effectd + "EffectType");
                String bs = this.plugin.getConfig().getString(effectd + "Long");
                String cs = this.plugin.getConfig().getString(effectd + "Power");
                return EE.pe(as, bs, cs);
            case "SetHealth":
                String shs = this.plugin.getConfig().getString(effectd + "Amount");
                return EE.shs(shs);
            case "SetHunger":
                String sfs = this.plugin.getConfig().getString(effectd + "Amount");
                return EE.sfs(sfs);
            case "SetTime":
                String sts = this.plugin.getConfig().getString(effectd + "Time");
                return EE.sts(sts);
            case "Teleport":
                System.out.println("Teleport is not supported");
                break;
            case "burn":
                String sbs = this.plugin.getConfig().getString(effectd + "Long");
                return EE.sfs(sbs);
        }
        return "@UNKNOWN@";
    }
}
