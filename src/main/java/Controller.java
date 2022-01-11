import java.io.IOException;

public class Controller {
    Menu menu = new Menu();
    Game game = new Game();
    public Controller() throws IOException {

    }

    void run() throws IOException {


        switch(menu.selectOption()){
            case 7:
                menu.closeMenu();
                game.run();
                break;
            case 9:
                //por fazer
            case 11:
                //por fazer
            case 0:
                System.exit(0);
        }

    }
}
