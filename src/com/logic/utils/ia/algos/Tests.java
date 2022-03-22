package com.logic.utils.ia.algos;

import com.logic.dto.data.*;
import com.logic.dto.data.Character;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Tests
{
    @Test
    public void test()
    {
        Weapon weapon1 = new Weapon(5, false, "des", WeaponType.SWORD, ElementType.AIR);
        Weapon weapon2 = new Weapon(10, true, "des", WeaponType.SWORD, ElementType.AIR);

        CharacterClass cc = new CharacterClass(5, 0.5f, 0.5f, 0.5f);
        Character c = new Character(5, 5, Direction.NORTH);
        c.setAllegiance(Allegiance.J1);
        c.setCharacterClass(cc);
        c.setWeapon(weapon1);

        Character cPrime = new Character(6, 4, Direction.NORTH);
        cPrime.setAllegiance(Allegiance.J2);
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

        assert(AttackProcessor.canAttack(c, w) == false);
        assert(AttackProcessor.canAttack(cPrime, w));
    }
}
