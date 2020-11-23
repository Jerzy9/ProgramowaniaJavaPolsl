package kolos1;

import java.util.Scanner;

public class Kolokwium1 {

    public Kolokwium1() {
        //Zadanie 1
//        zad1();
        //Zadanie 2
        zad2();
        //Zadanie 3
//        zad3();
        //Zadanie 4
//        zad4();
        //Zadanie 5
//        zad5();
        //Zadanie 6
//        zad6();
    }

    public static void main(String[] args) {
        new Kolokwium1();
    }

    public void zad1() {
        Scanner sc = new Scanner(System.in);
        double r = -1 ,l = -1;

        while (r <= 0) {
            System.out.println("Podaj wartość promienia stożka musi być wieksza od zera");
            r = sc.nextDouble();
        }
        while (l <= r) {
            System.out.println("Podaj wartość tworzącej stożka, musi być wieksza do zera i większa od r");
            l = sc.nextDouble();
        }

        double pole = (Math.PI * r * l) + (Math.PI * r * r);
        System.out.println("Pole stożka: " + pole);

        double hSq = (l*l) - (r*r);

        double objetosc = (1.0/3.0) * Math.PI * r * r * Math.sqrt(hSq);
        System.out.println("Objętość stożka: " + objetosc);
    }

    static class Algorytm {

        public static double max(double[] tab) {
            double max = Double.MIN_VALUE;

            for (double v : tab) if (max < v) max = v;
            return max;
        }
    }

    public void zad2() {
        int n;
        double[] tab;
        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj długość: ");
        n = sc.nextInt();
        tab = new double[n];
        System.out.print("Podaj liczby: ");

        for(int i = 0; i < n; i++)
            tab[i] = sc.nextDouble();

        double max = Algorytm.max(tab);
        System.out.println("Max: " + max);
    }

    public void zad3() {

    }


}
