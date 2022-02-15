package com.logic.dto.data;

public class Weapon 
{
    private int damage;

    public Weapon(int damage, boolean ranged, String name, ElementType element) 
    {
        this.damage = damage;
        this.ranged = ranged;
        this.name = name;
        this.element = element;
    }

    private boolean ranged;
    private String name;
    private ElementType element;
    
    public int getDamage() 
    {
        return damage;
    }

    public ElementType getElement() 
    {
        return element;
    }

    public void setElement(ElementType element) 
    {
        this.element = element;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public boolean isRanged() 
    {
        return ranged;
    }

    public void setRanged(boolean ranged) 
    {
        this.ranged = ranged;
    }

    public void setDamage(int damage) 
    {
        this.damage = damage;
    }
}
