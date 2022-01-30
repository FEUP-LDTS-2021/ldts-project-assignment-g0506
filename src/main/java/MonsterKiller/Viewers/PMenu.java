package MonsterKiller.Viewers;

import MonsterKiller.gui.GUI;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class PMenu{
    PauseMenu pauseMenu;
    private int cursorY = 6;
    GUI gui;
    public PMenu(GUI gui) throws URISyntaxException, IOException, FontFormatException {
        this.gui = gui;
        pauseMenu = new PauseMenu(gui);
    }

    public int selectOption() throws IOException{
        cursorY = 6;
        while(true){

        pauseMenu.drawSelectMenu(gui,cursorY);
        KeyStroke key = gui.getScreen().readInput();
        processKey(key);
        if(key.getKeyType() == KeyType.Enter){
            if(cursorY == 10) {
                // screen.close();
                return 10;
            }
            if(cursorY == 8){
                return 8;}

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
}



