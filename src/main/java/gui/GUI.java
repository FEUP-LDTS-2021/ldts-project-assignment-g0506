package gui;



import Position.Position;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public interface GUI {

     TextGraphics createTextGraphics();

     void fillBackground(TextGraphics textGraphics,String color);

     void refresh() throws IOException;

     void clear();

     void writeText(Position position, String text, String color, String colorText);

     void drawSelect(Position position, String symbol, String textColor);

     void drawPlayer(Position position,int weapon);

     void drawWall(Position position,String sprite);

     void drawMonster(Position position,String sprite);

     void close() throws IOException;

     Screen getScreen();
}
