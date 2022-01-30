package MonsterKiller;

import MonsterKiller.Controls.PlayerController;
import MonsterKiller.Game.Game;
import MonsterKiller.Game.Gate;
import MonsterKiller.Game.Map;
import MonsterKiller.Game.Player;
import MonsterKiller.Position.Position;
import MonsterKiller.gui.GUI;
import MonsterKiller.gui.Lanterna;
import org.junit.jupiter.api.Test;

import javax.imageio.IIOException;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GateTest {
    Gate g1 = new Gate(new Position(1,3), '+');
    Gate g2 = new Gate(new Position(2,5), '+');

    @Test
    public void posTest(){
        assertEquals(1, g1.getPosition().getX());
        assertEquals(3, g1.getPosition().getY());
        assertEquals(2, g2.getPosition().getX());
        assertEquals(5, g2.getPosition().getY());
    }

    @Test
    public void playerOnGateTest() throws IOException, FontFormatException, URISyntaxException {
        long startTime = System.currentTimeMillis();
        GUI gui = new Lanterna();
        Game game = new Game(gui);
        Player player = new Player(new Position(22,2));
        Map map = new Map(gui, player, "Stage1.txt", game);
        PlayerController p = new PlayerController(player, map);
        assertEquals(0, p.heroOnGate());
        p.processKey(GUI.ACTION.UP, startTime);
        assertEquals(1, p.heroOnGate());
    }
}
