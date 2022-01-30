package MonsterKiller.ReadFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile{
    private List<String> file_lines;
    private List<String> resume_line;

    public ReadFile(String file_name) {
        try {
            file_lines = new ArrayList<String>();
            File myObj = new File(file_name);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                file_lines.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ReadFile() throws FileNotFoundException {
        resume_line = new ArrayList<>();
        File resume = new File("SaveState1.txt");

        Scanner myReader = new Scanner(resume);

        while(myReader.hasNextLine()){
            String line = myReader.nextLine();
            resume_line.add(line);
        }
        myReader.close();
    }

    public List<String>getResume_line(){
        return resume_line;
    }

    public List<String> getMap(){
        return file_lines;
    }
}
