import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {
    private int width, height;
    private Player player;
    private List<Wall> walls;
    private ReadFile file;
    private List<Monster> monsters;

    public Map(int width, int height, int heroX, int heroY){
        this.width = width;
        this.height = height;
        Position position = new Position(heroX, heroY);
        player = new Player(position);
        file = new ReadFile("Stage1.txt");
        this.walls = createWalls();
        addMonster();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        List<String> lines = file.getMap();
        for(int i = 0; i < lines.size(); i++){
            String line = lines.get(i);
            for(int j = 0; j < line.length(); j++){
                if(line.charAt(j)=='*')
                    walls.add(new Wall(j, i, '*'));
                if(line.charAt(j)=='o')
                    walls.add(new Wall(j, i, 'o'));
            }
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
        for(Monster monster: monsters){
            monster.draw(graphics);
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

    public void addMonster(){
        Random random = new Random();
        monsters = new ArrayList<>();
        for (int i=0;i<10;i++){
            int rarity= random.nextInt(400);
            if (rarity>200){
                rarity=1;
            }
            else if (rarity>100){
                rarity=2;
            }
            else if (rarity>20){
                rarity=3;
            }
            else if (rarity>0){
                rarity=4;
            }
            Monster monster= new Monster(random.nextInt(rarity), random.nextInt(width-2)+1, random.nextInt(height-2)+1);
            monsters.add(monster);
        }
    }
}
