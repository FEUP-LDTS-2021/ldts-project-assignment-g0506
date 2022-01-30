package MonsterKiller;

import MonsterKiller.Controller.Controller;
import MonsterKiller.Viewers.ViewMenu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    private static ViewMenu view;

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        Controller controller =  new Controller();
        controller.run();
    }
}
