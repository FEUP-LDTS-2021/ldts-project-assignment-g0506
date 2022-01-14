package gui;

import Position.Position;
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
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Lanterna implements GUI {

    private int width = 30;
    private int height = 30;
    Screen screen;

    public Lanterna() throws URISyntaxException, IOException, FontFormatException {

        AWTTerminalFontConfiguration fontCfg = loadFont("square.ttf");

        Terminal terminal = newTerminal(width, height, fontCfg);
        screen = newScreen(terminal);


        /*
        AWTTerminalFontConfiguration fontConfig = loadOverkillFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
        addCloseScreenListener();
        this.height=height;
        this.width=width;
         */
    }


    public AWTTerminalFontConfiguration loadFont(String nameFont) throws URISyntaxException, IOException, FontFormatException {
        URL resource = getClass().getClassLoader().getResource(nameFont);
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(2, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);

        return fontConfig;

    }

    public Terminal newTerminal(int width,int height,AWTTerminalFontConfiguration fontCfg) throws IOException {

        TerminalSize terminalSize = new TerminalSize(width, height );

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);

        terminalFactory.setTerminalEmulatorFontConfiguration(fontCfg);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    public TerminalScreen newScreen(Terminal terminal) throws IOException {
        final TerminalScreen terminalScreen;
        terminalScreen = new TerminalScreen(terminal);

        terminalScreen.setCursorPosition(null);
        terminalScreen.startScreen();
        terminalScreen.doResizeIfNecessary();
        return terminalScreen;
        /*
          screen = new TerminalScreen(terminal);
        screen.startScreen();
        screen.doResizeIfNecessary();
        screen.setCursorPosition(null);

        return screen;
         */

    }

    @Override
    public TextGraphics createTextGraphics() {
        return screen.newTextGraphics();
    }

    private void drawText(TextGraphics textGraphics, Position position, String text, String color) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.putString(position.getX(), position.getY(), text);
    }

    public void drawSelect(Position position, String symbol, String textColor){
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        textGraphics.setForegroundColor(TextColor.Factory.fromString(textColor));
        textGraphics.putString(position.getX(),position.getY(),symbol,SGR.BLINK);
    }

    public void writeText(Position position, String text, String color, String colorText) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
        drawText(textGraphics, position, text, colorText);
    }

    public void fillBackground(TextGraphics textGraphics, String color) {
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
        textGraphics.fillRectangle(new TerminalPosition(0, 0), textGraphics.getSize(), ' ');
    }

    public void refresh() throws IOException {
        screen.refresh();
    }

    public Screen getScreen(){
        return this.screen;
    }

}
