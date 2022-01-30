import Game.Monster;
import Position.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MonsterTest {
    Position PlayerPosition=new Position(5,5);
    Monster monster=new Monster(1,2,1);
    Monster monster2=new Monster(1,6,5);
    @Test
    public void ChangeMonsterPosition(){
        assertEquals(2,monster.getX());
        assertEquals(1,monster.getY());
        monster.changePosition(PlayerPosition);
        assertEquals(3,monster.getX());
        assertEquals(2,monster.getY());
        PlayerPosition.setX(4);
        PlayerPosition.setY(4);
        monster.changePosition(PlayerPosition);
        assertEquals(4,monster.getX());
        assertEquals(3,monster.getY());
    }

    @Test
    public void RandomMonsterPosition(){
        assertEquals(2,monster.getX());
        assertEquals(1,monster.getY());
        monster.randomPosition(); //x or y may be the same afterwards but one of them will have changed
        if (monster.getX()==2){
            assertNotEquals(1,monster.getY());
        }
        else if (monster.getY()==1){
            assertNotEquals(2,monster.getX());
        }
        else{
            assertNotEquals(2,monster.getX());
            assertNotEquals(1,monster.getY());
        }

    }

    @Test
    public void MonsterKnockback(){
        assertEquals(6,monster2.getX());
        assertEquals(5,monster2.getY());
        monster2.monsterKnockback(PlayerPosition);
        assertEquals(7,monster2.getX());
        assertEquals(5,monster2.getY());

    }
}
