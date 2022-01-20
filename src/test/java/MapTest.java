import Game.Game;
import Game.Map;
import Game.Player;
import Position.Position;
import ReadFile.ReadFile;
import gui.GUI;
import gui.Lanterna;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MapTest {
    Position position=new Position(20,29);
    Player player=new Player(position);
    GUI gui=new Lanterna();

    String stage;
    Game game;
    ReadFile file=new ReadFile("Stage1.txt");
    Map map= new Map(gui,player,"Stage1.txt",game);
    public MapTest() throws URISyntaxException, IOException, FontFormatException {
    }
    @Test
    void HeroOnGate(){
        assertEquals(0,map.heroOnGate());
        map.processKey(GUI.ACTION.UP);
        assertNotEquals(0,map.heroOnGate());
    }

}
