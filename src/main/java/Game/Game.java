package Game;

import Position.Position;
import ReadFile.ReadFile;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import gui.GUI;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
    private GUI gui;
    private Map map;
    private Player player;
    private ReadFile file;

    public Game(GUI gui) throws URISyntaxException, IOException, FontFormatException {
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
        Timer drawTimer = new Timer();
        Timer playerTimer = new Timer();
        Timer monsterTimer = new Timer();
        monsterTimer.scheduleAtFixedRate(map, 0, 1000);
        TimerTask draw_task = new TimerTask() {
            @Override
            public void run() {
                try {
                    draw();
                }
                catch (IOException e){
                    System.out.println(e);
                }
            }
        };
        TimerTask movePlayerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    KeyStroke key = gui.getScreen().readInput();
                    processKey(key);
                }
                catch (IOException e){
                    System.out.println(e);
                }
            }
        };
        playerTimer.scheduleAtFixedRate(movePlayerTask, 0, 5000/player.getSpeed());
        drawTimer.scheduleAtFixedRate(draw_task, 0, 100);
        while(true) {
            /*if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
                gui.close();
            if(key.getKeyType() == KeyType.EOF)
                break;*/
            if(map.heroOnGate() != 0){
                nextStage(map.heroOnGate()+1);
            }
        }
    }

    private void processKey(KeyStroke key)
    {
        map.processKey(key);
    }

    public void nextStage(int nextStageNumber) throws URISyntaxException, IOException, FontFormatException {
        player.setY(23); //so para teste
        String stage = "Stage" + nextStageNumber + ".txt";
        System.out.println(nextStageNumber);
        setMap(gui,player,stage);
    }

    public void setMap(GUI gui, Player player, String stage) throws URISyntaxException, IOException, FontFormatException {
        map = new Map(gui,player,stage);
    }
}


