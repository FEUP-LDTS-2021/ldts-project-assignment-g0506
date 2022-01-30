import MonsterKiller.Game.Monster;
import MonsterKiller.Game.Player;
import MonsterKiller.Position.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    Position position1 = new Position(1,1);
    Player player1=new Player(position1);
    @Test
    public void PlayerHPBar(){
        String healthPercent=player1.healthCount();
        Assertions.assertEquals("100%",healthPercent);
        player1.setHp(player1.getHp()-12);
        Assertions.assertEquals("20%",player1.healthCount());
    }

    @Test
    public void PlayerKillsMonster(){
        Assertions.assertEquals(1,player1.getLevel());
        Monster monster1=new Monster(1,3,3);
        player1.monsterKill(monster1);
        Assertions.assertEquals(2,player1.getLevel());
    }

    @Test
    public void PlayerPosition(){
        Assertions.assertEquals(position1.getX(),player1.getPosition().getX());
        Assertions.assertEquals(position1.getY(),player1.getPosition().getY());
        player1.setPosition(player1.moveDown());
        player1.setPosition(player1.moveUp());
        player1.setPosition(player1.moveRight());
        Position position2= new Position(2,1);
        Assertions.assertEquals(position2.getX(),player1.getPosition().getX());
        Assertions.assertEquals(position2.getY(),player1.getPosition().getY());

    }
    
}
