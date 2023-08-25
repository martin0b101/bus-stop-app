package Common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

    public static List<String> readFile(String filePath){
        try{
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            List<String> data = new ArrayList<>();
            while(scanner.hasNextLine()){
                 data.add(scanner.nextLine());
            }
            return data;

        } catch (FileNotFoundException e){
            System.out.println("Error");
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
