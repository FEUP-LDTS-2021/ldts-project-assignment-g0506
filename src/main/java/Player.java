import java.util.List;

public class Player {
    private int hp, attack, defense, stamina, speed, x, y, exp=0, gem=0,level;
    private List<Weapon> weapons;

    public Player() {
        this.hp = 10;
        this.attack = 10;
        this.defense = 10;
        this.stamina = 10;
        this.speed = 10;
        this.x = x;
        this.y = y;
        this.exp = 0;
        this.gem = 0;
        this.level = 1;
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
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
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
        return x;
    }

    public int getY() {
        return y;
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
            attack+=5;
            defense+=5;
            stamina+=5;
            speed+=5;
        }
    }

}
