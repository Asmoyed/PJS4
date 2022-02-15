package com.logic.dto.data;

public class Stats
{
    private int health;
    private int maxHealth;
    private int strength;
    private int defence;
    private int magic;
    private int resistance;
    private int speed;
    private int talent;
    private int luck;
    private int xp;
    private int maxXp;

    public Stats(int health, int maxHealth, int strength, int defence, int magic, int resistance, int speed, int talent, int luck, int xp, int maxXp)
    {
        this.health = health;
        this.maxHealth = maxHealth;
        this.strength = strength;
        this.defence = defence;
        this.magic = magic;
        this.resistance = resistance;
        this.speed = speed;
        this.talent = talent;
        this.luck = luck;
        this.xp = xp;
        this.maxXp = maxXp;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getMaxHealth()
    {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth)
    {
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

    public int getMagic()
    {
        return magic;
    }

    public void setMagic(int magic)
    {
        this.magic = magic;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTalent() {
        return talent;
    }

    public void setTalent(int talent) {
        this.talent = talent;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
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
}
