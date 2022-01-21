package ReadFile;

import Game.Weapon;
import Position.Position;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveFile {
    String stage;
    Position player_pos;
    int hp;
    int level;
    int exp;
    List<Weapon> weapons;

    public SaveFile(String stage, Position player_pos, int hp, int level, int exp, List<Weapon> weapons){
        this.stage = stage;
        this.player_pos = player_pos;
        this.hp = hp;
        this.level = level;
        this.exp = exp;
        this.weapons = weapons;
    }

    public void SaveGame() throws IOException {
        try {
            String filename = "SaveState"+stage+".txt";
            File file = new File(filename);
            if (file.createNewFile()) {
                WriteToFile(file);
                File f = new File("Saves");
                FileWriter fW = new FileWriter(f);
                fW.write(filename);
            } else {
               file.delete();
               file = new File(filename);
               WriteToFile(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void WriteToFile(File file){
        try {
            FileWriter myWriter = new FileWriter(file);
            myWriter.write(stage);
            myWriter.write(player_pos.getX() + " " + player_pos.getY());
            myWriter.write(hp);
            myWriter.write(level);
            myWriter.write(exp);
            String w = "";
            for(Weapon weapon: weapons) {
                w += (Integer.toString(weapon.getType()) + weapon.getBoost()) + " ";
            }
            myWriter.write(w);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
