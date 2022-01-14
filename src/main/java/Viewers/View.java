package Viewers;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import gui.GUI;
import gui.Lanterna;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public abstract class View {
    protected final GUI gui;
    private final TextGraphics textGraphics;

    public View() throws URISyntaxException, IOException, FontFormatException {
        this.gui = createLanterna();
        this.textGraphics = gui.createTextGraphics();
    }

    public Screen getScreen(){
        return gui.getScreen();
    }

    public abstract void draw() throws IOException;

    public abstract GUI createLanterna() throws URISyntaxException, IOException, FontFormatException;
}
