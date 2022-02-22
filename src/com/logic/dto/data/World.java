package com.logic.dto.data;

import java.util.ArrayList;
import java.util.List;

public class World 
{
    private StaticEntity[][] staticEntities;
    private List<Character> characters;

    public World(StaticEntity[][] staticEntities) 
    {
        this.staticEntities = staticEntities;
        this.characters = new ArrayList<Character>();
    }
    
    public StaticEntity[][] getStaticEntities() 
    {
        return staticEntities;
    }
    public List<Character> getCharacters()
    {
        return characters;
    }

    public void setDynamicEntities(List<Character> characters)
    {
        this.characters = characters;
    }
    public void setStaticEntities(StaticEntity[][] staticEntities) 
    {
        this.staticEntities = staticEntities;
    }    
}
