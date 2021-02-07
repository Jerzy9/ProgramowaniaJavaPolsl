package lab12;

import java.util.Arrays;

public class lab12 {

    public static void main(String[] args) {
        new lab12();
    }

    public lab12() {
        //Zadanie 1
//        zad1();
        //Zadanie 2
//        zad2();
        //Zadanie 3
//        zad3();
        //Zadanie 4
//        zad4();
        //Zadanie 6
        zad6();
    }

    private void zad1() {
        System.out.println(silniaFor(5));
    }

    private int silniaFor(int n) {
        int sum = 1;
        for (int i = 1; i < n + 1; i++) {
            sum *= i;
        }
        return sum;
    }

    private void zad2() {
        System.out.println(silniaRekurencja(5));
    }

    private int silniaRekurencja(int n) {
        if (n == 1) {
            return 1;
        } else {
           return n*silniaRekurencja(n-1);
        }
    }

    private void zad3() {
        int[] tab1 = {1,2,3};
        int[] tab2 = {4,5,6};

        System.out.println(Arrays.toString(tab1));
        System.out.println(Arrays.toString(tab2));
        System.out.println(Arrays.toString(scalanie(tab1, tab2)));
    }

    private int[] scalanie(int[] tab1, int[] tab2) {
        int[] tab3 = new int[tab1.length + tab2.length];

        System.arraycopy(tab1, 0, tab3, 0, tab1.length);
        System.arraycopy(tab2, 0, tab3, tab1.length, tab2.length);

        return tab3;
    }

    private void zad4() {
        int[] tab = {543,576,23,6782,3,673,4,7,7899,345,5764,345,2,6,3,7,3,8,3,75,4,50,0,2};

        System.out.println(Arrays.toString(tab));
        merge(tab);
        System.out.println(Arrays.toString(tab));
    }

    private void merge(int[] tab) {
        int mid = tab.length / 2;
        int[] left = new int[mid];
        int[] right = new int[tab.length - mid];

        int i = 0, j = 0, k = 0;

        System.arraycopy(tab, 0, left, 0, mid);
        System.arraycopy(tab, mid, right, 0, tab.length - mid);
        merge(left);
        merge(right);

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                tab[k] = left[i];
                i++;
            } else {
                tab[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            tab[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            tab[k] = right[j];
            j++;
            k++;
        }
    }

    private void zad6() {
        int[] tab = {543,576,23,6782,3,673,4,7,7899,345,5764,345,2,6,3,7,3,8,3,75,4,50,0,2};

        System.out.println(Arrays.toString(tab));
        quick(tab,0 , tab.length-1);
        System.out.println(Arrays.toString(tab));
    }

    public int part(int[] tab, int s, int e) {
        int c = tab[e];
        int temp1, temp2;

        for (int i = s; i < e; i++){
            if(tab[i] >= c) continue;
            temp1 = tab[s];
            tab[s] = tab[i];
            tab[i] = temp1;
            s++;
        }
        temp2 = tab[s];
        tab[s] = c;
        tab[e] = temp2;

        return s;
    }

    public void quick(int[] tab, int s, int e){
        int part = part(tab, s, e);

        if (part+1 < e) quick(tab, part+1, e);
        if (part-1 > s) quick(tab, s, part-1);
    }
}
