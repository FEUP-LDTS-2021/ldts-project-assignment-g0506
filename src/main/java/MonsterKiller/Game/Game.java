package MonsterKiller.Game;

import MonsterKiller.Controls.PlayerController;
import MonsterKiller.Position.Position;
import MonsterKiller.ReadFile.SaveFile;
import MonsterKiller.Viewers.PMenu;
import MonsterKiller.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private GUI gui;
    private Map map;
    private PlayerController player;
    boolean state;
    private PMenu pmenu;
    private SaveFile save;

    public Game(GUI gui) throws URISyntaxException, IOException, FontFormatException {

        Player p = new Player(new Position(5, 5));
        this.gui = gui;
        map = new Map(gui, p, "Stage1.txt", this);
        this.state = true;
        player = new PlayerController(p, map);
        this.pmenu = new PMenu(gui);
    }


    public Game(GUI gui, List<String> lines) throws URISyntaxException, IOException, FontFormatException {;

        String stage = lines.get(0);
        stage = "Stage" + stage + ".txt";
        Position pos = new Position(Integer.parseInt(lines.get(1)),Integer.parseInt(lines.get(2)));
        int hp = Integer.parseInt(lines.get(3));
        int level = Integer.parseInt(lines.get(4));
        int exp = Integer.parseInt(lines.get(5));
        String []arr = lines.get(6).split(" ");
        List<Weapon> weapons = new ArrayList<>();
        for(String str : arr){
            Weapon weapon = new Weapon(Integer.parseInt(str.substring(0,1)), Integer.parseInt(str.substring(1)));
            weapons.add(weapon);
        }
        this.gui = gui;
        Player p = new Player(pos, hp, level, exp, weapons);
        this.map = new Map(gui, p, stage, this);
        this.state = true;
        player = new PlayerController(p, map);
        this.pmenu = new PMenu(gui);

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
            int exit = processKey(gui.getKeyCommand(),startTime);

            switch(exit) {
                case 1:
                    state = false;
                    break;
                case 2:
                    switch(pmenu.selectOption()){
                        case 6:
                            break;
                        case 8:
                            save = new SaveFile(Integer.toString(map.getStage()),player.getPosition(), player.getHP(), player.getLevel(), player.getEXP(), player.getWeapons());
                            save.SaveGame();
                            break;
                        case 10:
                            state = false;
                            break;
                    }
                    break;
                case 3:
                    gui.drawAttack(player.getPosition());
                    break;
                case 0:
                    break;
            }

            if (player.getPlayer().getKillReward().get(1)==5){
                Weapon weaponl= new Weapon(3,5);
                player.getPlayer().addWeapon(weaponl);
                player.getPlayer().getKillReward().set(1,6);
            }

            else if (player.getPlayer().getKillReward().get(0)==10){
                Weapon weapond= new Weapon(2,10);
                player.getPlayer().addWeapon(weapond);
                player.getPlayer().getKillReward().set(0,11);
            }


            int nextStage = player.heroOnGate();
            if (nextStage != 0) {

                nextStage(map.getStage() + nextStage);
            }

            if (!player.isAlive()){
                state=false;
            }

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;
            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }


    public int processKey(GUI.ACTION action,long time) {
        return player.processKey(action,time);
    }

    public void nextStage(int nextStageNumber) throws URISyntaxException, IOException, FontFormatException {
        String stage = "Stage" + nextStageNumber + ".txt";
        map.getWalls().clear();
        map.getGates().clear();
        setMap(gui, player.getPlayer(), stage);
    }

    public void setMap(GUI gui, Player player1, String stage) throws URISyntaxException, IOException, FontFormatException {
        map = new Map(gui, player1, stage, this);
        player.setMap(map);
    }


}

