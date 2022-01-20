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
                return gate.getLoad();
            }
        }
        return 0;
    }

    public List<Monster> processKey(GUI.ACTION action, List<Monster> monsters, List<Wall> walls){
        switch(action){
            case UP:
                moveHero(player.moveUp(), monsters, walls);
                break;
            case DOWN:
                moveHero(player.moveDown(), monsters, walls);
                break;
            case LEFT:
                moveHero(player.moveLeft(), monsters, walls);
                break;
            case RIGHT:
                moveHero(player.moveRight(), monsters, walls);
                break;
            case ATTACK:
                monsters = Attack(monsters);
                break;
            /*case EXIT:
                game.setState(false);
                break;*/
        }
        return monsters;
    }

    public List<Monster> Attack(List<Monster> monsters){
        List<Monster> TempM = new ArrayList<Monster>();
        for (int i=0; i<monsters.size();i++){
            if (Math.abs(monsters.get(i).getX()-player.getPosition().getX())<=1 && Math.abs(monsters.get(i).getY()-player.getPosition().getY())<=1){
                monsters.get(i).setHp(monsters.get(i).getHp()-(player.getAttack()-(monsters.get(i).getDefense()/5)));
                if (monsters.get(i).getHp()<=0){
                    player.monsterKill(monsters.get(i));
                }
                else{
                    TempM.add(monsters.get(i));
                }
            }
            else{
                TempM.add(monsters.get(i));
            }
        }
        monsters=TempM;
        return monsters;
    }
}
