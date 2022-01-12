import java.io.IOException;

public class Controller {
    Menu menu;
    Game game;
    public Controller() throws IOException {
        menu = new Menu();
       // game = new Game();
    }

    void run() throws IOException {

            switch (menu.selectOption()) {

                case 7:
                    menu.closeMenu();
                    game = new Game();
                    game.run();
                    break;
                case 9:
                    //por fazer
                    break;
                case 11:
                    menu.tutorialView();

                case 0:
                    System.exit(0);
            }
        }
    }
