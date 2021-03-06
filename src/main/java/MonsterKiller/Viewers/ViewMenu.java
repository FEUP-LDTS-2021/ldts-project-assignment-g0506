package MonsterKiller.Viewers;

import MonsterKiller.Position.Position;
import MonsterKiller.gui.GUI;

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

    public void drawInstructionScreen(GUI gui) throws IOException {
        draw(gui);
        gui.writeText(new Position(2,1),"AT FIRST AVOID ATTACKING b","#000000","#FFFFFF");
        gui.writeText(new Position(2,3),"TO BE STRONG, KILL MONSTERS","#000000","#FFFFFF");
        gui.writeText(new Position(2,5),"TO INCREASE YOUR LEVEL, KILL MONSTERS","#000000","#FFFFFF");
        gui.writeText(new Position(2,7),"TO BE STRONG, KILL MONSTERS","#000000","#FFFFFF");
        gui.writeText(new Position(2,9),"TO KILL MONSTERS, PRESS SPACE","#000000","#FFFFFF");
        gui.writeText(new Position(2, 11), "USE WASD TO MOVE", "#000000","#FFFFFF");
        gui.writeText(new Position(2, 13), "USE BACKSPACE TO PAUSE", "#000000","#FFFFFF");
        gui.writeText(new Position(2,17),"PRESS ENTER TO BACK","#000000","#FFFF00");
        gui.refresh();
    }

    public void drawNoSaveState(GUI gui) throws IOException{
        draw(gui);
        gui.writeText(new Position(5,9),"NO SAVE STATE AVAILABLE","#000000","#FFFFFF");
        gui.writeText(new Position(5,14),"PRESS ENTER TO BACK","#000000","#FFFF00");
        gui.refresh();
    }

    @Override
    public void draw(GUI gui){
        gui.fillBackground(gui.createTextGraphics(), "#000000",new Position(0,0));
    }

}
