import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import com.googlecode.lanterna.TerminalSize;

public class Game {
    private Screen screen;
    private Map map;

    public Game(){
        map = new Map(120, 40, 1, 38);
        try {
            TerminalSize terminalSize = new TerminalSize(120, 40);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void draw() throws IOException{
        screen.clear();
        map.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run() throws IOException{
        while(true) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
               if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
                   screen.close();
               if(key.getKeyType() == KeyType.EOF)
                   break;
            moveMonsters();
        }
    }
    private void processKey(KeyStroke key)
    {
        map.processKey(key);
    }

    private void moveMonsters(){
        map.moveMonsters();
    }
}
