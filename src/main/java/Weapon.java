public class Weapon {
    private int type;
    public Weapon(int type){
        if (type==1){
            this.type=1;
        }
        if (type==2){
            this.type=2;
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
