package MonsterKiller.ReadFile;

import MonsterKiller.Game.Weapon;
import MonsterKiller.Position.Position;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveFile {
    String stage;
    Position player_pos;
    String hp;
    String level;
    String exp;
    List<Weapon> weapons;

    public SaveFile(String stage, Position player_pos, int hp, int level, int exp, List<Weapon> weapons){
        this.stage = stage;
        this.player_pos = player_pos;
        this.hp = Integer.toString(hp);
        this.level = Integer.toString(level);
        this.exp = Integer.toString(exp);
        this.weapons = weapons;
    }

    public void SaveGame() throws IOException {
        try {
            String filename = "SaveState1.txt";

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

            myWriter.write(stage+ "\n");
            myWriter.write(player_pos.getX()+"\n");
            myWriter.write(player_pos.getY()+"\n");
            myWriter.write(hp+"\n");
            myWriter.write(level+"\n");
            myWriter.write(exp+"\n");
            String w = "";
            for(Weapon weapon: weapons) {
                w += (Integer.toString(weapon.getType()) + weapon.getBoost()) + "\n";
            }
            myWriter.write(w);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
