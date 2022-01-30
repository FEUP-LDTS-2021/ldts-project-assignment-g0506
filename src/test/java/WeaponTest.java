import MonsterKiller.Game.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WeaponTest {
    Weapon w1 = new Weapon(1, 50);
    Weapon w2 = new Weapon(2, 40);

    @Test
    public void weaponType(){
        Assertions.assertEquals(1, w1.getType());
        Assertions.assertEquals(2, w2.getType());
    }

    @Test
    public void weaponPower(){
        Assertions.assertEquals(50, w1.getBoost());
        Assertions.assertEquals(40, w2.getBoost());
    }
}
