import Position.Position;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    GUI gui;
    Map map;
    private Player player;

    private ReadFile file;

    Game(GUI gui) throws URISyntaxException, IOException, FontFormatException {
        player = new Player(new Position(5,5));
        this.gui = gui;
        map = new Map(gui, player,"Stage1.txt");

    }

    private void draw() throws IOException{
        gui.clear();
        map.draw();
        gui.refresh();
    }

    public void run() throws IOException, URISyntaxException, FontFormatException {
        while(true) {
            draw();
            KeyStroke key = gui.getScreen().readInput();
            processKey(key);
            if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
                gui.close();
            if(key.getKeyType() == KeyType.EOF)
                break;
            moveMonsters();
            if(map.heroOnGate() != 0){
                nextStage(map.heroOnGate()+1);
            }
        }
    }

    private void processKey(KeyStroke key)
    {
        map.processKey(key);
    }

    private void moveMonsters(){
        map.moveMonsters();
    }

    public void nextStage(int nextStageNumber) throws URISyntaxException, IOException, FontFormatException {
        String stage = "Stage" + nextStageNumber + ".txt";
        setMap(gui,player,stage);
    }

    public void setMap(GUI gui, Player player,String stage) throws URISyntaxException, IOException, FontFormatException {
        map = new Map(gui,player,stage);
    }
}


