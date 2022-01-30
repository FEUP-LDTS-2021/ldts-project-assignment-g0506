import MonsterKiller.Game.Monster;
import MonsterKiller.Position.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MonsterTest {
    Position PlayerPosition=new Position(5,5);
    Monster monster=new Monster(1,2,1);
    Monster monster2=new Monster(1,6,5);
    @Test
    public void ChangeMonsterPosition(){
        Assertions.assertEquals(2,monster.getX());
        Assertions.assertEquals(1,monster.getY());
        monster.changePosition(PlayerPosition);
        Assertions.assertEquals(3,monster.getX());
        Assertions.assertEquals(2,monster.getY());
        PlayerPosition.setX(4);
        PlayerPosition.setY(4);
        monster.changePosition(PlayerPosition);
        Assertions.assertEquals(4,monster.getX());
        Assertions.assertEquals(3,monster.getY());
    }

    @Test
    public void RandomMonsterPosition(){
        Assertions.assertEquals(2,monster.getX());
        Assertions.assertEquals(1,monster.getY());
        monster.randomPosition(); //x or y may be the same afterwards but one of them will have changed
        if (monster.getX()==2){
            Assertions.assertNotEquals(1,monster.getY());
        }
        else if (monster.getY()==1){
            Assertions.assertNotEquals(2,monster.getX());
        }
        else{
            Assertions.assertNotEquals(2,monster.getX());
            Assertions.assertNotEquals(1,monster.getY());
        }

    }

    @Test
    public void MonsterKnockback(){
        Assertions.assertEquals(6,monster2.getX());
        Assertions.assertEquals(5,monster2.getY());
        monster2.monsterKnockback(PlayerPosition);
        Assertions.assertEquals(7,monster2.getX());
        Assertions.assertEquals(5,monster2.getY());

    }
}
