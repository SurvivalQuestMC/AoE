package net.survivalquest.aoe;

import net.survivalquest.aoe.AoEGen.AoEManager;
import net.survivalquest.aoe.AoEGen.AreaOfEffect;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

public final class AoE extends JavaPlugin {

    @Override
    public void onEnable() {

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, (() -> {
            for (Player player : getServer().getOnlinePlayers()) {
                for (AreaOfEffect areaOfEffect : AoEManager.getAreaOfEffects()){
                    Location playerLoc = player.getLocation();

                    // check if the player is within the AOE radius
                    if (playerLoc.distance(areaOfEffect.getCentre()) <= areaOfEffect.getDistance()) {
                        // give player the effect
                        player.addPotionEffect(new PotionEffect(areaOfEffect.getEffectType(), areaOfEffect.getDuration() * 20, 1));

                        // show particles
                        player.getWorld().spawnParticle(areaOfEffect.getParticleType(), playerLoc, 10);
                    } else {
                        // remove effect from player
                        player.removePotionEffect(areaOfEffect.getEffectType());
                    }
                }
            }
        }), 0, 20);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
