package product.config;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVUtils {
    public static <T> void write(String path, List<T> items){
        try {
            PrintWriter print = new PrintWriter(new FileWriter(path,false));
            for (Object item: items) {
                print.println(item.toString());
            }
            print.flush();
            print.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(path + "invalid");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String>read(String path){
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e){
            throw new IllegalArgumentException(path + "invalid");
        }
    }
}


