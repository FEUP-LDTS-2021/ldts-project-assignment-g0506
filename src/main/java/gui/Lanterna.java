package gui;

import Position.Position;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Lanterna implements GUI {
    Screen screen;

    public Lanterna() throws URISyntaxException, IOException, FontFormatException {
        AWTTerminalFontConfiguration fontCfg = loadFont("square.ttf");
        int width = 40;
        int height = 25;
        Terminal terminal = newTerminal(width, height, fontCfg);
        screen = newScreen(terminal);
    }

    public AWTTerminalFontConfiguration loadFont(String nameFont) throws URISyntaxException, IOException, FontFormatException{
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

    public void drawPlayer(Position position,int weapon, boolean boss){
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        if (boss){
            textGraphics.setForegroundColor(TextColor.Factory.fromString("#AFE1AF"));
        }
        else{
            textGraphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        }
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.putString(position.getX(),position.getY(),"x");


    }

    @Override
    public void drawWall(Position position,String sprite) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.putString(position.getX(),position.getY(),sprite);
        writeText(position,sprite,"#336699","#00FF00");
    }

    public void drawMonster(Position position,String sprite){
        TextGraphics textGraphics = screen.newTextGraphics();
        writeText(position,sprite,"#336699","#000000");
    }

    public void fillBackground(TextGraphics textGraphics, String color,Position position) {
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
        textGraphics.fillRectangle(new TerminalPosition(position.getX(), position.getY()), textGraphics.getSize(), ' ');
    }

    public void drawLine(Position position){
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        textGraphics.fillRectangle(new TerminalPosition(position.getX(), position.getY()), textGraphics.getSize(), ' ');
    }

    @Override
    public ACTION getKeyCommand() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if(keyStroke==null)
            return ACTION.NONE;
        switch(keyStroke.getKeyType()){
            case EOF:
            case Escape:
                return ACTION.QUIT;
            case ArrowUp:
                return ACTION.UP;
            case ArrowDown:
                return ACTION.DOWN;
            case ArrowLeft:
                return ACTION.LEFT;
            case ArrowRight:
                return ACTION.RIGHT;
            case Character:
                if(keyStroke.getCharacter()=='q'){
                    return ACTION.EXIT;
                }
                else if(keyStroke.getCharacter()==' '){
                    return ACTION.ATTACK;
                }
                else if(keyStroke.getCharacter()=='1'){
                    return ACTION.W1;
                }
                else if(keyStroke.getCharacter()=='2'){
                    return ACTION.W2;
                }
                else if(keyStroke.getCharacter()=='3'){
                    return ACTION.W3;
                }
                else if(keyStroke.getCharacter()=='4'){
                    return ACTION.W4;
                }
                return ACTION.NONE;
            case Backspace:
                return ACTION.SELECT;
        }
        return ACTION.NONE;
    }

    public void drawAttack(Position position) throws IOException {
        writeText(new Position(position.getX()-1,position.getY()-1),"j","#336699","#000000");
        writeText(new Position(position.getX(),position.getY()-1),"f","#336699","#000000");
        writeText(new Position(position.getX()+1,position.getY()-1),"i","#336699","#000000");
        writeText(new Position(position.getX()-1,position.getY()),"e","#336699","#000000");
        writeText(new Position(position.getX()+1,position.getY()),"$","#336699","#000000");
        writeText(new Position(position.getX()-1,position.getY()+1),"k","#336699","#000000");
        writeText(new Position(position.getX(),position.getY()+1),"g","#336699","#000000");
        writeText(new Position(position.getX()+1,position.getY()+1),"h","#336699","#000000");
        refresh();
    }

    public void refresh() throws IOException {
        screen.refresh();
    }

    public Screen getScreen(){
        return this.screen;
    }


    public void clear(){
        screen.clear();
    }

    public void close() throws IOException {
        screen.close();
    }
}
