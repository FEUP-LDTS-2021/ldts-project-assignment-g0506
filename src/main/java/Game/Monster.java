package Game;

import Position.Position;
import java.io.IOException;
import java.util.Random;

public class Monster {
    private int hp, attack, defense, stamina, speed, type, attackCounter=0;
    private String sprite= "";
    private Position position;

    public Monster(int type, int x, int y) {
        this.type = type;
        position = new Position(x,y);
        switch(type){
            case 1:
                this.hp = 5;
                this.attack = 5;
                this.defense = 5;
                this.stamina = 5;
                this.speed = 5;
                this.sprite="a";
                break;
            case 2:
                this.hp = 15;
                this.attack = 15;
                this.defense = 15;
                this.stamina = 15;
                this.speed = 15;
                this.sprite="!";
                break;
            case 3:
                this.hp = 30;
                this.attack = 30;
                this.defense = 30;
                this.stamina = 30;
                this.speed = 30;
                this.sprite="b";
                break;
            case 4:
                this.hp = 50;
                this.attack = 50;
                this.defense = 50;
                this.stamina = 50;
                this.speed = 50;
                this.sprite="c";
            case 5:
                this.hp = 400;
                this.attack = 100;
                this.defense = 200;
                this.stamina = 50;
                this.speed = 50;
                this.sprite="M";
        }
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getStamina() {
        return stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public Position getPosition(){
        return position;
    }

    public int getType() {
        return type;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setX(int x) {
        this.position.setX(x);
    }

    public void setY(int y) {
        this.position.setY(y);
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSprite() {
        return sprite;
    }

    public int getAttackCounter() {
        return attackCounter;
    }

    public void setAttackCounter(int attackCounter) {
        this.attackCounter = attackCounter;
    }

    public void changePosition(Position position){
        if (position.getX()>this.position.getX()){
            this.position.setX(this.position.getX()+1);
        }
        else if (position.getX()<this.position.getX()){
            this.position.setX(this.position.getX()-1);
        }
        if (position.getY()>this.position.getY()){
            this.position.setY(this.position.getY()+1);
        }
        else if (position.getY()<this.position.getY()){
            this.position.setY(this.position.getY()-1);
        }
    }

    public void randomPosition(){
        Random random = new Random();
        int move=random.nextInt(8);
        switch (move){
            case 0:
                this.position.setX(this.position.getX()+1);
                this.position.setY(this.position.getY()+1);
                break;
            case 1:
                this.position.setX(this.position.getX()+1);
                this.position.setY(this.position.getY());
                break;
            case 2:
                this.position.setX(this.position.getX());
                this.position.setY(this.position.getY()+1);
                break;
            case 3:
                this.position.setX(this.position.getX()+1);
                this.position.setY(this.position.getY()-1);
                break;
            case 4:
                this.position.setX(this.position.getX()-1);
                this.position.setY(this.position.getY()+1);
                break;
            case 5:
                this.position.setX(this.position.getX()-1);
                this.position.setY(this.position.getY()-1);
                break;
            case 6:
                this.position.setX(this.position.getX());
                this.position.setY(this.position.getY()-1);
                break;
            case 7:
                this.position.setX(this.position.getX()-1);
                this.position.setY(this.position.getY());
                break;
        }
    }

    public void monsterKnockback(Position position){
        if (position.getX()>this.position.getX()){
            this.position.setX(this.position.getX()-1);
        }
        else if (position.getX()<this.position.getX()){
            this.position.setX(this.position.getX()+1);
        }
        if (position.getY()>this.position.getY()){
            this.position.setY(this.position.getY()-1);
        }
        else if (position.getY()<this.position.getY()){
            this.position.setY(this.position.getY()+1);
        }
    }


}
