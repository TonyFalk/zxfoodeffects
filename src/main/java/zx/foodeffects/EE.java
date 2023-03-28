package zx.foodeffects;

import com.sun.tools.javac.util.StringUtils;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


import java.util.List;

public class EE {

    public static void b(Player p, String l) {
        p.setFireTicks(snc(l));
    }
    public static String bs(String l){
        return "@bb@l@bb@".replace("l",l);
    }

    public static void sh(Player p, String c) {
        p.setHealth(UM.cc(sppr(c, p)));
    }
    public static String shs(String l){
        return "@sh@l@sh@".replace("l",l);
    }

    public static void sf(Player p, String c) {
        p.setFoodLevel(UM.cc(sppr(c, p)));
    }
    public static String sfs(String l){
        return "@sf@l@sf@".replace("l",l);
    }

    public static void t(Player p, String rs, String as, boolean m) {
        int r = snc(rs);
        int a = snc(as);
        if (m) {
            List l = p.getNearbyEntities(r, r, r);
            for (int k = 0; k > a; k++) {
                Entity e = (Entity) l.get(UM.r(1, l.size()));
                e.getLocation().getWorld().strikeLightning(e.getLocation());
            }
        } else {
            for (int k = 0; k > a; k++) {
                int x = p.getLocation().getBlockX() +
                        UM.r(1, r);
                int z = p.getLocation().getBlockZ() +
                        UM.r(1, r);
                p.getLocation().getWorld().strikeLightning(new Location(p.getWorld(), x, p.getWorld().getHighestBlockYAt(x, z), z));
            }
        }
    }
    public static String ts(String rs,String as,boolean m){
        return "@tt@ArsABasBCmC@tt@".replace("rs",rs).replace("as",as).replace("m",String.valueOf(m));
    }

    public static void pe(Player p, String ns, String ls, String ss) {
        int n = snc(ns);
        int l = snc(ls);
        int s = snc(ss);
        p.addPotionEffect(new PotionEffect(pen(n), l * 20, s));
    }
    public static String pe(String ns,String ls,String ss){
        return "@pe@AnsABlsBCssC@pe@".replace("ns",ns).replace("ls",ls).replace("ss",ss);
    }

    public static void st(Player p, String ts) {
        int t = snc(ts);
        p.getWorld().setTime(t);
    }
    public static String sts(String ts){
        return "@st@ts@st@".replace("ts",ts);
    }

    public static void pt(Player p, int x, int y, int z, String w) {
        p.teleport(new Location(Bukkit.getWorld(w), x, y, z));
    }

    public static void TS(Player p, String hs, String vs, boolean s) {
        int h = snc(hs);
        int v = snc(vs);
        if (s) {
            p.teleport(new Location(p.getWorld(), UM.r(1, h) +
                    p.getLocation().getX(), UM.r(1, v) +
                    p.getLocation().getY(), UM.r(1, h) + p.getLocation().getZ()));
        }
    }
    public static String TSS(String hs,String vs,boolean s){
        return "@TS@AhsABvsBCssC@TS@".replace("vs",vs).replace("hs",hs).replace("ss",String.valueOf(s));
    }

