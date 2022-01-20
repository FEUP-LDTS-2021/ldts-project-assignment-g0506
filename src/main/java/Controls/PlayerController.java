package Controls;

import Game.Gate;
import Game.Monster;
import Game.Player;
import Game.Wall;
import Position.Position;
import gui.GUI;

import java.util.ArrayList;
import java.util.List;

public class PlayerController {
    Player player;

    public PlayerController(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

    private void moveHero(Position position, List<Monster> monsters, List<Wall> walls) {
        if (Collision(position, monsters, walls))
            player.setPosition(position);
    }

    public static boolean Collision(Position position, List<Monster> monsters, List<Wall> walls) {
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

    public int heroOnGate(List<Gate> gates){
        for(Gate gate: gates) {
            if (player.getX()==gate.getPosition().getX()&&player.getY()==gate.getPosition().getY()) {
                switch (gate.getPosition().getX()){
                    case 39 -> player.setX(1);
                    case 0 -> player.setX(38);
                }
                switch(gate.getPosition().getY()){
                    case 0 -> player.setY(22);
                    case 24 -> player.setY(1);
                }
                return gate.getLoad();
            }
        }
        return 0;
    }

    public List<Monster> processKey(GUI.ACTION action, List<Monster> monsters, List<Wall> walls){
        switch (action) {
            case UP -> moveHero(player.moveUp(), monsters, walls);
            case DOWN -> moveHero(player.moveDown(), monsters, walls);
            case LEFT -> moveHero(player.moveLeft(), monsters, walls);
            case RIGHT -> moveHero(player.moveRight(), monsters, walls);
            case ATTACK -> monsters = Attack(monsters);
            /*case EXIT:
                game.setState(false);
                break;*/
        }
        return monsters;
    }

    public List<Monster> Attack(List<Monster> monsters){
        List<Monster> TempM = new ArrayList<>();
        for (Monster monster : monsters) {
            if (Math.abs(monster.getX() - player.getPosition().getX()) <= 1 && Math.abs(monster.getY() - player.getPosition().getY()) <= 1) {
                monster.setHp(monster.getHp() - (player.getAttack() - (monster.getDefense() / 5)));
                if (monster.getHp() <= 0) {
                    player.monsterKill(monster);
                } else {
                    TempM.add(monster);
                }
            } else {
                TempM.add(monster);
            }
        }
        monsters=TempM;
        return monsters;
    }
}
