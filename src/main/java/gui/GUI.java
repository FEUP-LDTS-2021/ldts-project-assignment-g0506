package gui;



import Position.Position;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public interface GUI {

     TextGraphics createTextGraphics();

     void fillBackground(TextGraphics textGraphics,String color,Position position);

     void refresh() throws IOException;

     void clear();

     void writeText(Position position, String text, String color, String colorText);

     void drawSelect(Position position, String symbol, String textColor);

     void drawPlayer(Position position,int weapon);

     void drawWall(Position position,String sprite);

      void drawLine(Position position);

     ACTION getKeyCommand() throws IOException;

     void drawMonster(Position position,String sprite);

     void drawAttack(Position position) throws IOException;

     void close() throws IOException;

     Screen getScreen();

     enum ACTION {UP, RIGHT, DOWN, LEFT, ATTACK, NONE, QUIT, SELECT,EXIT, W1, W2, W3, W4}
}
