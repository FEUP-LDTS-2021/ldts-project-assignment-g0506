import Game.Game;
import Viewers.PauseMenu;
import Viewers.SMenu;
import gui.GUI;
import gui.Lanterna;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Controller {
    Menu menu;
    Game game;
    SMenu sMenu;
    private final GUI gui;
    public Controller() throws IOException, URISyntaxException, FontFormatException {
        gui = new Lanterna();
        menu = new Menu(gui);
        sMenu = new SMenu(gui);
    }

    void run() throws IOException, URISyntaxException, FontFormatException {
        boolean stateControl = true;

            while(stateControl){
            switch (menu.selectOption()) {

                case 6:
                    game = new Game(gui);
                    game.run();
                    break;
                case 8:
                    switch(sMenu.selectOption()){
                        case 6:
                            break;
                        case 8:
                            break;
                        case 10:
                            break;
                        case 0:
                            System.out.println("bbbbb");

                            sMenu.draw();
                            break;
                    }
                    break;
                case 10:
                    //Por fazer

                case 0:
                    stateControl = false;
                    gui.close();
            }
        }}
    }
