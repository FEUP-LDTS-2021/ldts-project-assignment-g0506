package Controls;

import Game.*;
import Position.Position;
import gui.GUI;

import java.util.ArrayList;
import java.util.List;

public class PlayerController {
    private Map map;
    private Player player;

    public PlayerController(Player player, Map map){
        this.player = player;
        this.map = map;
    }

    public Player getPlayer(){
        return player;
    }

    private void moveHero(Position position) {
        if (Collision(position))
            player.setPosition(position);
    }

    public boolean Collision(Position position) {
        for (Monster monster: map.getMonsters()){
            if (position.getX()==monster.getX()&&position.getY()==monster.getY()){
                return false;
            }
        }
        for(Wall wall: map.getWalls()){
            if(position.getX()==wall.getX()&&position.getY()==wall.getY()){
                return false;
            }
        }
        return true;
    }

    public int heroOnGate(){
        for(Gate gate: map.getGates()) {
            if (player.getX()==gate.getPosition().getX()&&player.getY()==gate.getPosition().getY()) {
                switch (gate.getPosition().getX()){
                    case 39 -> player.setX(1);
                    case 0 -> player.setX(38);
                }
                switch(gate.getPosition().getY()){
                    case 0 -> player.setY(22);
                    case 23 -> player.setY(1);
                }
                return gate.getLoad();
            }
        }
        return 0;
    }

    public int processKey(GUI.ACTION action){
        switch (action) {
            case UP:
                moveHero(player.moveUp());
                break;
            case DOWN:
                moveHero(player.moveDown());
                break;
            case LEFT:
                moveHero(player.moveLeft());
                break;
            case RIGHT:
                moveHero(player.moveRight());
                break;
            case ATTACK:
                Attack();
                break;
            case EXIT:
                return 1;
            case SELECT:
                return 2;
            case W1:
                if (player.getWeaponSize()>0){
                    player.setWeaponIndex(0);
                    break;
                }
                else{
                    return 0;
                }
            case W2:
                if (player.getWeaponSize()>1){
                    player.setWeaponIndex(1);
                    break;
                }
                else{
                    return 0;
                }
            case W3:
                if (player.getWeaponSize()>2){
                    player.setWeaponIndex(2);
                    break;
                }
                else{
                    return 0;
                }
            case W4:
                if (player.getWeaponSize()>3){
                    player.setWeaponIndex(3);
                    break;
                }
                else{
                    return 0;
                }
        }
        return 0;
    }

    public void Attack(){
        if (player.getWeapons().get(player.getWeaponIndex()).getType()!=2){
            player.setAttack(player.getAttack()+(player.getWeapons().get(player.getWeaponIndex()).getBoost()/5));
        }
        List<Monster> TempM = new ArrayList<>();
        for (Monster monster : map.getMonsters()) {
            if (Math.abs(monster.getX() - player.getPosition().getX()) <= 1 && Math.abs(monster.getY() - player.getPosition().getY()) <= 1) {
                if (player.getWeapons().get(player.getWeaponIndex()).getType()==3){
                    player.setHp(player.getHp()+((player.getAttack() - (monster.getDefense() / 5))/5));
                    if (player.getHp() > player.getHpI()){
                        player.setHp(player.getHpI());
                    }
                }
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
        map.setMonsters(TempM);
        if (player.getWeapons().get(player.getWeaponIndex()).getType()!=2){
            player.setAttack(player.getAttack()-(player.getWeapons().get(player.getWeaponIndex()).getBoost()/5));
        }
    }

    public boolean isAlive(){
        return player.isAlive();
    }

    public int getHP(){
        return player.getHp();
    }

    public int getEXP(){
        return player.getExp();
    }

    public int getLevel(){
        return player.getLevel();
    }

    public List<Weapon> getWeapons(){
        return player.getWeapons();
    }

    public Position getPosition(){
        return player.getPosition();
    }
}
