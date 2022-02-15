package com.logic.dto.data;

public class Skill 
{
    // Attributs

    private int turnsLeft;
    private float healthMultiplier;
    private float strengthMultiplier;
    private float defenceMultiplier;
    private float magicMultiplier;
    private float resistanceMultiplier;
    private float talentMultiplier;
    private float luckMultiplier;
    private float maxHealthMultiplier;
    private float speedMultiplier;

    // Constructeur

    public Skill(int turnsLeft, float healthMultiplier, float strengthMultiplier, float defenceMultiplier, float magicMultiplier, float resistanceMultiplier, float talentMultiplier, float luckMultiplier, float maxHeathMultiplier, float speedMultiplier) 
    {
        this.turnsLeft = turnsLeft;
        this.healthMultiplier = healthMultiplier;
        this.strengthMultiplier = strengthMultiplier;
        this.defenceMultiplier = defenceMultiplier;
        this.magicMultiplier = magicMultiplier;
        this.resistanceMultiplier = resistanceMultiplier;
        this.talentMultiplier = talentMultiplier;
        this.luckMultiplier = luckMultiplier;
        this.healthMultiplier = healthMultiplier;
        this.speedMultiplier = speedMultiplier;
    }

    // Methodes


    public boolean toRemove()
    {
        turnsLeft--;
        return turnsLeft <= 0;
    }

    // Getters et Setters

    public float getSpeedMultiplier() {
        return speedMultiplier;
    }

    public void setSpeedMultiplier(float speedMultiplier) {
        this.speedMultiplier = speedMultiplier;
    }

    public float getMaxHealthMultiplier() {
        return maxHealthMultiplier;
    }

    public void setMaxHealthMultiplier(float maxHealthMultiplier) {
        this.maxHealthMultiplier = maxHealthMultiplier;
    }

    public float getLuckMultiplier() 
    {
        return luckMultiplier;
    }

    public void setLuckMultiplier(float luckMultiplier) 
    {
        this.luckMultiplier = luckMultiplier;
    }

    public float getTalentMultiplier() 
    {
        return talentMultiplier;
    }

    public void setTalentMultiplier(float talentMultiplier) 
    {
        this.talentMultiplier = talentMultiplier;
    }

    public float getResistanceMultiplier() 
    {
        return resistanceMultiplier;
    }

    public void setResistanceMultiplier(float resistanceMultiplier) 
    {
        this.resistanceMultiplier = resistanceMultiplier;
    }

    public float getMagicMultiplier() 
    {
        return magicMultiplier;
    }

    public void setMagicMultiplier(float magicMultiplier) 
    {
        this.magicMultiplier = magicMultiplier;
    }

    public float getDefenceMultiplier() 
    {
        return defenceMultiplier;
    }

    public void setDefenceMultiplier(float defenceMultiplier) 
    {
        this.defenceMultiplier = defenceMultiplier;
    }

    public float getStrengthMultiplier() 
    {
        return strengthMultiplier;
    }

    public void setStrengthMultiplier(float strengthMultiplier) 
    {
        this.strengthMultiplier = strengthMultiplier;
    }

    public float getHealthMultiplier() 
    {
        return healthMultiplier;
    }

    public void setHealthMultiplier(float healthMultiplier) 
    {
        this.healthMultiplier = healthMultiplier;
    }
}
