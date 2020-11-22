package lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class lab5 {

    public lab5() {
        //Zadanie 1
        zad1();

        //Zadanie 2
        zad2();

        //Zadanie 3
        zad3();
        //Zadanie 4
        Algorytm algo = new Algorytm();
        int[] tab = {1,2,3,45,3,5,23,4,6,9,0,45,2};
        System.out.println(algo.smallerIndex(tab, 13));
        System.out.println(algo.avg(tab, 13));
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
        //Zadanie 10/11
        zad10i11();
    }

    public static void main(String[] args) {
        new lab5();
    }

    public void zad1() {
        for (int i = 0; ; i++) {
            System.out.println(i);
        }
    }

    public void zad2() {
        for(int i = 1; i <= 10; i++) {
            for(int x = 1; x <= 10; x++)
                System.out.println(x*i);
            System.out.println();
        }
    }

    public void zad3() {
        int n;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Scanner sc = new Scanner(System.in,"Cp1250");
        System.out.println("Podaj długość: ");
        n = sc.nextInt();

        int[] tab = new int[n];
        System.out.println("Podaj liczby: ");

        for(int i = 0; i < n; i++) {
            tab[i] = sc.nextInt();
            max = Integer.max(max, tab[i]);
            min = Integer.min(min, tab[i]);
        }
        System.out.println("Min: " + min + "    " + "Max: " + max);
    }

    class Algorytm {

        public int smallerIndex(int[] tab, int n) {
            int index = 0;
            double min = Double.MAX_VALUE;

            for(int i = 0; i < n; i++)
                if(tab[i] < min) {
                    index = i;
                    min = tab[i];
                }
            return index;
        }

        public int avg(int[] tab, int n) {
            int sum = 0;

            for(int i = 0; i < n; i++)
                sum += tab[i];

            return sum/n;
        }
    }

    public void zad5() {
        int n;
        int[] tab;
        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj długość: ");
        n = sc.nextInt();
        tab = new int[n];
        System.out.print("Podaj liczby: ");

        for(int i = 0; i < n; i++)
            tab[i] = sc.nextInt();

        System.out.print("Przed sortowaniem: ");
        for(int i = 0; i < n; i++) System.out.print(tab[i] + " ");

        System.out.println();
        Arrays.sort(tab);

        System.out.print("Po sortowaniu: ");
        for(int i = 0; i < n; i++) System.out.print(tab[i] + " ");
    }

    public void zad6Sort(int[] a) {
        Arrays.sort(a);
    }

    public int[] zad6Sort(int[] a, int max) {
        Arrays.sort(a);
        int[] sorted = new int[a.length];

        int index = 0;
        for (int i = a.length-1; i > 0 ; i--) {
            sorted[index] = a[i];
            index++;
        }

        return sorted;
    }

    public void zad6() {
        int[] ints = {5,3,7,2,5,1,9};
        ints = zad6Sort(ints, 3);

        for(int i = 0; i < ints.length-1; i++) System.out.print(ints[i] + " ");
    }

    public void zad7() {
        double[] tab = new double[1];
        NumberFormat pl = NumberFormat.getInstance(new Locale("pl","PL"));
        File file = new File("D:\\CodeProjects\\sping_intelij\\lab1\\src\\lab5\\plik.txt");
        Scanner sc;

        try {
            sc = new Scanner(file);
        }
        catch (FileNotFoundException ex) {
            ex.fillInStackTrace();
            System.out.println("Błąd podczas odczytu pliku");
            return;
        }

        while(sc.hasNextLine()) {
            try {
                tab[tab.length-1] = pl.parse(sc.nextLine()).doubleValue();
            }
            catch (Exception ex) {
                ex.fillInStackTrace();
                continue;
            }
            tab = Arrays.copyOf(tab, tab.length+1);
        }

        Arrays.sort(tab);
        for (double v : tab) System.out.print(v + "  ");
    }


    public int smallerIndex(int[] tab, int n, int imin, int imax) {
        int index = 0;
        double min = Double.MAX_VALUE;

        for(int i = imin; i <= imax; i++)
            if(tab[i] < min) {
                index = i;
                min = tab[i];
            }

        return index;
    }

    public void zad8() {
        int[] tab = {2,7,2,0};
        System.out.println(smallerIndex(tab, 4, 1,2));
    }

    public void zad9() {
        int[] tab = {2,7,2,0};
        int n = 4;
        int imin = 0, imax = n-1, index;

        while(imin <= imax) {
            index = smallerIndex(tab,n,imin,imax);
            if(index > imin)
            {
                int temp = tab[imin];
                tab[imin] = tab[index];
                tab[index] = temp;
            }
            imin++;
        }
        for (int i = 0; i < tab.length-1 ; i++) System.out.print(tab[i] + "  ");
    }
    public void zad10i11() {
        int[] tab = {1,2,3,45,3,5,23,4,6,9,0,45,2};

        for (int i = 1; i < tab.length-1; i++) {

            int key = tab[i];
            int j = i-1;

            while( j >= 0 && tab[j] > key) {
                tab[j+1] = tab[j];
                j--;
            }
            tab[j+1] = key;

        }
        for (int i = 0; i < tab.length-1 ; i++) System.out.print(tab[i] + "  ");

    }
}
