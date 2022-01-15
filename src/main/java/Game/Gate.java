package Game;

import Position.Position;

public class Gate {
    Position position;
    int load;
    String sprite;
    public Gate(Position position, char sprite){
        this.position = position;
        this.sprite = "" + sprite;
        load = setLoad(position.getX(), position.getY());
    }

    public String getSprite(){
        return sprite;
    }

    public int setLoad(int x,int y){
        if(y == 1) return 3;
        if(y == 30) return -3;
        else if( x == 0 ) return -1;
        return 1;
    }

    public int getLoad(){
        return load;
    }

    public Position getPosition(){
        return position;
    }
}
