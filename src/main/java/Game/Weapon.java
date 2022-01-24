package Game;

public class Weapon {
    private int type, boost;
    private String weapon;
    public Weapon(int type, int power) {
        switch (type) {
            case 1:
                this.type = 1;
                this.boost=power;
                this.weapon= "SWORD";
                break;
            case 2:
                this.type = 2;
                this.boost = power;
                this.weapon="SHIELD";
                break;
            case 3:
                this.type = 3;
                this.boost = power;
                this.weapon = "LIFE SWORD";
                break;
        }
    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getBoost() {
        return boost;
    }

    public String getWeapon() {
        return weapon;
    }
}
