import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.menu.MenuBar;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;


public class Menu {
    private Screen screen;
    private int cursorY = 7;

    public Menu(){

        try {
            URL resource = getClass().getClassLoader().getResource("square.ttf");
            File fontFile = new File(resource.toURI());
            Font font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);

            DefaultTerminalFactory factory = new DefaultTerminalFactory();

            Font loadedFont = font.deriveFont(2,35);
            AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
            factory.setTerminalEmulatorFontConfiguration(fontConfig);
            factory.setForceAWTOverSwing(true);
            factory.setInitialTerminalSize(new TerminalSize(27,18 ));
            Terminal terminal = factory.createTerminal();

            screen = new TerminalScreen(terminal);
            screen.startScreen();
            screen.doResizeIfNecessary();
            screen.setCursorPosition(null);
        }
        catch (IOException | URISyntaxException | FontFormatException e) {
            e.printStackTrace();
        }
}

    void drawMenu() throws IOException{

        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        tg.fillRectangle(new TerminalPosition(0,0),tg.getSize(),' ');

        tg.setForegroundColor(TextColor.Factory.fromString("#5DD67E"));
        tg.putString(7,cursorY,">",SGR.BLINK);
        tg.putString(9,2,"MAIN MENU");
        tg.putString(8,7,"NEW GAME");
        tg.putString(8,9,"RESUME GAME");
        tg.putString(8,11,"TUTORIAL");
        tg.putString(8,13,"EXIT");

        screen.refresh();
    }

    int selectOption() throws IOException{

        while(true){
            drawMenu();
            KeyStroke key = screen.readInput();
            processKey(key);

            if(key.getKeyType() == KeyType.Enter){
                if(cursorY == 13) {
                    screen.close();
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

    void closeMenu() throws IOException {
        screen.close();
    }
    }

