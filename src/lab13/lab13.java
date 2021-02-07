package lab13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class lab13 {

    public static void main(String[] args) {
        new lab13();
    }

    public lab13() {
        //Zadanie 1
        zad1();
        //Zadanie 2
//        zad2();
        //Zadanie 3
//        zad3();
        //Zadanie 4
//        zad4();
        //Zadanie 6
//        zad6();
    }

    private void zad1() {
        File file = new File("D:\\CodeProjects\\sping_intelij\\lab1\\src\\dane.txt");
        FileInputStream fileInputStream = null;

        if (!file.exists()) {
            System.out.println("Błędna nazwa pliku");

        } else {

            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            Scanner scanner = new Scanner(fileInputStream, StandardCharsets.UTF_8);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }
    }

    private void zad2() {

    }
}
