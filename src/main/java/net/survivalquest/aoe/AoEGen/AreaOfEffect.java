package net.survivalquest.aoe.AoEGen;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.potion.PotionEffectType;

public class AreaOfEffect {

    private int Distance, Duration;

    private Location centre;

    private PotionEffectType effectType;

    private Particle particleType;

    public int getDistance() {
        return Distance;
    }

    public Location getCentre() {
        return centre;
    }

    public PotionEffectType getEffectType() {
        return effectType;
    }

    public int getDuration() {
        return Duration;
    }

    public Particle getParticleType() {
        return particleType;
    }
}
