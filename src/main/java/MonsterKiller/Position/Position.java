package MonsterKiller.Position;

public class Position {
    private int x, y;

    public Position(int x,int y){
        this.x = x;
        this.y = y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }
}