package Game;
import Position.Position;
import ReadFile.ReadFile;
import Viewers.ViewMap;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import gui.GUI;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {
    GUI gui;
    ViewMap viewMap;
    private Player player;
    private List<Wall> walls;
    private ReadFile file;
    private List<Monster> monsters;
    private List<Gate> gates;

    public Map(GUI gui, Player player, String stage) throws URISyntaxException, IOException, FontFormatException {
        this.gui = gui;
        viewMap = new ViewMap(gui);

        this.player = player;
        file = new ReadFile(stage);
        createWalls_Gates();
        addMonster();
    }

    private void createWalls_Gates() {
        walls = new ArrayList<>();
        gates = new ArrayList<>();
        List<String> lines = file.getMap();
        for(int i = 0; i < lines.size(); i++){
            String line = lines.get(i);
            for(int j = 0; j < line.length(); j++){
                if(line.charAt(j)=='*')
                    walls.add(new Wall(new Position(j,i),'*'));

                if(line.charAt(j)=='+')
                    gates.add(new Gate(new Position(j,i), '+'));
            }
        }
    }



    public void draw() throws IOException {
        viewMap.drawElements(gui,player,monsters,walls,gates);
        gui.refresh();
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
        for (Monster monster: monsters){
            if (position.getX()==monster.getX()&&position.getY()==monster.getY()){
                return false;
            }
        }
        for(Wall wall: walls){
            if(position.getX()==wall.getX()&&position.getY()==wall.getY()){
                return false;
            }
        }
        return true;
    }

    public int heroOnGate(){
        for(Gate gate: gates) {
            if (player.getX()==gate.getPosition().getX()&&player.getY()==gate.getPosition().getY()) {
                System.out.println(gate.getLoad());
                return gate.getLoad();
            }
        }
        return 0;
    }

    private boolean canMonsterMove(Monster m, int counter){
        int counter2=0;
        for(Monster monster: monsters){
            if (counter2==counter){
                continue;
            }
            else{
                if (Math.abs(m.getX()-monster.getX())<=1 && Math.abs(m.getY()-monster.getY())<=1){
                    return false;
                }
            }
            counter2+=1;
        }
        if (Math.abs(m.getX()-player.getPosition().getX())<=1&& Math.abs(m.getY()-player.getPosition().getY())<=1){
            return false;
        }
        return true;
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
            Monster monster= new Monster(rarity, random.nextInt(30-2)+1, random.nextInt(30-2)+1);
            monsters.add(monster);
        }
    }

    public void moveMonsters(){
        int counter=0;
        for(Monster monster: monsters){
            if (canMonsterMove(monster,counter)){
                if (Math.abs(monster.getX()-player.getPosition().getX())<5 && Math.abs(monster.getY()-player.getPosition().getY())<5){
                    monster.changePosition(player.getPosition());
                }
            }
            counter+=1;
        }
    }
}
