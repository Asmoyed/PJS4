package com.logic.battleHelper;

import com.logic.dto.data.Accesibility;
import com.logic.dto.data.Tile;
import com.logic.dto.data.World;
import com.logic.dto.data.Character;

import java.util.LinkedList;

public class Range
{
    public static Boolean[][] getRange(Character character, World world)
    {
        // Init
        int xSize = world.getStaticEntities().length;
        int ySize;
        int mvPt = character.getCharacterClass().getMovementPoint();

        if (xSize <= 0)
        {
            throw new RuntimeException("Invalid map");
        }

        ySize = world.getStaticEntities()[0].length;

        if (ySize <= 0)
        {
            throw new RuntimeException("Invalid map");
        }

        Boolean[][] rangeMap = new Boolean[xSize][ySize]; // Retour
        Boolean[][] closed = new Boolean[xSize][ySize]; // Points fermées
        int[][] distances = new int[xSize][ySize]; // Distances à l'origine

        for (int i = 0; i < xSize; i++)
        {
            for (int j = 0; j < ySize; j++)
            {
                rangeMap[i][j] = false;
                closed[i][j] = false;
                distances[i][j] = Integer.MAX_VALUE;
            }
        }

        // Points à explorer
        LinkedList<Integer> openX = new LinkedList<>();
        LinkedList<Integer> openY = new LinkedList<>();

        openX.add(character.getX());
        openY.add(character.getY());
        distances[character.getX()][character.getY()] = 0;

        // Calcul
        while (!openX.isEmpty() || !openY.isEmpty())
        {
            int tempX = openX.pop();
            int tempY = openY.pop();
            int tempDist = distances[tempX][tempY];

            if (tempDist > mvPt)
            {
                continue;
            }

            // Protection contre les boucles infinies
            if (!closed[tempX][tempY])
            {
                closed[tempX][tempY] = true;
                rangeMap[tempX][tempY] = true;

                // On ajoute les deux points sur l'axe X
                for (int i = -1; i <= 1; i = i + 2)
                {
                    if (tempX+i > 0 && tempX+i <= xSize)
                    {
                        if (((Tile)world.getStaticEntities()[tempX+i][tempY]).getAccesibility() != Accesibility.NONE)
                        {
                            // On ajoute le point et on garde sa distance
                            openX.add(tempX+i);
                            openY.add(tempY);
                            distances[tempX+i][tempY] = tempDist+1;
                        }
                    }
                }

                // Idem pour les deux points sur l'axe Y
                for (int i = -1; i <= 1; i = i + 2)
                {
                    if (tempY+i > 0 && tempY+i <= ySize)
                    {
                        if (((Tile)world.getStaticEntities()[tempX][tempY+i]).getAccesibility() != Accesibility.NONE)
                        {
                            // On ajoute le point et on garde sa distance
                            openX.add(tempX);
                            openY.add(tempY+i);
                            distances[tempX][tempY+i] = tempDist+1;
                        }
                    }
                }
            }
        }

        rangeMap[character.getX()][character.getY()] = false;
        return rangeMap;
    }
}
