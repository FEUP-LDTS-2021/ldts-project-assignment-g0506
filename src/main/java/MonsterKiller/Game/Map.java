package MonsterKiller.Game;

import MonsterKiller.Position.Position;
import MonsterKiller.ReadFile.ReadFile;
import MonsterKiller.Viewers.ViewMap;
import MonsterKiller.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class Map{
    GUI gui;
    Game game;
    ViewMap viewMap;
    private Player player;
    private List<Wall> walls;
    private ReadFile file;
    private List<Monster> monsters;
    private List<Gate> gates;
    private long timeLastMov,timeLastSpawn;
    private int stage;

    public Map(GUI gui, Player player, String stage,Game game) throws URISyntaxException, IOException, FontFormatException {
        this.gui = gui;
        viewMap = new ViewMap(gui);
        this.player = player;
        if (stage.length()==11){
            this.stage = parseInt(stage.substring(5, 7));
        }
        else{
            this.stage = parseInt(stage.substring(5, 6));
        }
        file = new ReadFile(stage);
        createWalls_Gates();
        monsters = new ArrayList<Monster>();
        this.timeLastMov = 0;
        this.timeLastSpawn = 0;
        this.game = game;
    }

    public int getStage(){
        return stage;
    }

    public List<Monster> getMonsters(){
        return monsters;
    }

    public List<Wall> getWalls(){
        return walls;
    }

    public List<Gate> getGates(){
        return gates;
    }

    public void setMonsters(List<Monster> monsters){
        this.monsters = monsters;
    }

    public void run(long time) {
        Random rand = new Random();
        if(time - timeLastSpawn > 1000){
        if(rand.nextBoolean() && monstersSize() < 10){
            if (getStage()!=12){
                addMonster();
            }
            else{
                if (monsters.size()==0 && !player.isBossKiller()){
                    addBoss();
                }
            }
        }
            timeLastSpawn = time;
        }
        moveMonsters(time);

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

    public void draw(long time) throws IOException {
        run(time);
        viewMap.drawElements(gui,player,monsters,walls,gates);
        gui.refresh();
    }


    private boolean invalidMonsterMove(Monster m, int tempx, int tempy, int counter){
        for (Wall wall: walls){
            if (wall.getX()==m.getX()&&wall.getY()==m.getY()){
                m.setX(tempx);
                m.setY(tempy);
                return false;
            }
        }
        for (Gate gate: gates){
            if (gate.getPosition().getX()==m.getX()&&gate.getPosition().getY()==m.getY()){
                m.setX(tempx);
                m.setY(tempy);
                return false;
            }
        }
        int counter2=0;
        for (Monster monster1:monsters){
            if (counter==counter2){

            }
            else{
                if (monster1.getX()==m.getX()&&monster1.getY()==m.getY()){
                    m.setX(tempx);
                    m.setY(tempy);
                    return false;
                }
            }
            counter2+=1;
        }
        if (player.getPosition().getX()==m.getX()&&player.getPosition().getY()==m.getY()){
            m.setX(tempx);
            m.setY(tempy);
            return false;
        }
        return true;
    }

    public void addMonster(){
        Random random = new Random();
        int rarity= random.nextInt(400);
        if (rarity>100){
            rarity=1;
        }
        else if (rarity>50){
            rarity=2;
        }
        else if (rarity>10){
            rarity=3;
        }
        else if (rarity>0){
            rarity=4;
        }
        int mx=player.getPosition().getX(), my=player.getPosition().getY();
        while (Math.abs(mx-player.getPosition().getX())<5 && Math.abs(my-player.getPosition().getY())<5){
            mx=random.nextInt(40-2)+1;
            my=random.nextInt(25-4)+1;
        }
        Monster monster = new Monster(rarity,mx,my);
        monsters.add(monster);
    }

    public void moveMonsters(long time){
        int counter=0;
        if (time-timeLastMov>400) {

        for(Monster monster: monsters){
            if ((Math.abs(monster.getX()-player.getPosition().getX())<5 && Math.abs(monster.getY()-player.getPosition().getY())<5)|| monster.getType()==5){
                int tempx=monster.getX(),tempy= monster.getY();
                monster.changePosition(player.getPosition());
                invalidMonsterMove(monster,tempx,tempy,counter);
                if (Math.abs(monster.getX()-player.getPosition().getX())<=1 && Math.abs(monster.getY()-player.getPosition().getY())<=1){
                    if (monster.getAttackCounter()<1){
                        monster.setAttackCounter(1);
                    }
                    else{
                        if (player.getWeapons().get(player.getWeaponIndex()).getType()==2){
                            player.setDefense(player.getDefense()+(player.getWeapons().get(player.getWeaponIndex()).getBoost()/5));
                        }
                        player.setHp(player.getHp()-(monster.getAttack()-(player.getDefense()/5)));
                        if (player.getWeapons().get(player.getWeaponIndex()).getType()==2){
                            player.setDefense(player.getDefense()-(player.getWeapons().get(player.getWeaponIndex()).getBoost()/5));
                        }
                        monster.setAttackCounter(0);
                        if (player.getHp()<=0){
                            player.setAlive(false);
                        }
                    }

                }

            }
            else{
                int tempx=monster.getX(),tempy= monster.getY();
                monster.randomPosition();
                while (!invalidMonsterMove(monster,tempx,tempy,counter)){
                    monster.randomPosition();
                }
            }
            counter+=1;
        }
            timeLastMov = time;
        }
    }
    public int monstersSize(){
        return monsters.size();
    }

    public void addBoss(){
        Monster monster = new Monster(5,19,4);
        monsters.add(monster);
    }
}

