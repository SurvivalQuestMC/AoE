package net.survivalquest.aoe.AoEGen;

import net.survivalquest.aoe.AoE;
import net.survivalquest.aoe.AoEUtils;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AoEManager {

    private static AoE plugin;

    public AoEManager(AoE main){
        plugin = main;
    }

    private static List<AreaOfEffect> activeAreaOfEffects = new ArrayList<>();

    public static List<AreaOfEffect> getActiveAreaOfEffects() {
        return activeAreaOfEffects;
    }

    public static void addActiveEffect(AreaOfEffect effect){
        activeAreaOfEffects.add(effect);
    }

    public void update(AreaOfEffect effect){
        if (effect.getDuration() > 0){
            effect.setDuration(effect.getDuration() - 1);
        }
        else{
            activeAreaOfEffects.remove(effect);
        }
    }

    public void activateEffect(String key, Player player){
        AreaOfEffect effect = new AreaOfEffect(
                key,
                plugin.getConfiguration().getInt(key + ".Distance"),
                plugin.getConfiguration().getInt(key + ".Duration"),
                PotionEffectType.getByName(plugin.getConfiguration().getString(key + ".PotionEffect").toUpperCase()),
                Particle.valueOf(plugin.getConfiguration().getString(key + ".ParticleEffect").toUpperCase()),
                player.getLocation()
        );
        activeAreaOfEffects.add(effect);
        plugin.summonCircle(player.getLocation(), plugin.getConfiguration().getInt(key + ".Distance"), plugin.getConfiguration().getInt(key + ".Duration"), AoEUtils.getColorFromString(plugin.getConfiguration().getString(key + ".RingColour")));
    }
}
