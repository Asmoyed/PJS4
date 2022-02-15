package com.logic.dto.data;

public class CharacterClass 
{
    // Attributs

    private int movementPoint;
    private float healthMultiplier;
    private float strengthMultiplier;
    private float defenceMultiplier;
    private float magicMultiplier;
    private float resistanceMultiplier;
    private float talentMultiplier;
    private float luckMultiplier;

    // Constructeur

    public CharacterClass(int movementPoint, float healthMultiplier, float strengthMultiplier, float defenceMultiplier, float magicMultiplier, float resistanceMultiplier, float talentMultiplier, float luckMultiplier) 
    {
        this.movementPoint = movementPoint;
        this.healthMultiplier = healthMultiplier;
        this.strengthMultiplier = strengthMultiplier;
        this.defenceMultiplier = defenceMultiplier;
        this.magicMultiplier = magicMultiplier;
        this.resistanceMultiplier = resistanceMultiplier;
        this.talentMultiplier = talentMultiplier;
        this.luckMultiplier = luckMultiplier;
    }

    // Getter et Setter

    public int getMovementPoint() 
    {
        return movementPoint;
    }
    public void setMovementPoint(int movementPoint) 
    {
        this.movementPoint = movementPoint;
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
