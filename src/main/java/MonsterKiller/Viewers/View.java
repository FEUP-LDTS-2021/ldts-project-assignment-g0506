package MonsterKiller.Viewers;

import MonsterKiller.gui.GUI;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


public abstract class View {
    private List<String> menuOptions;
    private final TextGraphics textGraphics;

    public View(GUI gui) throws URISyntaxException, IOException, FontFormatException {
        this.textGraphics = gui.createTextGraphics();
    }

    public abstract void draw(GUI gui) throws IOException;

}
