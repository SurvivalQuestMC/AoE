package net.survivalquest.aoe;

import net.survivalquest.aoe.AoEGen.AoEManager;
import net.survivalquest.aoe.AoEGen.AreaOfEffect;
import net.survivalquest.aoe.Commands.AoECommand;
import net.survivalquest.aoe.Commands.TabCompleteAoE;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import java.io.File;

public final class AoE extends JavaPlugin {

    private AoEManager aoEManager;
    private FileConfiguration config = this.getConfig();
    private File dataFile;

    @Override
    public void onEnable() {
        aoEManager = new AoEManager(this);
        this.getCommand("areaofeffect").setExecutor(new AoECommand(this));
        this.getCommand("areaofeffect").setTabCompleter(new TabCompleteAoE(this));
        this.reloadConfiguration();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, (() -> {
            for (Player player : getServer().getOnlinePlayers()) {
                for (AreaOfEffect areaOfEffect : AoEManager.getActiveAreaOfEffects()){
                    Location playerLoc = player.getLocation();
                    aoEManager.update(areaOfEffect);
                    // check if the player is within the AOE radius
                    if (playerLoc.distance(areaOfEffect.getCentre()) <= areaOfEffect.getDistance()) {
                        // give player the effect
                        player.addPotionEffect(new PotionEffect(areaOfEffect.getEffectType(), 25, 1));

                        // show particles
                        player.getWorld().spawnParticle(areaOfEffect.getParticleType(), playerLoc, 50);
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

    public AoEManager getAoEManager() {
        return aoEManager;
    }

    public FileConfiguration getConfiguration(){
        return this.config;
    }

    public void reloadConfiguration() {
        this.dataFile = new File(this.getDataFolder().getAbsolutePath() + "/config.yml");
        if (!this.dataFile.exists()) {
            this.getDataFolder().mkdir();
            this.saveResource("config.yml", false);
        }
        this.reloadConfig();
        this.config = this.getConfig();
    }

    public void summonCircle(Location location , int size , int duration, Color color) {
        new BukkitRunnable() {
            int i = 0;
            public void run() {
                i++;
                if(i == duration) {
                    this.cancel();
                }
                for (int d = 0; d <= 90; d += 1) {
                    Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
                    particleLoc.setX(location.getX() + Math.cos(d) * size);
                    particleLoc.setZ(location.getZ() + Math.sin(d) * size);
                    location.getWorld().spawnParticle(Particle.REDSTONE, particleLoc, 1, new Particle.DustOptions(color, 1));
                }
            }
        }.runTaskTimer(this, 0, 20);
    }
}

