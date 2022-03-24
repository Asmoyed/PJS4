package com.logic.utils.ia.dto;

import com.logic.dto.data.Character;

import java.util.ArrayList;
import java.util.List;

public class PositionResume
{
    private List<Character> victims;
    private List<Character> predators;

    public PositionResume()
    {
        this.victims = new ArrayList<Character>();
        this.predators = new ArrayList<Character>();
    }

    public List<Character> getVictims()
    {
        return this.victims;
    }

    public void setVictims(List<Character> victims)
    {
        this.victims = victims;
    }

    public List<Character> getPredators()
    {
        return this.predators;
    }

    public void setPredators(List<Character> predators)
    {
        this.predators = predators;
    }
}
