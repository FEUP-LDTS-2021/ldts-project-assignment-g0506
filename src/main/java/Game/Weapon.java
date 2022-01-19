package Game;

public class Weapon {
    private int type, boost;
    public Weapon(int type, int power) {
        switch (type) {
            case 1:
                this.type = 1;
                this.boost=power;
            case 2:
                this.type = 2;
                this.boost = power;
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
}
