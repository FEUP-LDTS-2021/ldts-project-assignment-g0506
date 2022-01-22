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
import java.util.Arrays;
import java.util.List;

public class ViewMenu extends View {
    final List<String> menuOptions = Arrays.asList("NEW GAME", "RESUME GAME", "INSTRUCTIONS","EXIT");
    public ViewMenu(GUI gui) throws URISyntaxException, IOException, FontFormatException {
        super(gui);
    }

    public void drawSelectMenu(GUI gui,int cursorY) throws IOException {
        draw(gui);
        Position position = new Position(13,6);
        for(String options: menuOptions){
            if(position.getY() == cursorY)
                gui.writeText(position,options,"#000000","#FFFF00");
            else{
                gui.writeText(position,options,"#000000","#FFFFFF");
            }
            position.setY(position.getY()+2);
        }
        gui.refresh();
    }

    @Override
    public void draw(GUI gui) throws IOException {

        gui.fillBackground(gui.createTextGraphics(), "#000000",new Position(0,0));
        /*
        gui.writeText(new Position(10,4),"MAIN MENU","#000000","#FFFFFF");
        gui.writeText(new Position(7,6),"NEW GAME","#000000","#FFFFFF");
        gui.writeText(new Position(7,8),"RESUME GAME","#000000","#FFFFFF");
        gui.writeText(new Position(7,10),"TUTORIAL","#000000","#FFFFFF");
        gui.writeText(new Position(7,12),"QUIT GAME","#000000","#FFFFFF");
        //gui.refresh();

         */
    }

}
