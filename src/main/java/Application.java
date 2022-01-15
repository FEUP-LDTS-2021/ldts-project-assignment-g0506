import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    private static ViewMenu view;

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        Controller controller =  new Controller();
        controller.run();
        //view = new ViewMtest();
        //view.drawSelectMenu(6);
    }
}
