package Viewers;

import Viewers.PauseMenu;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import gui.GUI;

public class PMenu{
    PauseMenu pauseMenu;
    private int cursorY = 6;
    GUI gui;
    public PMenu(GUI gui) throws URISyntaxException, IOException, FontFormatException {
        this.gui = gui;
        pauseMenu = new PauseMenu(gui);
    }

    public int selectOption() throws IOException{
        pauseMenu.drawSelectMenu(gui,cursorY);
        KeyStroke key = gui.getScreen().readInput();
        processKey(key);
        if(key.getKeyType() == KeyType.Enter){
            if(cursorY == 10) {
                // screen.close();
                return 10;
            }
        }
        return cursorY;
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
}



