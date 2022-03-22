package com.logic.utils.ia.algos;

import com.logic.dto.data.Allegiance;
import com.logic.dto.data.Character;
import com.logic.dto.data.World;

public class AttackProcessor
{
    public static boolean canAttack(Character c, World w)
    {   // Polymorphisme
        return canAttack(c.getX(), c.getY(), c.getAllegiance(), c.getWeapon().isRanged(), w);
    }

    public static boolean canAttack(int x, int y, Allegiance a, boolean ranged, World w)
    {
        // Masque des cases occupées
        Boolean[][] occupiedMask = new Boolean[w.getStaticEntities().length][w.getStaticEntities()[0].length];

        for (int i = 0; i < w.getStaticEntities().length; i++)
        {
            for (int j = 0; j < w.getStaticEntities()[i].length; j++)
            {
                occupiedMask[i][j] = false;
            }
        }

        for (Character c : w.getCharacters())
        {
            if (c.getAllegiance() != a)
            {
                occupiedMask[c.getX()][c.getY()] = true;
            }
        }

        if (ranged)
        {
            return canAttackRanged(x, y, w, a, occupiedMask);
        }
        else
        {
            return canAttackNotRanged(x, y, w, a, occupiedMask);
        }
    }

    private static boolean canAttackRanged(int x, int y, World w, Allegiance a, Boolean[][] mask)
    {
        for (int i = x-2; i < x+2; i += 4)
        {
            if (0 < i && i < w.getStaticEntities().length)
            {
                if (mask[i][y])
                {
                    return true;
                }
            }
        }

        for (int j = y-2; j < y+2; j += 4)
        {
            if (0 < j && j < w.getStaticEntities()[0].length)
            {
                if (mask[x][j])
                {
                    return true;
                }
            }
        }

        for (int i = x-1; i < x+1; i += 2)
        {
            if (0 < i && i < w.getStaticEntities().length && 0 < y+1 && y+1 < w.getStaticEntities()[0].length)
            {
                if (mask[i][y+1])
                {
                    return true;
                }
            }
        }

        for (int i = x-1; i < x+1; i += 2)
        {
            if (0 < i && i < w.getStaticEntities().length && 0 < y-1 && y-1 < w.getStaticEntities()[0].length)
            {
                if (mask[i][y-1])
                {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean canAttackNotRanged(int x, int y, World w, Allegiance a, Boolean[][] mask)
    {
        for (int i = x-1; i <= x+1; i += 2)
        {
            if (0 < i && i < w.getStaticEntities().length)
            {
                if (mask[i][y])
                {
                    return true;
                }
            }
        }

        for (int j = y-1; j <= y+1; j += 2)
        {
            if (0 < j && j < w.getStaticEntities()[0].length)
            {
                if (mask[x][j])
                {
                    return true;
                }
            }
        }

        return false;
    }
}
