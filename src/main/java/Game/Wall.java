package Game;

import Position.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall {
    private Position position;
    private String sprite;
    public Wall(Position position, char c){
        this.position = position;
        this.sprite = "" + c;
    }
    public int getX() {
        return position.getX();
    }
    public int getY() {
        return position.getY();
    }
    public void setX(int x) {position.setX(x);}
    public void setY(int y) {position.setY(y);}
    public String getSprite(){
        return sprite;
    }
}