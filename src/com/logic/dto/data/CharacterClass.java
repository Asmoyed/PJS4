package com.logic.dto.data;

public class CharacterClass 
{
    // Attributs

    private int movementPoint;
    private float healthMultiplier;
    private float strengthMultiplier;
    private float defenceMultiplier;
    private float speedMultiplier;

    // Constructeur

    public CharacterClass(int movementPoint, float healthMultiplier, float strengthMultiplier, float defenceMultiplier, float speedMultiplier)
    {
        this.movementPoint = movementPoint;
        this.healthMultiplier = healthMultiplier;
        this.strengthMultiplier = strengthMultiplier;
        this.defenceMultiplier = defenceMultiplier;
        this.speedMultiplier = speedMultiplier;

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

    public float getSpeedMultiplier()
    {
        return speedMultiplier;
    }
    public void setSpeedMultiplier(float luckMultiplier)
    {
        this.speedMultiplier = luckMultiplier;
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
