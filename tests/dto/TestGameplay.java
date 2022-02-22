package dto;

import com.logic.dto.data.*;
import com.logic.dto.data.Character;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGameplay {

    @Test
    public void testDamageWithoutWeaponDamage() {
        CharacterClass charaClass = new CharacterClass();
        Stats stats = new Stats(10, 10, 7, 5, 0, 0, 0);
        Weapon wpNoDmg = new Weapon(0, false, "arme",WeaponType.SWORD, ElementType.LIGHTNING);
        Character c = new Character(0, 0, Direction.SOUTH, "nom", "secondNom", "description", CharacterState.ALIVE, Allegiance.J1, wpNoDmg, charaClass, stats);

        assertEquals(10, c.getStats().getHealth());

        c.attack(c);
        assertEquals(2, c.damageValue(c));
        assertEquals(8, c.getStats().getHealth());


    }

    @Test
    public void testDamageWithWeaponDamage() {
        CharacterClass charaClass = new CharacterClass();
        Stats stats = new Stats(10, 10, 1, 0, 0, 0, 0);
        Weapon wp = new Weapon(2, false, "arme",WeaponType.SWORD, ElementType.LIGHTNING);
        Character c = new Character(0, 0, Direction.SOUTH, "nom", "secondNom", "description", CharacterState.ALIVE, Allegiance.J1, wp, charaClass, stats);

        assertEquals(10, c.getStats().getHealth());

        c.attack(c);
        assertEquals(3, c.damageValue(c));
        assertEquals(7, c.getStats().getHealth());
    }

    @Test
    public void testDamageWithWeaponAdvantage() {
        CharacterClass charaClass = new CharacterClass();
        Stats stats = new Stats(10, 10, 2, 1, 1, 1, 10);
        Weapon wpS = new Weapon(2, false, "arme", WeaponType.SWORD, ElementType.LIGHTNING);
        Weapon wpA = new Weapon(2, false, "arme", WeaponType.AXE, ElementType.LIGHTNING);
        Character cS = new Character(0, 0, Direction.SOUTH, "nom", "secondNom", "description", CharacterState.ALIVE, Allegiance.J1, wpS, charaClass, stats);
        Character cA = new Character(0, 0, Direction.SOUTH, "nom", "secondNom", "description", CharacterState.ALIVE, Allegiance.J1, wpA, charaClass, stats);
        assertEquals(10, cS.getStats().getHealth());
        cS.attack(cA);
        assertEquals(3, cS.damageValue(cA));
    }


    @Test
    public void testDamageWithElement() {


    }

    @Test
    public void testHeal() {
        CharacterClass charaClass = new CharacterClass();
        Stats stats = new Stats(10, 10, 7, 5, 0, 0, 0);
        Weapon wpNoDmg = new Weapon(1, false, "arme",WeaponType.SWORD, ElementType.LIGHTNING);
        Character c = new Character(0, 0, Direction.SOUTH, "nom", "secondNom", "description", CharacterState.ALIVE, Allegiance.J1, wpNoDmg, charaClass, stats);

        assertEquals(10, c.getStats().getHealth());

        c.attack(c);
        assertEquals(3, c.damageValue(c));
        assertEquals(8, c.getStats().getHealth());

        c.heal(c);
        assertEquals(9, c.getStats().getHealth());

    }
}
