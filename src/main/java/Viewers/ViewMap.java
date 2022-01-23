package Viewers;

import Game.Gate;
import Game.Monster;
import Game.Player;
import Game.Wall;
import Position.Position;
import gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class ViewMap extends View {



    public ViewMap(GUI gui) throws URISyntaxException, IOException, FontFormatException {
        super(gui);
    }

    public void drawElements(GUI gui, Player player, List<Monster> monsters, List<Wall> walls, List<Gate> gates) throws IOException {
        draw(gui);
        drawPlayerBar(gui,player);
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
        gui.fillBackground(gui.createTextGraphics(),"#336699",new Position(0,0));
        gui.fillBackground(gui.createTextGraphics(),"#000000",new Position(0,24));
    }

    public void drawPlayerBar(GUI gui,Player player){
        gui.writeText(new Position(1,24),"HEALTH: ","#000000","#FFFFFF");
        gui.writeText(new Position(8,24), player.healthCount(), "#000000","#FFFFFF");
        gui.writeText(new Position(13,24), "LEVEL:", "#000000","#FFFFFF");
        gui.writeText(new Position(19,24), player.getLevelString(), "#000000","#FFFFFF");
        gui.writeText(new Position(21,24), "WEAPON:", "#000000","#FFFFFF");
        gui.writeText(new Position(28,24), player.ChosenWeapon(), "#000000","#FFFFFF");

    }
}
