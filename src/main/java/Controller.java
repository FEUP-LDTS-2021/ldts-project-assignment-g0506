import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Controller {
    Menu menu;
    Game game;
    public Controller() throws IOException, URISyntaxException, FontFormatException {
         menu = new Menu();
        // game = new Game();
    }


    void run() throws IOException {

            switch (menu.selectOption()) {

                case 6:

                    game = new Game();
                    game.run();
                    break;
                case 9:
                    //por fazer
                    break;
                case 11:


                case 0:
                    System.exit(0);
            }
        }
    }
