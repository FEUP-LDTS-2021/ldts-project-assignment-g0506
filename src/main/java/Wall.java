import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall {
    private int x, y;
    private String c;
    public Wall(int x, int y, char c){
        this.x = x;
        this.y = y;
        this.c = "" + c;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void draw(TextGraphics graphics){
        graphics.putString(new TerminalPosition(x, y), c);
    }
}