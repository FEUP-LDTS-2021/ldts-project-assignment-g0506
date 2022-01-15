import Viewers.ViewMenu;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import gui.GUI;


public class Menu {
    ViewMenu viewMenu;
    private int cursorY = 6;
    GUI gui;
    public Menu(GUI gui) throws URISyntaxException, IOException, FontFormatException {
        this.gui = gui;
        viewMenu = new ViewMenu(gui);

}

    int selectOption() throws IOException{

        while(true){
            viewMenu.drawSelectMenu(gui,cursorY);
            KeyStroke key = gui.getScreen().readInput();
            processKey(key);

            if(key.getKeyType() == KeyType.Enter){
                if(cursorY == 13) {
                   // screen.close();
                    return 0;
                }

                return cursorY;
            }
        }
    }


    private void processKey(KeyStroke key) {

        if(key.getKeyType() == KeyType.ArrowUp){
            if(cursorY == 6)
                cursorY = 12;
            else if(cursorY != 7){
                cursorY -= 2;}
        }

        else if(key.getKeyType() == KeyType.ArrowDown){
            if(cursorY == 12)
                cursorY = 6;
            else if(cursorY != 13){
                cursorY += 2;}
        }
    }
}



