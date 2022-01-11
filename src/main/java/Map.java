import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Map {
    private int width, height;
    private Player player;
    private List<Wall> walls;
    private ReadFile file;

    public Map(int width, int height, int heroX, int heroY){
        this.width = width;
        this.height = height;
        Position position = new Position(heroX, heroY);
        player = new Player(position);
        this.walls = createWalls();
        file = new ReadFile();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for(int i = 0; i < width; i++){
            walls.add(new Wall(i, 0));
            walls.add(new Wall(i, height -1));
        }
        for(int o = 0; o < width; o++){
            walls.add(new Wall(0, o));
            walls.add(new Wall(width -1, o));
        }
        return walls;
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        player.draw(graphics);
        for(Wall wall: walls){
            wall.draw(graphics);
        }
    }

    public void processKey(KeyStroke key){
        if(key.getKeyType() == KeyType.ArrowUp)
            moveHero(player.moveUp());
        else if(key.getKeyType() == KeyType.ArrowDown)
            moveHero(player.moveDown());
        else if(key.getKeyType() == KeyType.ArrowLeft)
            moveHero(player.moveLeft());
        else if(key.getKeyType() == KeyType.ArrowRight)
            moveHero(player.moveRight());
    }

    private void moveHero(Position position) {
        if (canHeroMove(position))
            player.setPosition(position);
    }

    private boolean canHeroMove(Position position){
        return position.getX() >= 1 && position.getX() < width - 1 && position.getY() >= 1 & position.getY() < height - 1;
    }
}
