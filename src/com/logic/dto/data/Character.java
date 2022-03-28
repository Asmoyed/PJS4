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
    private Stats stats;

    // Constructeurs

    public Character()
    {
        super(-1, -1, null);
    }

    public Character(int x, int y, Direction direction) {
        super(x, y, direction);
    }

    public Character(int x, int y, Direction direction, String name, String secondName, String description, CharacterState state, Allegiance allegiance, Weapon weapon, CharacterClass characterClass, Stats stats)
    {
        super(x,y,direction);
        this.name = name;
        this.secondName = secondName;
        this.description = description;
        this.state = state;
        this.allegiance = allegiance;
        this.weapon = weapon;
        this.characterClass = characterClass;
        this.stats = stats;
    }

    // Getters et Setters

    public String getName() 
    {
        return name;
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

    // Formules

    public void attack(Character ennemy) {
        ennemy.getStats().setHealth(ennemy.getStats().getHealth() - this.damageValue(ennemy));
    }

    public int damageValue(Character victim) {

        // à revoir les coeffs
        double coefWeapon = 1.;
        double coefElem = 1.;
        if(!(getWeapon().isRanged()) && !(victim.getWeapon().isRanged())) {
            if(getWeapon().getWeaponType() == WeaponType.SWORD && victim.getWeapon().getWeaponType() == WeaponType.AXE)
                coefWeapon = 1.5;
            if(getWeapon().getWeaponType() == WeaponType.AXE && victim.getWeapon().getWeaponType() == WeaponType.LANCE)
                coefWeapon = 1.5;
            if(getWeapon().getWeaponType() == WeaponType.LANCE && victim.getWeapon().getWeaponType() == WeaponType.SWORD)
                coefWeapon = 1.5;
        }
        if(getWeapon().isRanged() && victim.getWeapon().isRanged()) {
            if(getWeapon().getWeaponType() == WeaponType.THROWABLE && victim.getWeapon().getWeaponType() == WeaponType.GUN)
                coefWeapon = 1.5;
            if(getWeapon().getWeaponType() == WeaponType.GUN && victim.getWeapon().getWeaponType() == WeaponType.BOW)
                coefWeapon = 1.5;
            if(getWeapon().getWeaponType() == WeaponType.BOW && victim.getWeapon().getWeaponType() == WeaponType.THROWABLE)
                coefWeapon = 1.5;
        }


        if(getWeapon().getElement() == ElementType.AQUA && victim.getWeapon().getElement() == ElementType.FIRE)
            coefElem = 1.5;
        if(getWeapon().getElement() == ElementType.EARTH && victim.getWeapon().getElement() == ElementType.LIGHTNING)
            coefElem = 1.5;
        if(getWeapon().getElement() == ElementType.AIR && victim.getWeapon().getElement() == ElementType.EARTH)
            coefElem = 1.5;
        if(getWeapon().getElement() == ElementType.FIRE && victim.getWeapon().getElement() == ElementType.AIR)
            coefElem = 1.5;
        if(getWeapon().getElement() == ElementType.LIGHTNING && victim.getWeapon().getElement() == ElementType.AIR)
            coefElem = 1.5;

        if ((int) Math.round((getStats().getStrength() + getWeapon().getDamage() - victim.getStats().getDefence()) * coefWeapon * coefElem) < 0)
            return 0;
        return (int) Math.round((getStats().getStrength() + getWeapon().getDamage() - victim.getStats().getDefence()) * coefWeapon * coefElem);
    }

    public int healValue() {
        // à revoir avec les skills
        return getWeapon().getDamage();
    }

    public void heal(Character victim) {
        victim.getStats().setHealth(victim.getStats().getHealth() + healValue());
        System.out.println(healValue());
    }

    public void speedAdvantage(Character ennemy) {
        if(getStats().getSpeed() > 5)
            getStats().setStrength(getStats().getStrength() * 2);
        else if(getStats().getSpeed() < -5)
            ennemy.getStats().setStrength(ennemy.getStats().getStrength() * 2);
    }
}