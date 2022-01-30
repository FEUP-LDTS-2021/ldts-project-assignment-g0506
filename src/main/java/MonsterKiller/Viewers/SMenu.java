package MonsterKiller.Viewers;

import MonsterKiller.Position.Position;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import MonsterKiller.gui.GUI;

public class SMenu{
    SaveMenu saveMenu;
    int saves_nr;
    private int cursorY = 6;
    GUI gui;
    public SMenu(GUI gui) throws URISyntaxException, IOException, FontFormatException {
        this.gui = gui;
        saveMenu = new SaveMenu(gui);
        saves_nr = saveMenu.getSaves();
    }


    public int selectOption() throws IOException{
        if(saves_nr == 0) {
            //draw();
            return 0;
        }
        while(true){
            saveMenu.drawSelectMenu(gui,cursorY);
            KeyStroke key = gui.getScreen().readInput();
            processKey(key);

            if(key.getKeyType() == KeyType.Enter){
                if(cursorY == 10) {
                    // screen.close();
                    return 10;
                }

                return cursorY;
            }
        }
    }


    private void processKey(KeyStroke key) {
        if(key.getKeyType()==KeyType.ArrowUp){
            if(cursorY==6)
                cursorY = 10;
            else if(cursorY!=6)
                cursorY -= 2;
        }
        else if(key.getKeyType()==KeyType.ArrowDown){
            if(cursorY==10)
                cursorY = 6;
            else if(cursorY!=10)
                cursorY += 2;
        }
    }

    public void draw() throws IOException{
        gui.clear();
        gui.writeText(new Position(3,6), "THERE ARE NO SAVE STATES AVAILABLE", "#000000","#FFFF00");
        gui.writeText(new Position(6, 7), "(PRESS ENTER TO CONTINUE)", "#000000","#FFFF00");
        gui.refresh();
        KeyStroke key = gui.getScreen().readInput();
        while(key.getKeyType()!= KeyType.Enter){
            key =gui.getScreen().readInput();
        }
    }
}


