import Position.Position;
import Viewers.View;
import gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class ViewMap extends View {


    ViewMap(GUI gui) throws URISyntaxException, IOException, FontFormatException {
        super(gui);
    }

    public void drawElements(GUI gui, Player player, List<Monster> monsters, List<Wall> walls,List<Gate> gates) throws IOException {
        draw(gui);
        gui.drawPlayer(player.getPosition(), player.getWeaponSize());

        for(Wall wall: walls){
            gui.drawWall(new Position(wall.getX(), wall.getY()),wall.getSprite());
        }

        for(Monster monster: monsters){
            gui.drawMonster(monster.getPosition(), monster.getSprite());
        }

        for(Gate gate: gates){
            gui.drawWall(gate.getPosition(), gate.getSprite());
        }
    }
    @Override
    public void draw(GUI gui) throws IOException {
        gui.fillBackground(gui.createTextGraphics(),"#336699");

    }

}
