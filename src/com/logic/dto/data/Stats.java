package com.logic.dto.data;

public class Stats
{
    private int health;
    private int maxHealth;
    private int strength;
    private int defence;
    private int speed;
    private int xp;
    private int maxXp;

    public Stats() {
    }

    public Stats(int health, int maxHealth, int strength, int defence, int speed, int xp, int maxXp)
    {
        this.health = health;
        this.maxHealth = maxHealth;
        this.strength = strength;
        this.defence = defence;
        this.speed = speed;
        this.xp = xp;
        this.maxXp = maxXp;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        if(health < 0) {
            this.health = 0;
            return;
        }
        this.health = health;
    }

    public int getMaxHealth()
    {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth)
    {
        if(maxHealth < 0) {
            this.maxHealth = 0;
            return;
        }
        this.maxHealth = maxHealth;
    }

    public int getStrength()
    {
        return strength;
    }

    public void setStrength(int strength)
    {
        this.strength = strength;
    }

    public int getDefence()
    {
        return defence;
    }

    public void setDefence(int defence)
    {
        this.defence = defence;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getMaxXp() {
        return maxXp;
    }

    public void setMaxXp(int maxXp) {
        this.maxXp = maxXp;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "health=" + health +
                ", maxHealth=" + maxHealth +
                ", strength=" + strength +
                ", defence=" + defence +
                ", speed=" + speed +
                ", xp=" + xp +
                ", maxXp=" + maxXp +
                '}';
    }
}
