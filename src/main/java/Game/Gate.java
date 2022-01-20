package Game;

import Position.Position;

public class Gate {
    Position position;
    int load;
    String sprite;
    public Gate(Position position, char sprite){
        this.position = position;
        this.sprite = "" + sprite;
        setLoad(position);
    }

    public String getSprite(){
        return sprite;
    }

    public void setLoad(Position position){
        switch (position.getX()) {
            case 0 -> this.load = -1;
            case 39 -> this.load = 1;
        }
        switch (position.getY()) {
            case 0 -> this.load = 3;
            case 23 -> this.load = -3;
        }
    }

    public int getLoad(){
        return load;
    }

    public Position getPosition(){
        return position;
    }
}
