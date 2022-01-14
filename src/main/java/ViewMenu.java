import Viewers.View;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import gui.GUI;
import gui.Lanterna;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ViewMenu{
    Screen screen;
    //private int cursorY ;

/*
    @Override
    public GUI createLanterna(Screen screen) {
        return new Lanterna(screen);
    }
*/

    ViewMenu(){

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

    public void draw(int x) throws IOException {

        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        tg.fillRectangle(new TerminalPosition(0,0),tg.getSize(),' ');

        tg.setForegroundColor(TextColor.Factory.fromString("#5DD67E"));
        tg.putString(7,x,">", SGR.BLINK);
        tg.putString(9,2,"MAIN MENU");
        tg.putString(8,7,"NEW GAME");
        tg.putString(8,9,"RESUME GAME");
        tg.putString(8,11,"TUTORIAL");
        tg.putString(8,13,"EXIT");
        screen.refresh();

    }

    void tutorialView() throws IOException {

        while(true) {
            TextGraphics tg = screen.newTextGraphics();
            tg.setBackgroundColor(TextColor.Factory.fromString("#336699"));
            tg.fillRectangle(new TerminalPosition(0, 0), tg.getSize(), ' ');
            tg.setForegroundColor(TextColor.Factory.fromString("#5DD67E"));
            screen.refresh();
        }
    }

    void closeMenu() throws IOException {
        screen.close();
    }
}

