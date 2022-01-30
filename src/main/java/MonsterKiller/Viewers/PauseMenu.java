package MonsterKiller.Viewers;

import MonsterKiller.Position.Position;
import MonsterKiller.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class PauseMenu extends View {
    final List<String> menuOptions = Arrays.asList("RESUME GAME", "SAVE GAME", "QUIT TO MAIN MENU");
    public PauseMenu(GUI gui) throws URISyntaxException, IOException, FontFormatException {
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
        gui.fillBackground(gui.createTextGraphics(), "#000000", new Position(0, 0));
    }
}
