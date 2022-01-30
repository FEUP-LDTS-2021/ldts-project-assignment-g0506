package MonsterKiller;

import MonsterKiller.Game.Weapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeaponTest {
    Weapon w1 = new Weapon(1, 50);
    Weapon w2 = new Weapon(2, 40);

    @Test
    public void weaponType(){
        assertEquals(1, w1.getType());
        assertEquals(2, w2.getType());
    }

    @Test
    public void weaponPower(){
        assertEquals(50, w1.getBoost());
        assertEquals(40, w2.getBoost());
    }
}
