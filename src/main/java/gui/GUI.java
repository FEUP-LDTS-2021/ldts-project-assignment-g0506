package gui;



import Position.Position;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public interface GUI {

    public TextGraphics createTextGraphics();

    public void fillBackground(TextGraphics textGraphics,String color);

    public void refresh() throws IOException;

    public void writeText(Position position, String text, String color, String colorText);

    public void drawSelect(Position position, String symbol, String textColor);

    public Screen getScreen();
}
