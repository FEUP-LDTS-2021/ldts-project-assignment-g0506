package MonsterKiller.Viewers;

import com.googlecode.lanterna.graphics.TextGraphics;
import MonsterKiller.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public abstract class View {

    private final TextGraphics textGraphics;

    public View(GUI gui) throws URISyntaxException, IOException, FontFormatException {
        this.textGraphics = gui.createTextGraphics();
    }

    public abstract void draw(GUI gui) throws IOException;


}
