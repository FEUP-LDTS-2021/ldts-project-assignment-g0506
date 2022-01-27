import Controls.PlayerController;
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
    Player p = new Player(position);
    GUI gui=new Lanterna();

    String stage;
    Game game;
    ReadFile file=new ReadFile("Stage1.txt");
    Map map = new Map(gui,p,"Stage1.txt",game);
    PlayerController player = new PlayerController(p, map);
    public MapTest() throws URISyntaxException, IOException, FontFormatException {
    }
    @Test
    void HeroOnGate(){
        long time = 400; //LEMBRAR DE ANALISAR ISSO, ESTOU TESTANDO
        assertEquals(0,player.heroOnGate());
        player.processKey(GUI.ACTION.UP,time);
        assertNotEquals(0,player.heroOnGate());
    }

}
