package com.logic.dto.data;

public class DynamicEntity extends Entity
{
    private Direction direction;

    public DynamicEntity(int x, int y, Direction direction) 
    {
        super(x, y);
        this.direction = direction;
    }

    public Direction getDirection() 
    {
        return direction;
    }

    public void setDirection(Direction direction) 
    {
        this.direction = direction;
    }
    
}
