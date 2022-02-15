package com.logic.utils.pathfinding.dto;

public class ASPoint extends PathPoint implements Comparable<ASPoint>
{
    private int gCost;
    private int fCost;

    public ASPoint(int x, int y, boolean walkable)
    {
        super(x, y, walkable);
        // On initialise à +inf
        this.gCost = Integer.MAX_VALUE;
        this.fCost = Integer.MAX_VALUE;
    }

    public int getgCost()
    {
        return gCost;
    }

    public void setgCost(int gCost)
    {
        this.gCost = gCost;
    }

    public int getfCost()
    {
        return fCost;
    }

    public void setfCost(int fCost)
    {
        this.fCost = fCost;
    }

    public void setWalkable(boolean walkable)
    {
        this.walkable = walkable;
    }

    @Override
    public int compareTo(ASPoint o)
    {
        return this.fCost - o.fCost;
    }
}
