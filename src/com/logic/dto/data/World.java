package com.logic.dto.data;

import java.util.ArrayList;
import java.util.List;

public class World 
{
    private StaticEntity[][] staticEntities;
    private List<DynamicEntity> dynamicEntities;

    public World(StaticEntity[][] staticEntities) 
    {
        this.staticEntities = staticEntities;
        this.dynamicEntities = new ArrayList<DynamicEntity>();
    }
    
    public StaticEntity[][] getStaticEntities() 
    {
        return staticEntities;
    }
    public List<DynamicEntity> getDynamicEntities() 
    {
        return dynamicEntities;
    }

    public void setDynamicEntities(List<DynamicEntity> dynamicEntities) 
    {
        this.dynamicEntities = dynamicEntities;
    }
    public void setStaticEntities(StaticEntity[][] staticEntities) 
    {
        this.staticEntities = staticEntities;
    }    
}
