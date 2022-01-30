import MonsterKiller.Controls.PlayerController;
import MonsterKiller.Game.Game;
import MonsterKiller.Game.Gate;
import MonsterKiller.Game.Map;
import MonsterKiller.Game.Player;
import MonsterKiller.Position.Position;
import MonsterKiller.gui.GUI;
import MonsterKiller.gui.Lanterna;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GateTest {
    Gate g1 = new Gate(new Position(1,3), '+');
    Gate g2 = new Gate(new Position(2,5), '+');

    @Test
    public void posTest(){
        Assertions.assertEquals(1, g1.getPosition().getX());
        Assertions.assertEquals(3, g1.getPosition().getY());
        Assertions.assertEquals(2, g2.getPosition().getX());
        Assertions.assertEquals(5, g2.getPosition().getY());
    }


}
