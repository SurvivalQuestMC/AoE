package net.survivalquest.aoe.AoEGen;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class AreaOfEffect {

    private int Distance, Duration;

    private Location centre;

    private PotionEffectType effectType;

    private Particle particleType;

    private String name;

    private Player aoePlayer;

    public AreaOfEffect(String id, int Dist, int Dur, PotionEffectType effect, Particle particle, Location loc){
        Distance = Dist;
        Duration = Dur;
        effectType = effect;
        particleType = particle;
        name = id;
        centre = loc;
    }

    public int getDistance() {
        return Distance;
    }

    public void setDistance(int distance) {
        Distance = distance;
    }

    public Location getCentre() {
        return centre;
    }

    public void setCentre(Location centre) {
        this.centre = centre;
    }

    public PotionEffectType getEffectType() {
        return effectType;
    }

    public void setEffectType(PotionEffectType effectType) {
        this.effectType = effectType;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public Particle getParticleType() {
        return particleType;
    }

    public void setParticleType(Particle particleType) {
        this.particleType = particleType;
    }

    public Player getAoePlayer() {
        return aoePlayer;
    }

    public void setAoePlayer(Player aoePlayer) {
        this.aoePlayer = aoePlayer;
    }
}
