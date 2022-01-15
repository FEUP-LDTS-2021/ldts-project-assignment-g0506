import Game.Game;
import gui.GUI;
import gui.Lanterna;

import java.awt.*;
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


    void run() throws IOException, URISyntaxException, FontFormatException {

            switch (menu.selectOption()) {

                case 6:
                    game = new Game(gui);
                    game.run();
                    break;
                case 9:
                    //por fazer
                    break;
                case 11:
                    //Por fazer

                case 0:
                    System.exit(0);
            }
        }
    }
