import Position.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    @Test
    void PlayerTest(){
        Position position1 = new Position(1,1);
        Player player1=new Player(position1);
        assertEquals(1,player1.getLevel());
        Monster monster1=new Monster(1,3,3);
        player1.monsterKill(monster1);
        assertEquals(2,player1.getLevel());
    }
    
}
