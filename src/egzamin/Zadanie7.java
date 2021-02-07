package egzamin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Zadanie7 {

    public static void main(String[] args) {
        try {
            File file = new File("wejsciezadanie7.txt");
            Scanner in = new Scanner(file, "Cp1250");

            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
