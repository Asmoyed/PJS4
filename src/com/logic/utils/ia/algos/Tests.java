package com.logic.utils.ia.algos;

import com.logic.dto.data.*;
import com.logic.dto.data.Character;
import com.logic.dto.serialization.ObjectNotSerializableException;
import com.logic.dto.serialization.ObjectParsingException;
import com.logic.dto.serialization.Serializer;
import com.logic.utils.ia.dto.Move;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Tests
{
    @Test
    public void test()
    {
        World w = newWorld();
        World result = BotPlayer.play(w);

        if (result == null)
        {
            System.out.println("Aucun mouvement possible");
        }
        else
        {
            for (Character c : w.getCharacters())
            {
                System.out.println(c.getX() + "/" + c.getY());
            }
            System.out.println("//");
            for (Character c : result.getCharacters())
            {
                System.out.println(c.getX() + "/" + c.getY());
            }
        }
    }

    @Test
    public void test2() throws ObjectParsingException, ObjectNotSerializableException
    {
        World w = newWorld();
        World copy = w.copy();

        w.getCharacters().get(0).setY(10);

        for (Character c : copy.getCharacters())
        {
            System.out.println(c.getX() + "/" + c.getY());
        }
        System.out.println("fin copie");

        for (Character c : w.getCharacters())
        {
            System.out.println(c.getX() + "/" + c.getY());
        }
    }

    private World newWorld()
    {
        Weapon weapon1 = new Weapon(5, true, "des", WeaponType.SWORD, ElementType.AIR);
        Weapon weapon2 = new Weapon(10, true, "des", WeaponType.SWORD, ElementType.AIR);

        CharacterClass cc = new CharacterClass(10, 0.5f, 0.5f, 0.5f);
        Character c = new Character(5, 5, Direction.NORTH);
        c.setStats(new Stats(50,50,10,5,10,10,10));
        c.setState(CharacterState.ALIVE);
        c.setAllegiance(Allegiance.BOT);
        c.setCharacterClass(cc);
        c.setWeapon(weapon1);

        Character cPrime = new Character(6, 4, Direction.NORTH);
        cPrime.setStats(new Stats(50,50,2,5,10,10,10));
        cPrime.setState(CharacterState.ALIVE);
        cPrime.setAllegiance(Allegiance.J1);
        cPrime.setCharacterClass(cc);
        cPrime.setWeapon(weapon2);

        List<Character> characters = new ArrayList<Character>();
        characters.add(c);
        characters.add(cPrime);

        Tile[][] tiles = new Tile[10][10];

        for (int i = 0; i < tiles.length; i++)
        {
            for (int j = 0; j < tiles[i].length; j++)
            {
                tiles[i][j] = new Tile(i, j, 0f, 0f, 0f, Accesibility.WALKABLE);
            }
        }

        World w = new World(tiles);
        w.setDynamicEntities(characters);
        return w;
    }
}
