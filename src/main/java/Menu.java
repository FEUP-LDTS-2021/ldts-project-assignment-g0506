import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;


public class Menu {
    ViewMtest view;
    private int cursorY = 6;
    public Menu() throws URISyntaxException, IOException, FontFormatException {
        view = new ViewMtest();
        //a tentar implementar em outro sitio

}

    int selectOption() throws IOException{

        while(true){
            view.drawSelectMenu(cursorY);
            //draw(cursorY);
            KeyStroke key = view.getScreen().readInput();
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
            if(cursorY == 7)
                cursorY = 13;
            else if(cursorY != 7){
                cursorY -= 2;}
        }

        else if(key.getKeyType() == KeyType.ArrowDown){
            if(cursorY == 13)
                cursorY = 7;
            else if(cursorY != 13){
                cursorY += 2;}
        }
    }
}



