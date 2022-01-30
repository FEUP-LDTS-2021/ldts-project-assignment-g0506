package MonsterKiller;

import MonsterKiller.Game.Gate;
import MonsterKiller.Position.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GateTest {
    @Test
    void GateTest(){
        Gate gate1 = new Gate(new Position(3,30),'e');
        assertEquals(-3,gate1.getLoad());

        Gate gate2 = new Gate(new Position(3,0),'e');
        assertEquals(3,gate2.getLoad());

    }


}
