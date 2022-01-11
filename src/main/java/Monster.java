public class Monster {
    private int hp, attack, defense, stamina, speed, x, y, type;

    public Monster(int type, int x, int y) {
        this.type = type;
        this.x=x;
        this.y=y;
        if (type==1){
            this.hp = 5;
            this.attack = 5;
            this.defense = 5;
            this.stamina = 5;
            this.speed = 5;
        }
        if (type==2){
            this.hp = 15;
            this.attack = 15;
            this.defense = 15;
            this.stamina = 15;
            this.speed = 15;
        }
        if (type==3){
            this.hp = 30;
            this.attack = 30;
            this.defense = 30;
            this.stamina = 30;
            this.speed = 30;
        }
        if (type==4){
            this.hp = 50;
            this.attack = 50;
            this.defense = 50;
            this.stamina = 50;
            this.speed = 50;
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
        return x;
    }

    public int getY() {
        return y;
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
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setType(int type) {
        this.type = type;
    }
}
