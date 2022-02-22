package com.logic.utils.ia.algos;

import com.logic.battleHelper.Range;
import com.logic.dto.data.Allegiance;
import com.logic.dto.data.DynamicEntity;
import com.logic.dto.data.Character;
import com.logic.dto.data.StaticEntity;
import com.logic.dto.data.World;
import com.logic.utils.ia.dto.Move;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MoveCalculator
{
    public static List<Move> generatesMoves(Allegiance allegiance, World world)
    {
        // INIT
        StaticEntity[][] terrain = world.getStaticEntities();
        List<Character> worldCharacters = world.getCharacters();
        List<Character> characters = new ArrayList<Character>();
        List<Move> moves = new LinkedList<Move>();

        for (Character c : worldCharacters)
        {
            if (c.getAllegiance() == allegiance)
            {
                characters.add(c);
            }
        }

        // Masque des cases occupées
        Boolean[][] occupiedMask = new Boolean[terrain.length][terrain[0].length];

        for (int i = 0; i < terrain.length; i++)
        {
            for (int j = 0; j < terrain[i].length; j++)
            {
                occupiedMask[i][j] = false;
            }
        }

        for (Character c : worldCharacters)
        {
            occupiedMask[c.getX()][c.getY()] = true;
        }


        // Pour chaque character jouable on regade tt les déplacements possible
        for (Character c : characters)
        {
            Boolean[][] mask = Range.getRange(c, world);

            for (int i = 0; i < terrain.length; i++)
            {
                for (int j = 0; j < terrain[i].length; j++)
                {
                    if (mask[i][j]) // Pour eviter d'essayer de se déplacer plus loin que autorisé
                    {
                        if (!occupiedMask[i][j])
                        {

                        }
                    }
                }
            }
        }

        // TODO

        return moves;
    }

    private static boolean canAttack(Character c, int x, int y)
    {
        /*if (c.getWeapon().isRanged())
        {

        }


        try
        {

        }
        catch (IndexOutOfBoundsException e)
        {

        }*/

        // TODO IMPLEMENT

        return false;
    }
}
