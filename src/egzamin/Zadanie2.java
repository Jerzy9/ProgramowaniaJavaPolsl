package egzamin;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zadanie2 {

    public static void main(String[] args) {
        zad2();
    }

    public static void zad2() {
        File file = new File("wejsciezadanie2.txt");
        List<Integer> list = new ArrayList<>();
        try {
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                list.add(in.nextInt());
            }

        } catch (Exception ex) {
            System.out.println("Błędne dane w pliku wejścia lub nie znaleziono pliku wejscie.txt");
        }

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++)

                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
        }

        try {
            FileWriter fileWriter = new FileWriter("wyjsciezadanie2.txt");
            for (int i = 0; i < list.size(); i++) {
                fileWriter.write(list.get(i) + "\n");
            }
            fileWriter.close();

        } catch (Exception ex) {
            System.out.println("Błąd");
        }

        System.out.println("Zapisano odpowiedz do pliku wyjsciezadanie2.txt");
    }
}
