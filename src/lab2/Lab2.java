package lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lab2 {

    public static void main(String[] args) {
        new Lab2();
    }

    public Lab2() {
        //ZADANIE 1
        try {
            zad1();
        } catch (Exception ex) {
            ex.fillInStackTrace();
            System.out.println("Błędna wartość");
        }

        //ZADANIE 2
        try {
            zad2();
        } catch (Exception ex) {
            ex.fillInStackTrace();
            System.out.println("Błędna wartość");
        }

        //ZADANIE 3
        try {
            zad3();
        } catch (Exception ex) {
            ex.fillInStackTrace();
            System.out.println("Błędna wartość");
        }

        //ZADANIE 4
        try {
            zad4();
        } catch (Exception ex) {
            ex.fillInStackTrace();
            System.out.println("Błędna wartość");
        }
        Algorytm algorytm = new Algorytm();

//        ZADANIE 5
        try {
            algorytm.zad5();
        } catch (Exception ex) {
            ex.fillInStackTrace();
            System.out.println("Błędna wartość");
        }

//      ZADANIE 6
        try {
            algorytm.zad6();
        } catch (Exception ex) {
            ex.fillInStackTrace();
            System.out.println("Błędna wartość");
        }

    }
    public void zad1() throws IOException, NumberFormatException {
        System.out.println("Zadanie 1");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Pierwsza liczba rzeczywista: ");
        double d1 = Double.parseDouble(in.readLine());
        System.out.print("Druga liczba rzeczywista: ");
        double d2 = Double.parseDouble(in.readLine());

        double add = d1 + d2;
        System.out.println("Dodawanie: " + add);
        double di = d1 / d2;
        System.out.println("Dzielenie: " + di);

    }

    public void zad2() throws IOException, NumberFormatException {
        System.out.println("\nZadanie 2");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Podaj wartość dla a (musi być różna od 0)");
        int a = Integer.parseInt(in.readLine());
        if(a == 0) throw new NumberFormatException();

        System.out.println("Podaj wartość dla b");
        int b = Integer.parseInt(in.readLine());

        int x = -b/a;
        System.out.println("Punkt przecięcia z osią OX to: P(" + x + ",0)");

    }

    public void zad3() throws IOException, NumberFormatException {
        System.out.println("\nZadanie 3");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Podaj wartość dla r: ");
        double r = Integer.parseInt(in.readLine());
        System.out.print("Podaj wartość dla h: ");
        double h = Integer.parseInt(in.readLine());

        if(r <= 0 || h <= 0) throw new NumberFormatException();

        double p = 2 * Math.PI * r * h;
        double v = Math.PI * (Math.pow(r,2)) * h;

        System.out.println("Pole powierzchni bocznej walca: " + p);
        System.out.println("Objętość walca: " + v);
    }

    public void zad4() throws IOException, NumberFormatException {
        System.out.println("\nZadanie 4");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Podaj wartość dla a, musi być różne od 0: ");
        double a = Double.parseDouble(in.readLine());
        if(a == 0) throw new NumberFormatException();

        System.out.print("Podaj wartość dla b: ");
        double b = Double.parseDouble(in.readLine());
        System.out.print("Podaj wartość dla c: ");
        double c = Double.parseDouble(in.readLine());

        double delta = (b*b) - (4*a*c);

        if(delta < 0) System.out.println("Podane równanie kwadratowe nie ma rozwiązań");
        else if(delta == 0) {
            double x = -b / (2 * a);
            System.out.println("Równanie ma tylko jedno rozwiązanie x = " + x);
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Rozwiązania dla tego równania to: x1 = " + x1 + "  oraz x2 = "  + x2);
        }
    }
}

class Algorytm {

    public void zad5() {
        System.out.println("\nZadanie 5");

        int[][] a = {{1,2},{3,4}};
        int[] b = {5,6};


        double w1 = (a[0][0] * a[1][1]) - (a[0][1] * a[1][0]);
        double w2 = (b[0] * a[1][1]) - (a[0][1] * b[1]);
        double w3 = (a[0][0] * b[1]) - (b[0] * a[1][0]);

        if(w1 == 0) throw new NumberFormatException("w1 nie może równać się 0");

        double x = w2/w1;
        double y = w3/w1;

        System.out.println("x: " + x);
        System.out.println("y: " + y);
    }

    public void zad6() {
        System.out.println("\nZadanie 6");

        double[][] a = {{1,3,2}, {7,4,9}, {5,6,8}};
        double[] b = {7,15,17};

        double w = wyznacznik3x3(a);

        double[] res = new double[3];

        for (int i = 0; i < 3 ; i++) {

            double[][] aCop = {{1,3,2}, {7,4,9}, {5,6,8}};
            aCop[0][i] = b[0];
            aCop[1][i] = b[1];
            aCop[2][i] = b[2];
            double wyz = wyznacznik3x3(aCop);
            res[i] = (wyz == -0) ? wyz * -1: wyz;
        }
        System.out.println("x: " + (res[0]/w));
        System.out.println("y: " + (res[1]/w));
        System.out.println("z: " + (res[2]/w));
    }

    public double wyznacznik3x3(double[][] tab) {
        return ((tab[0][0] * tab[1][1] * tab[2][2]) + (tab[1][0] * tab[2][1] * tab[0][2]) + (tab[2][0] * tab[0][1] * tab[1][2])) -
                ((tab[0][2] * tab[1][1] * tab[2][0]) + (tab[1][2] * tab[2][1] * tab[0][0]) + (tab[2][2] * tab[0][1] * tab[1][0]));
    }

}