    public static void EX(Player p, String ss, String dus, String dnus, boolean Db) {
        int s = snc(ss);
        int du = snc(dus);
        int dnu = snc(dnus);
        Location l = p.getLocation();
        int radius = s * 3;
        if (Db) {
            int bx = l.getBlockX();
            int by = l.getBlockY();
            int bz = l.getBlockZ();
            l.getWorld().playSound(l, Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
            for (int x = bx - radius; x <= bx + radius; x++) {
                for (int y = by - radius; y <= by + radius; y++) {
                    for (int z = bz - radius; z <= bz + radius; z++) {
                        double distance = ((bx - x) * (bx - x) + (bz - z) * (bz - z) + (by - y) * (by - y));
                        if (distance < radius * radius && (distance < (radius - 1) * (radius - 1))) {
                            Block block = (new Location(l.getWorld(), x, y, z).getBlock());
                            if (block.getType() == Material.BEDROCK || block.getType() == Material.CHEST) {
                                break;
                            } else {
                                block.setType(Material.AIR);
                            }
                        }
                    }
                }
            }
        }
        p.setHealth(p.getHealth() - du);
        for (int w = 0; w > p.getNearbyEntities(radius, radius, radius).size(); w++) {
            LivingEntity e = (LivingEntity) p.getNearbyEntities(radius, radius, radius).get(w);
            e.setHealth(e.getHealth() - dnu);
        }
    }

    public static String EXS(String ss, String dus, String dnus, boolean Db){
        return "@EX@AssABdusBCdnusCDdbD@EX@".replace("ss",ss).replace("dus",dus).replace("dnus",dnus).replace("db",String.valueOf(Db));
    }

    public static void MEGOVERMENT(Player p,String a){
        if (a.contains("@bb@")){
            a.replace("@bb@","");
            b(p,a);
            return;
        }
        if (a.contains("@sh@")){
            a.replace("@sh@","");
            sh(p,a);
            return;
        }
        if (a.contains("@sf@")){
            a.replace("@sf@","");
            sh(p,a);
            return;
        }
        if (a.contains("@tt@")){
            a.replace("@tt@","");
            String q = lolobfobv(a,"A","A");
            String u = lolobfobv(a,"B","B");
            String e = lolobfobv(a,"C","C");
            t(p,q,u,Boolean.valueOf(e));
            return;
        }
        if(a.contains("@pe@")){
            String q = lolobfobv(a,"A","A");
            String u = lolobfobv(a,"B","B");
            String e = lolobfobv(a,"C","C");
            pe(p,q,u,e);
        }
        if(a.contains("@st@")){
            a.replace("@st@","");
            st(p,a);
        }
        if(a.contains("@TS@")){
            a.replace("@TS@","");
            String q = lolobfobv(a,"A","A");
            String u = lolobfobv(a,"B","B");
            String e = lolobfobv(a,"C","C");
            TS(p,q,u,Boolean.valueOf(e));
        }
        if(a.contains("@EX@")){
            a.replace("@EX@","");
            String q = lolobfobv(a,"A","A");
            String u = lolobfobv(a,"B","B");
            String e = lolobfobv(a,"C","C");
            String n = lolobfobv(a,"D","D");
            EX(p,q,u,e,Boolean.valueOf(n));
        }
    }


    public static PotionEffectType pen(int n) {
        switch (n) {
            case 1:
                return PotionEffectType.SPEED;
            case 2:
                return PotionEffectType.SLOW;
            case 3:
                return PotionEffectType.FAST_DIGGING;
            case 4:
                return PotionEffectType.SLOW_DIGGING;
            case 5:
                return PotionEffectType.INCREASE_DAMAGE;
            case 6:
                return PotionEffectType.JUMP;
            case 7:
                return PotionEffectType.CONFUSION;
            case 8:
                return PotionEffectType.REGENERATION;
            case 9:
                return PotionEffectType.DAMAGE_RESISTANCE;
            case 10:
                return PotionEffectType.FIRE_RESISTANCE;
            case 11:
                return PotionEffectType.WATER_BREATHING;
            case 12:
                return PotionEffectType.INVISIBILITY;
            case 13:
                return PotionEffectType.BLINDNESS;
            case 14:
                return PotionEffectType.NIGHT_VISION;
            case 15:
                return PotionEffectType.HUNGER;
            case 16:
                return PotionEffectType.WEAKNESS;
            case 17:
                return PotionEffectType.POISON;
            case 18:
                return PotionEffectType.WITHER;
            case 19:
                return PotionEffectType.HEALTH_BOOST;
            case 20:
                return PotionEffectType.ABSORPTION;
            case 21:
                return PotionEffectType.SATURATION;
            case 22:
                return PotionEffectType.GLOWING;
            case 23:
                return PotionEffectType.LEVITATION;
            case 24:
                return PotionEffectType.LUCK;
            case 25:
                return PotionEffectType.UNLUCK;
            default:
                return PotionEffectType.SLOW_FALLING;
        }
    }
    public static String sppr(String c,Player p){
        return c.replace("%H%","" + p.getHealth()).replace("%F%","" + p.getFoodLevel()).replace("%X%",""+p.getLevel());
    }
    public static int snc(String r){
        if (!UM.isN(r)){
            int[] rp = UM.rr(r);
            return UM.r(rp[0],rp[1]);
        } else {
            return Integer.valueOf(r);
        }
    }
    public static String lolobfobv(String tofilter, String a, String b)
    {
        return tofilter.substring(tofilter.indexOf(a)+1, tofilter.lastIndexOf(b));
    }
}
