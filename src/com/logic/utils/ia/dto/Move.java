package com.logic.utils.ia.dto;

public class Move
{
    private int originX;
    private int originY;
    private int destinationX;
    private int destinationY;
    private boolean fight;

    public Move(int originX, int originY, int destinationX, int destinationY, boolean fight)
    {
        this.originX = originX;
        this.originY = originY;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
        this.fight = fight;
    }

    public int getOriginX()
    {
        return originX;
    }

    public void setOriginX(int originX)
    {
        this.originX = originX;
    }

    public int getOriginY()
    {
        return originY;
    }

    public void setOriginY(int originY)
    {
        this.originY = originY;
    }

    public int getDestinationX()
    {
        return destinationX;
    }

    public void setDestinationX(int destinationX)
    {
        this.destinationX = destinationX;
    }

    public int getDestinationY()
    {
        return destinationY;
    }

    public void setDestinationY(int destinationY)
    {
        this.destinationY = destinationY;
    }

    public boolean isFight()
    {
        return fight;
    }

    public void setFight(boolean fight)
    {
        this.fight = fight;
    }
}
