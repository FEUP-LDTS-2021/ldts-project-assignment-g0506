import Position.Position;
import Viewers.View;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import gui.GUI;
import gui.Lanterna;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class ViewMtest extends View {

    public ViewMtest() throws URISyntaxException, IOException, FontFormatException {

    }

    public void drawSelectMenu(int cursorY) throws IOException {
        draw();
        drawSelect(new Position(6,cursorY),">","#FFFFFF");
        gui.refresh();
    }

    @Override
    public void draw() throws IOException {

        gui.fillBackground(gui.createTextGraphics(), "#336699");
        drawText(new Position(7,4),"MAIN MENU","#336699","#000000");
        drawText(new Position(7,6),"NEW GAME","#336699","#000000");
        drawText(new Position(7,8),"RESUME GAME","#336699","#000000");
        drawText(new Position(7,10),"TUTORIAL","#336699","#000000");
        drawText(new Position(7,12),"QUIT GAME","#336699","#000000");


    }

    public GUI createLanterna() throws URISyntaxException, IOException, FontFormatException {
        return new Lanterna();
    }

    private void drawText(Position position, String text, String backColor, String textColor) {
        gui.writeText(position, text, backColor, textColor);
    }

    private void drawSelect(Position position, String symbol, String textColor){
        gui.drawSelect(position,symbol,textColor);

    }


}
