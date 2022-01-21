package Game;

import Position.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private int hp,hpI, attack, defense, stamina, speed, exp, level;
    private Position position;
    private List<Weapon> weapons;
    private List<Coin> coins;
    private boolean alive;

    public Player(Position position){
        this.hp = 15;
        this.hpI=15;
        this.attack = 10;
        this.defense = 10;
        this.stamina = 10;
        this.speed = 10;
        this.position = position;
        this.exp = 0;
        this.level = 1;
        this.alive=true;
        weapons = new ArrayList<Weapon>();
        Weapon w = new Weapon(1, 5);
        weapons.add(w);
        if (weapons.get(0).getType()==1){
            this.attack+=weapons.get(0).getBoost()/5;
        }
        else{
            this.defense+=weapons.get(0).getBoost()/5;
        }
        coins = new ArrayList<Coin>();
    }

    public Player(Position position, int hp, int level, int exp, List<Weapon> weapons){
        this.position = position;
        this.hp = hp;
        this.level = level;
        this.exp = exp;
        this.weapons = weapons;
        this.hpI = level*5+15;
        this.attack = level*5+10;
        this.defense = level*5+10;
        this.stamina = level*5+10;
        this.speed = level*5+10;
        this.alive = true;
        coins = new ArrayList<Coin>();
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
        position.setX(x);
    }

    public void setY(int y) {
        position.setY(y);
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public int getExp() {
        return exp;
    }

    public int getLevel() {
        return level;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getWeaponSize(){
        return getWeapons().size();
    }

    public void addWeapon(Weapon weapon){
        this.weapons.add(weapon);
    }

    public void addCoin(Coin coin){
        this.coins.add(coin);
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public int getCoinsSize(){
        return getCoins().size();
    }

    public void monsterKill(Monster monster){
        exp+=monster.getType()*100;
        if (exp>=100*(level*level)){
            level+=1;
            hp+=5;
            hpI+=5;
            attack+=5;
            defense+=5;
            stamina+=5;
            speed+=5;
        }
    }

    public String healthCount(){
        double hpPercent=100*(((double)hp)/hpI);
        String hpShow;
        if (hpPercent<100){
            hpShow=String.valueOf(hpPercent);
            hpShow= hpShow.substring(0,2)+"%";
            return hpShow;
        }
        if (hpPercent<10){
            hpShow=String.valueOf(hpPercent);
            hpShow= hpShow.substring(0,1)+"%";
        }
        if (hpPercent<0){
            hpPercent=0;
            hpShow=String.valueOf(hpPercent);
            hpShow= hpShow.substring(0,1)+"%";
        }
        hpShow=String.valueOf(hpPercent);
        hpShow= hpShow.substring(0,3)+"%";
        return hpShow;

    }

    public String getLevelString(){
        return Integer.toString(level);
    }

}
