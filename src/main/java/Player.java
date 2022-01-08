import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import java.io.IOException;
import java.util.List;

public class Player {
    private int hp, attack, defense, stamina, speed, exp, gem;
    private Position position;
    private List<Weapon> weapons;

    public Player(Position position){
        this.position = position;
    }

    public Position moveUp(){
        return new Position(position.getX(), position.getY()-1);
    }
    public Position moveDown(){
        return new Position(position.getX(), position.getY()+1);
    }
    public Position moveLeft(){
        return new Position(position.getX() - 1, position.getY());
    }
    public Position moveRight(){
        return new Position(position.getX() + 1, position.getY());
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public void draw(TextGraphics graphics) throws IOException {
        graphics.setForegroundColor(TextColor.Factory.fromString(("#FFFF33")));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
    }
}
