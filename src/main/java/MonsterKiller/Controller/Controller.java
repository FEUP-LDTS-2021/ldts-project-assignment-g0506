package MonsterKiller.Controller;

import MonsterKiller.Game.Game;
import MonsterKiller.ReadFile.ReadFile;
import MonsterKiller.Viewers.Menu;
import MonsterKiller.gui.GUI;
import MonsterKiller.gui.Lanterna;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class Controller {
    Menu menu;
    Game game;

    private final GUI gui;
    public Controller() throws IOException, URISyntaxException, FontFormatException {
        gui = new Lanterna();
        menu = new Menu(gui);

    }

    public void run() throws IOException, URISyntaxException, FontFormatException {
        boolean stateControl = true;

        while(stateControl){
            switch (menu.selectOption()) {

                case 6:
                    game = new Game(gui);
                    game.run();
                    break;
                case 8:
                    try {
                        ReadFile rFile = new ReadFile();
                        game = new Game(gui, rFile.getResume_line());
                        game.run();
                    }catch(FileNotFoundException e) {
                        menu.noSaveStateScreen();
                    }
                    break;
                case 10:
                    menu.instructionsMenu();
                    break;
                case 0:
                    stateControl = false;
                    gui.close();
            }
        }}
}
