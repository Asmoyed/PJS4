package com.logic.dto.data;

public class Character extends DynamicEntity
{
    // Attributs

    private String name;
    private String secondName;
    private String description;

    private CharacterState state;
    private Allegiance allegiance;
    private Weapon weapon;
    private CharacterClass characterClass;
    private ElementType element;
    private Stats stats;

    // Constructeurs

    public Character(int x, int y, Direction direction, String name, String secondName, String description, CharacterState state, Allegiance allegiance, Weapon weapon, CharacterClass characterClass, ElementType element, Stats stats)
    {
        super(x,y,direction);
        this.name = name;
        this.secondName = secondName;
        this.description = description;
        this.state = state;
        this.allegiance = allegiance;
        this.weapon = weapon;
        this.characterClass = characterClass;
        this.element = element;
        this.stats = stats;
    }

    // Getters et Setters

    public String getName() 
    {
        return name;
    }
    public ElementType getElement() 
    {
        return element;
    }
    public void setElement(ElementType element) 
    {
        this.element = element;
    }
    public CharacterClass getCharacterClass() 
    {
        return characterClass;
    }
    public void setCharacterClass(CharacterClass characterClass) 
    {
        this.characterClass = characterClass;
    }
    public Weapon getWeapon() 
    {
        return weapon;
    }
    public void setWeapon(Weapon weapon) 
    {
        this.weapon = weapon;
    }
    public Allegiance getAllegiance() 
    {
        return allegiance;
    }
    public void setAllegiance(Allegiance allegiance) 
    {
        this.allegiance = allegiance;
    }
    public CharacterState getState() 
    {
        return state;
    }
    public void setState(CharacterState state) 
    {
        this.state = state;
    }
    public String getDescription() 
    {
        return description;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }
    public String getSecondName() 
    {
        return secondName;
    }
    public void setSecondName(String secondName) 
    {
        this.secondName = secondName;
    }
    public void setName(String name) 
    {
        this.name = name;
    }
    public Stats getStats()
    {
        return stats;
    }
    public void setStats(Stats stats)
    {
        this.stats = stats;
    }
}
