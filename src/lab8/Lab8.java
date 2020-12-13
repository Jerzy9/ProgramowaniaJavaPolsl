package lab8;

import java.awt.*;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lab8 {

    public static void main(String[] args) {
        new Lab8();
    }

    public Lab8() {
        //Zadanie 1
        zad1();
        //Zadanie 2
        zad2();
        //Zadanie 3
        zad3();
        //Zadanie 4
        zad4();
        //Zadanie 5
        zad5();
        //Zadanie 6
        zad6();
        //Zadanie 7
        zad7();
        //Zadanie 8
        zad8();
        //Zadanie 9
        zad9();
        //Zadanie 10
        zad10();

    }

    static class Algorytm {

        public static void zmienZad1(Liczby liczby) {
            double temp = liczby.a;
            liczby.a = liczby.b;
            liczby.b = temp;
        }

        public static double[] iloSkaZad2(double[] wektor1, double[] wektor2) {
            double[] w = new double[wektor1.length];

            for (int i = 0; i < wektor1.length; i++) {
                w[i] = wektor1[i] * wektor2[i];
            }
            return w;
        }

        public static double[] mnozenie(double[][] a, double[] x) {
            int len = x.length;

            double[] y = new double[len];

            for (int i = 0; i < len; i++) {
                double s = 0.0;

                for (int j = 0; j < len; j++) {
                    s += a[i][j] * x[j];
                    y[i] = s;
                }
            }

            return y;
        }
    }

    class Liczby {
        double a;
        double b;
        Liczby(double a, double b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public String toString() {
            return "Liczby{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

    public void zad1() {
        Liczby l = new Liczby(5, 16);
        System.out.println(l.toString());
        Algorytm.zmienZad1(l);
        System.out.println(l.toString());
    }

    public void zad2() {
        double[] w1 = {7, 1, 5};
        double[] w2 = {6, 4, 2};

        double[] w = Algorytm.iloSkaZad2(w1, w2);
        for (int i = 0; i < w1.length; i++) {
            System.out.print(w[i] + " ");
        }
        System.out.println();
    }

    public void zad3() {
        Scanner in = new Scanner(System.in);

        System.out.println("Podaj dłogość macierzy i wektora: ");
        int len = in.nextInt();

        double[][] a = new double[len][len];
        double[] x = new double[len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print("Podaj a["+i+"]["+j+"]: ");
                a[i][j] = in.nextDouble();
            }
            System.out.print("Podaj x["+i+"]: ");
            x[i] = in.nextDouble();
        }

        double[] y = Algorytm.mnozenie(a, x);
        for (int i = 0; i < len; i++) {
            System.out.printf("|%5.1f|=|", y[i]);

            for (int j = 0; j < len; j++)
                System.out.printf("%5.1f", a[i][j]);
            System.out.printf("||%5.1f|\n", x[i]);
        }
    }

    public void zad4() {
        Scanner in = new Scanner(System.in);

        System.out.print("Podaj n: ");
        int n = in.nextInt();

        int nc = n;
        int[][] res = new int[n][n];
        int m = n;
        int i = 0, j = 0, k = 0;
        int x = 1;

        while (k < n && j < m) {

            for (i = k; i < n; ++i)
                res[j][i] = x++;
            j++;

            for (i = j; i < m; ++i)
                res[i][n - 1] = x++;
            n--;

            if (j < m) {
                for (i = n - 1; i >= k; --i)
                    res[m - 1][i] = x++;
                m--;
            }

            if (k < n) {
                for (i = m - 1; i >= j; --i)
                    res[i][k] = x++;
                k++;
            }
        }
        for (i = 0; i < nc; i++) {
            for (int l = 0; l < nc; l++)
                System.out.printf("%5d", res[i][l]);
            System.out.println();
        }
        System.out.println();
    }

    public void zad5() {
        Scanner in = new Scanner(System.in);

        System.out.print("Podaj liczbe kolumn macierzy a: ");
        int wier = in.nextInt();
        System.out.print("Podaj liczbe wierszy macierzy a: ");
        int kol = in.nextInt();
        double[][] a = new double[wier][kol];
        for (int i = 0; i < wier; i++) {
            for (int j = 0; j < kol; j++) {
                System.out.print("Podaj a["+i+"]["+j+"]: ");
                a[i][j] = in.nextDouble();
            }
        }
        System.out.print("Podaj liczbe wierszy macierzy b: ");
        int kol2 = in.nextInt();
        double[][] b = new double[wier][kol2];
        for (int i = 0; i < wier; i++) {
            for (int j = 0; j < kol2; j++) {
                System.out.print("Podaj b["+i+"]["+j+"]: ");
                b[i][j] = in.nextDouble();
            }
        }
        System.out.println(Arrays.deepToString(a));
        System.out.println(Arrays.deepToString(b));
        double[][] c = new double[a.length][b[0].length];

        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; j < b[0].length; ++j) {
                c[i][j] = 0;
                for (int k = 0; k < b.length; ++k) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        System.out.println("Wynik: ");
        System.out.println(Arrays.deepToString(c));
    }

    class X {
        double x;

        public X() {}
        public X(double x) {
            this.x = x;
            System.out.println("X konstruktor");
        }

        @Override
        public String toString() {
            return "X{" +
                    "x=" + x +
                    '}';
        }
    }

    class XY extends X {
        double y;

        public XY() {}
        public XY(double x, double y) {
            this.x = x;
            this.y = y;
            System.out.println("XY konstruktor");
        }

        @Override
        public String toString() {
            return "XY{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    class Punkt3D extends XY {
        double z;

        public Punkt3D() {}
        public Punkt3D(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
            System.out.println("3D konstruktor");
        }

        @Override
        public String toString() {
            return "Punkt3D{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }
    }
    public void zad6() {
        System.out.println("X:");
        X p1 = new X(1);
        System.out.println(p1);
        System.out.println();

        System.out.println("XY");
        XY p3 = new XY(1, 2);
        System.out.println(p3);
        System.out.println();

        System.out.println("3D");
        Punkt3D p2 = new Punkt3D(1, 2, 3);
        System.out.println(p2);
    }

    class Punkt3DKolor extends Punkt3D {
        private Color kolor;

        public Punkt3DKolor() {}
        public Punkt3DKolor(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.kolor = new Color((int) this.x,(int) this.y,(int) this.z);
        }

        @Override
        public String toString() {
            return "Punkt3DKolor{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    ", kolor=" + kolor +
                    '}';
        }
    }

    public void zad7() {
        Punkt3DKolor punkt3DKolor = new Punkt3DKolor(100, 210, 120);
        System.out.println(punkt3DKolor);
    }

    class Bazowa {
        public int bazowaPublic;
        protected int bazowaProtected;
        private int bazowaPrivate;
    }

    class Pochodna extends Bazowa {
        public int pochodnaPublic;
        protected int pochodnaProtected;
        private int pochodnaPrivate;

        public Pochodna() {
        bazowaPublic = 1;
        bazowaProtected = 2;
//        bazowaPrivate = 3;
        }
    }

    class DrugaPochodna extends Pochodna {
        public int drugaPochodnaPublic;
        protected int drugaPochodnaProtected;
        private int drugaPochodnaPrivate;

        public DrugaPochodna() {
            bazowaPublic = 4;
            bazowaProtected = 5;
//            bazowaPrivate = 6;

            pochodnaPublic = 7;
            pochodnaProtected = 8;
//            pochodnaPrivate = 9;
        }
    }

    public void zad8() {
        Bazowa bazowa = new Bazowa();
        Pochodna pochodna = new Pochodna();
        DrugaPochodna drugaPochodna = new DrugaPochodna();

        System.out.println("Dla Pochodnej");
        System.out.println( "bazowaPublic = działa;\n" +
                            "bazowaProtected = działa;\n" +
                            "bazowaPrivate = NIE działa;"
        );

        System.out.println("\nDla Drugiej Pochodnej");
        System.out.println( "bazowaPublic = działa;\n" +
                "bazowaProtected = działa;\n" +
                "bazowaPrivate = NIE działa;\n"+
                "pochodnaPublic = działa;\n" +
                "pochodnaProtected = działa;\n" +
                "pochodnaPrivate = NIE działa;"
        );
    }

    class Stos<T> {
        List<T> stos;

        public Stos(int size) {
            stos = new ArrayList<T>();
        }

        public void push(T obj) {
            stos.add(obj);
        }

        public T pop() {
            T out = stos.get(stos.size() - 1);
            stos.remove(stos.size() - 1);
            return out;
        }

        @Override
        public String toString() {
            return "Stos{" +
                    "stos=" + stos +
                    '}';
        }
    }

    public void zad9() {
        Stos<Integer> stos = new Stos<Integer>(10);

        stos.push(1);
        System.out.println(stos.pop());
        stos.push(2);
        stos.push(4);
        stos.push(6);
        stos.push(7);

        System.out.println(stos.pop());
        System.out.println(stos.pop());

        System.out.println("\n" + stos);
    }

    public void zad10() {
        Stos<Object> stos = new Stos<>(10);

        ArrayList<Object> wejscie = new ArrayList<>();
        wejscie.add(1);
        wejscie.add(3);
        wejscie.add("+");
        wejscie.add(2);
        wejscie.add("*");

        for (Object wej : wejscie) {
            if (wej instanceof String) {
                int p2 = (int) stos.pop();
                int p1 = (int) stos.pop();

                if (wej == "+")
                    stos.push(p1 + p2);
                else if (wej == "-")
                    stos.push(p1 - p2);
                else if (wej == "*")
                    stos.push(p1 * p2);
                else if (wej == "/")
                    stos.push(p1 / p2);
            } else {
                stos.push(wej);
            }
        }
        System.out.println(stos.pop());
    }
}
