import Game.Monster;
import Game.Player;
import Position.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    Position position1 = new Position(1,1);
    Player player1=new Player(position1);
    @Test
    public void PlayerHPBar(){
        String healthPercent=player1.healthCount();
        assertEquals("100%",healthPercent);
    }

    @Test
    public void PlayerKillsMonster(){
        assertEquals(1,player1.getLevel());
        Monster monster1=new Monster(1,3,3);
        player1.monsterKill(monster1);
        assertEquals(2,player1.getLevel());
    }

    @Test
    public void PlayerPosition(){
        assertEquals(position1.getX(),player1.getPosition().getX());
        assertEquals(position1.getY(),player1.getPosition().getY());
        player1.setPosition(player1.moveDown());
        player1.setPosition(player1.moveUp());
        player1.setPosition(player1.moveRight());
        Position position2= new Position(2,1);
        assertEquals(position2.getX(),player1.getPosition().getX());
        assertEquals(position2.getY(),player1.getPosition().getY());

    }
    
}
