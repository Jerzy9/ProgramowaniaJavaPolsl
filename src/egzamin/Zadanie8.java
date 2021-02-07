package egzamin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zadanie8 {
    public static void main(String[] args) {
        try {
            List<Integer> list = new ArrayList<>();
            Scanner in = new Scanner(System.in);
            System.out.println("Podaj ilość liczb do wprowadzenia");
            int n = in.nextInt();

            System.out.println("Teraz podawaj liczby");
            for (int i = 0; i < n; i++) {
                list.add(in.nextInt());
            }
            double srednia = Algorytm.oblicz(list);
            System.out.println(srednia);
        } catch (Exception ex) {
            System.out.println("Została podana błędna dana");
        }
    }

    static class Algorytm {

        static double oblicz(List<Integer> list) {

            double sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            return (sum / list.size());
        }
    }

}


