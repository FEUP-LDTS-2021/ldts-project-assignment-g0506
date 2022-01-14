import Position.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private int hp,hpI, attack, defense, stamina, speed, exp, gem, level;
    private Position position;
    private List<Weapon> weapons=new ArrayList<>();

    public Player(Position position){
        this.hp = 10;
        this.hpI=10;
        this.attack = 10;
        this.defense = 10;
        this.stamina = 10;
        this.speed = 10;
        this.position = position;
        this.exp = 0;
        this.gem = 0;
        this.level = 1;
        Weapon w=new Weapon(1);
        weapons.add(w);
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
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString(("#FFFF33")));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
        if (weapons.size()>0){
            graphics.setForegroundColor(TextColor.Factory.fromString(("#71797E")));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(position.getX()+1, position.getY()-1), "/");
        }


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

    public void setGem(int gem) {
        this.gem = gem;
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

    public int getGem() {
        return gem;
    }

    public int getLevel() {
        return level;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void addWeapon(Weapon weapon){
        this.weapons.add(weapon);
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
        int hpPercent=100*(hp/hpI);
        String hpShow=String.valueOf(hpPercent)+"%";
        return hpShow;
    }

    public void Attack(TextGraphics ggraphics){

    }
}
