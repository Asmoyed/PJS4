package com.logic.dto.data;

import java.util.ArrayList;
import java.util.List;

import com.logic.dto.interfaces.NotifyTurn;

public class SkilledCharacter extends DynamicEntity implements NotifyTurn
{
    // Attributs
    private List<Skill> skills;
    private Character character;
    private boolean upToDate; // Indique si les valeurs en cache sont fiables
    private int health;
    private int strength;
    private int defence;
    private int magic;
    private int resistance;
    private int talent;
    private int luck;
    private int maxHealth;
    private int speed;

    public SkilledCharacter(int x, int y, Direction direction, Character character)
    {
        super(x, y, direction);
        this.character = character;
        // Array list car beaucoup d'ajouts suppresions
        this.skills = new ArrayList<Skill>();
        this.upToDate = false;
        calcStats();
    }

    // Getter et setter delegues
    public String getName() 
    {
        return this.character.getName();
    }
    public ElementType getElement() 
    {
        return this.character.getElement();
    }
    public void setElement(ElementType element) 
    {
        this.character.setElement(element);
    }
    public CharacterClass getCharacterClass() 
    {
        return this.character.getCharacterClass();
    }
    public void setCharacterClass(CharacterClass characterClass) 
    {
        this.character.setCharacterClass(characterClass);
    }
    public Weapon getWeapon() 
    {
        return this.character.getWeapon();
    }
    public void setWeapon(Weapon weapon) 
    {
        this.character.setWeapon(weapon);
    }
    public Allegiance getAllegiance() 
    {
        return this.character.getAllegiance();
    }
    public void setAllegiance(Allegiance allegiance) 
    {
        this.character.setAllegiance(allegiance);
    }
    public CharacterState getState() 
    {
        return this.character.getState();
    }
    public void setState(CharacterState state) 
    {
        this.character.setState(state);
    }
    public int getMaxXp() 
    {
        return this.character.getStats().getMaxXp();
    }
    public void setMaxXp(int maxXp) 
    {
        this.character.getStats().setMaxXp(maxXp);
    }
    public int getXp() 
    {
        return this.character.getStats().getXp();
    }
    public void setXp(int xp) 
    {
        this.character.getStats().setXp(xp);
    }
    public String getDescription() 
    {
        return this.character.getDescription();
    }
    public void setDescription(String description) 
    {
        this.character.setDescription(description);
    }
    public String getSecondName() 
    {
        return this.character.getSecondName();
    }
    public void setSecondName(String secondName) 
    {
        this.character.setSecondName(secondName);
    }
    public void setName(String name) 
    {
        this.character.setName(name);
    }
    public void setLuck(int luck) 
    {
        this.character.getStats().setLuck(luck);
    }
    public void setTalent(int talent) 
    {
        this.character.getStats().setTalent(talent);
    }
    public void setSpeed(int speed) 
    {
        this.character.getStats().setSpeed(speed);
    }
    public void setResistance(int resistance) 
    {
        this.character.getStats().setResistance(resistance);
    }
    public void setMagic(int magic) 
    {
        this.character.getStats().setMagic(magic);
    }
    public void setDefence(int defence) 
    {
        this.character.getStats().setDefence(defence);
    }
    public void setStrenght(int strenght) 
    {
        this.character.getStats().setStrength(strenght);
    }
    public void setMaxHealth(int maxHealth) 
    {
        this.character.getStats().setMaxHealth(maxHealth);
    }
    public void setHealth(int health) 
    {
        this.character.getStats().setHealth(health);
    }

    // Facade avec les skills

    public int getLuck() 
    {
        calcStats();
        return luck;
    }
    public int getTalent() 
    {
        calcStats();
        return talent;
    }
    public int getSpeed() 
    {
        calcStats();
        return speed;
    }
    public int getResistance() 
    {
        calcStats();
        return resistance;
    }
    public int getMagic() 
    {
        calcStats();
        return magic;
    }
    public int getDefence() 
    {
        calcStats();
        return defence;
    }
    public int getStrength() 
    {
        calcStats();
        return strength;
    }
    public int getMaxHealth() 
    {
        calcStats();
        return maxHealth;
    }
    public int getHealth() 
    {
        calcStats();
        return health;
    }

    // Méthodes

    public void addSkill(Skill skill)
    {
        this.skills.add(skill);
        this.upToDate = false;
    }

    @Override
    public void notifyTurn() 
    {
        for (Skill s : this.skills)
        {
            if (s.toRemove())
            {
                skills.remove(s);
                upToDate = false;
            }
        }
    }

    private void calcStats()
    {
        if (!upToDate) // Si la classe n'est pas a jour
        {
            // Reset des stats
            this.health = this.character.getStats().getHealth();
            this.strength = this.character.getStats().getStrength();
            this.defence = this.character.getStats().getDefence();
            this.magic = this.character.getStats().getMagic();
            this.resistance = this.character.getStats().getResistance();
            this.talent = this.character.getStats().getTalent();
            this.luck = this.character.getStats().getLuck();
            this.maxHealth = this.character.getStats().getMaxHealth();
            this.speed = this.character.getStats().getSpeed();

            for (Skill s : this.skills)
            {
                this.health *= s.getHealthMultiplier();
                this.strength *= s.getStrengthMultiplier();
                this.defence *= s.getDefenceMultiplier();
                this.magic *= s.getMagicMultiplier();
                this.resistance *= s.getResistanceMultiplier();
                this.talent *= s.getTalentMultiplier();
                this.luck *= s.getLuckMultiplier();
                this.maxHealth *= s.getMaxHealthMultiplier();
                this.speed *= s.getSpeedMultiplier();
            }

            this.upToDate = true;
        }
    }
}
