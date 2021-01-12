package kolos2;


import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kolokwium2 {

    public static void main(String[] args) {
        new Kolokwium2();
    }

    public Kolokwium2() {
        //Zadanie 1
//        zad1();
        //Zadanie 2
        zad2();
        //Zadanie 3
        zad3();
        //Zadanie 4
        zad4();
        //Zadanie 5
        zad5();

    }

    static class Algorytm {

        static public double skalar(double[] tab1, double[] tab2) {
            double s = 0;
            int len = tab1.length;

            if (tab1.length == tab2.length)
                for (int i = 0; i < len ; i++) {
                    s += tab1[i] * tab2[i];
                }

            return s;
        }

    }

    private void zad1() {
        double[] tab1 = {1,2,3}, tab2 = {3,2,1};
        double skalar = Algorytm.skalar(tab1, tab2);
        System.out.println(skalar);
    }

    static class Algorytm2 {

        static public void sortowanie(List<Double> tab) {
            for (int i = 1; i < tab.size(); i++) {
                int j = i - 1;
                double key = tab.get(i);

                while (j >= 0 && tab.get(j) > key) {
                    tab.set(j+1, tab.get(j));
                    j--;
                }

                tab.set(j + 1, key);
            }
        }
    }

    private void zad2() {
        Scanner in;
        List<Double> list = new ArrayList<>();
        try {
            File file = new File("D:\\CodeProjects\\sping_intelij\\lab1\\src\\lab10\\zad2in.txt");
             in = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("Nie znaleziono pliku");
            return;
        }

        while (in.hasNextDouble()) {
            list.add(in.nextDouble());
        }

        System.out.println(list);
        Algorytm2.sortowanie(list);
        System.out.println(list);

    }

    private void zad3() {

    }

    private void zad4() {

    }

    private void zad5() {

    }
}
