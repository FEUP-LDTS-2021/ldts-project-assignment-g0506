package Viewers;

import Position.Position;
import Viewers.View;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import gui.GUI;
import gui.Lanterna;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class ViewMenu extends View {

    public ViewMenu(GUI gui) throws URISyntaxException, IOException, FontFormatException {
        super(gui);
    }

    public void drawSelectMenu(GUI gui,int cursorY) throws IOException {
        draw(gui);
        gui.drawSelect(new Position(6,cursorY),">","#FFFFFF");
        gui.refresh();
    }

    @Override
    public void draw(GUI gui) throws IOException {

        gui.fillBackground(gui.createTextGraphics(), "#336699");
        gui.writeText(new Position(7,4),"MAIN MENU","#336699","#000000");
        gui.writeText(new Position(7,6),"NEW GAME","#336699","#000000");
        gui.writeText(new Position(7,8),"RESUME GAME","#336699","#000000");
        gui.writeText(new Position(7,10),"TUTORIAL","#336699","#000000");
        gui.writeText(new Position(7,12),"QUIT GAME","#336699","#000000");
        gui.refresh();
    }

}
