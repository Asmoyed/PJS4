import java.util.List;

import com.Galanthe;
import com.logic.dto.Serializer;
import com.logic.dto.data.*;
import com.logic.dto.data.Character;
import com.logic.utils.pathfinding.algos.AStarFinder;
import com.logic.utils.pathfinding.algos.JPSFinder;
import com.logic.utils.pathfinding.dto.ASPoint;
import com.logic.utils.pathfinding.dto.JPSPoint;
import com.logic.utils.pathfinding.dto.Path;
import com.logic.utils.pathfinding.dto.PathPoint;
import com.logic.utils.pathfinding.interfaces.IPathfinder;
import com.scenes.BatteSceneTest;

public class Main 
{
    public static void main(String[] args)
    {
        Character ardyn = new Character(0,0, Direction.NORTH, "Ardyn", "Perlegrand", "Un jeune soldat plein d'ambition", CharacterState.ALIVE, Allegiance.J1, new CharacterClass(5,0.5f,0.5f,0.5f,0.4f), new Stats(20,20,8,5,7,0,100));
        Serializer serializer = new Serializer();
        serializer.serialize(ardyn, "./localdata/saves/test/ardyn.json");
        /*Galanthe game = new Galanthe(null);
        game.setScene(new BatteSceneTest());
        game.run();*/

        /*try
        {
            /*long start = System.currentTimeMillis();
            for(int i = 0; i < 1500; i++)
            {
                smallRun();
            }
            long end = System.currentTimeMillis();
            System.out.println("Total : " + (end-start) + " AVG:" + (end-start)/1500);*/
        /*
            smallRun();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }*/
    }

    private static void run() throws Exception
    {
        PathPoint[][] map = new PathPoint[15][15];

        for (int i = 0; i < 15; i++)
        {
            for (int j = 0; j < 15; j++)
            {
                map[i][j] = new PathPoint(i,j,true);
            }
        }

        for (int k = 2; k<15; k++)
        {
            map[10][k].setWalkable(false);
        }

        for (int k = 0; k<10; k++)
        {
            map[5][k].setWalkable(false);
        }

        IPathfinder finder = new JPSFinder(map);

        long start = System.currentTimeMillis();
        Path r = finder.calculatePath(map[14][14], map[0][0], 100);
        long end = System.currentTimeMillis();
        System.out.println("Time needed : " + (end-start) + "ms");

        List<PathPoint> result = r.getList();

        for (int i = 0; i < 15; i++)
        {
            for (int j = 0; j < 15; j++)
            {
                PathPoint p = map[i][j];
                if (result.contains(p))
                {
                    System.out.printf("%3d", result.indexOf(p));
                }
                else
                {
                    if (p.isWalkable())
                    {
                        System.out.print("  O");
                    }
                    else
                    {
                        System.out.print("  X");
                    }
                }
            }

            System.out.println("");
        }
    }

    private static void smallRun() throws Exception
    {
        PathPoint[][] map = new PathPoint[5][5];

        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                map[i][j] = new PathPoint(i,j,true);
            }
        }

        map[2][0].setWalkable(false);
        map[2][1].setWalkable(false);
        map[2][2].setWalkable(false);
        map[2][3].setWalkable(false);

        IPathfinder finder = new JPSFinder(map);

        long start = System.currentTimeMillis();
        Path r = finder.calculatePath(map[4][0], map[0][0], 100);
        long end = System.currentTimeMillis();
        System.out.println("Time needed : " + (end-start) + "ms");
    }
}
