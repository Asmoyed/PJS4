package com.logic.utils.ia.algos;

import com.logic.dto.data.Allegiance;
import com.logic.dto.data.Character;
import com.logic.dto.data.World;
import com.logic.utils.ia.dto.PositionResume;

import java.util.List;

public class AttackProcessor
{
    public static PositionResume getResume(Character c, World w)
    {   // Polymorphisme
        return getResume(c.getX(), c.getY(), c.getAllegiance(), c.getWeapon().isRanged(), w);
    }

    public static PositionResume getResume(int x, int y, Allegiance a, boolean ranged, World w)
    {
        // Objet retour
        PositionResume resume = new PositionResume();

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

        // Lookup ranged cases
        for (int i = x-2; i < x+2; i += 4)
        {
            if (0 < i && i < w.getStaticEntities().length)
            {
                if (occupiedMask[i][y])
                {
                    Character c = getCharacterAtPos(i, y, w.getCharacters());
                    if (ranged) // Si on attaque à distance
                    {
                        resume.getVictims().add(c);
                    }

                    if (c.getWeapon().isRanged()) // Si l'autre peut attaquer à distance
                    {
                        resume.getPredators().add(c);
                    }
                }
            }
        }

        for (int j = y-2; j < y+2; j += 4)
        {
            if (0 < j && j < w.getStaticEntities()[0].length)
            {
                if (occupiedMask[x][j])
                {
                    Character c = getCharacterAtPos(x, j, w.getCharacters());
                    if (ranged) // Si on attaque à distance
                    {
                        resume.getVictims().add(c);
                    }

                    if (c.getWeapon().isRanged()) // Si l'autre peut attaquer à distance
                    {
                        resume.getPredators().add(c);
                    }
                }
            }
        }

        for (int i = x-1; i < x+1; i += 2)
        {
            if (0 < i && i < w.getStaticEntities().length && 0 < y+1 && y+1 < w.getStaticEntities()[0].length)
            {
                if (occupiedMask[i][y+1])
                {
                    Character c = getCharacterAtPos(i, y+1, w.getCharacters());
                    if (ranged) // Si on attaque à distance
                    {
                        resume.getVictims().add(c);
                    }

                    if (c.getWeapon().isRanged()) // Si l'autre peut attaquer à distance
                    {
                        resume.getPredators().add(c);
                    }
                }
            }
        }

        for (int i = x-1; i < x+1; i += 2)
        {
            if (0 < i && i < w.getStaticEntities().length && 0 < y-1 && y-1 < w.getStaticEntities()[0].length)
            {
                if (occupiedMask[i][y-1])
                {
                    Character c = getCharacterAtPos(i, y-1, w.getCharacters());
                    if (ranged) // Si on attaque à distance
                    {
                        resume.getVictims().add(c);
                    }

                    if (c.getWeapon().isRanged()) // Si l'autre peut attaquer à distance
                    {
                        resume.getPredators().add(c);
                    }
                }
            }
        }

        for (int i = x-1; i <= x+1; i += 2)
        {
            if (0 < i && i < w.getStaticEntities().length)
            {
                if (occupiedMask[i][y])
                {
                    Character c = getCharacterAtPos(i, y, w.getCharacters());
                    if (!ranged) // Si on n'attaque pas à distance
                    {
                        resume.getVictims().add(c);
                    }

                    if (!c.getWeapon().isRanged()) // Si l'autre ne peut pas attaquer à distance
                    {
                        resume.getPredators().add(c);
                    }
                }
            }
        }

        for (int j = y-1; j <= y+1; j += 2)
        {
            if (0 < j && j < w.getStaticEntities()[0].length)
            {
                if (occupiedMask[x][j])
                {
                    Character c = getCharacterAtPos(x, j, w.getCharacters());
                    if (!ranged) // Si on n'attaque pas à distance
                    {
                        resume.getVictims().add(c);
                    }

                    if (!c.getWeapon().isRanged()) // Si l'autre ne peut pas attaquer à distance
                    {
                        resume.getPredators().add(c);
                    }
                }
            }
        }

        return resume;
    }

    private static Character getCharacterAtPos(int x, int y, List<Character> characters)
    {
        for (Character c : characters)
        {
            if (c.getX() == x && c.getY() == y)
            {
                return c;
            }
        }

        throw new RuntimeException("Character introuvable !");
    }
}
