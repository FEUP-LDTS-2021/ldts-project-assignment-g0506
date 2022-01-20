package Game;

import Controls.PlayerController;
import Position.Position;
import ReadFile.ReadFile;
import gui.GUI;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private GUI gui;
    private Map map;
    private PlayerController player;
    private ReadFile file;
    boolean state;

    public Game(GUI gui) throws URISyntaxException, IOException, FontFormatException {
        Player p = new Player(new Position(5, 5));
        this.gui = gui;
        map = new Map(gui, p, "Stage1.txt", this);
        this.state = true;
        player = new PlayerController(p);
    }

    private void draw(long time) throws IOException {
        gui.clear();
        map.draw(time);
        gui.refresh();
    }

    public void run() throws IOException, URISyntaxException, FontFormatException {
        int FPS = 30;
        int frameTime = 1000 / FPS;

        while (state) {
            long startTime = System.currentTimeMillis();

            draw(startTime);
            processKey(gui.getKeyCommand());


            if (player.heroOnGate(map.getGates()) != 0) {

                nextStage(player.heroOnGate(map.getGates()) + 1);
            }
            //if(player.getHp() <= 0) state = false;
            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

        }
       // gui.close();
    }


    public void menuPause(){
        //POR FAZER
    }

    private void processKey(GUI.ACTION action) {
        map.setMonsters(player.processKey(action, map.getMonsters(), map.getWalls()));
    }

    public void nextStage(int nextStageNumber) throws URISyntaxException, IOException, FontFormatException {
        String stage = "Stage" + nextStageNumber + ".txt";
        System.out.println(nextStageNumber);
        setMap(gui, player.getPlayer(), stage);
    }

    public void setMap(GUI gui, Player player, String stage) throws URISyntaxException, IOException, FontFormatException {
        map = new Map(gui, player, stage, this);
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}

