package lab9;

import javax.swing.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Lab9 {

    public static void main(String[] args) {
        new Lab9();
    }

    public Lab9() {
        //Zadanie 1
//        zad1();
        //Zadanie 2
//        zad2();
        //Zadanie 3
//        zad3();
        //Zadanie 4
        zad4();
        //Zadanie 5
//        zad5();
        //Zadanie 6
//        zad6();
        //Zadanie 7
//        zad7();

    }

    public double convert(String s) {
        String[] nums = s.split(",");
        double res = 0;

        try {
            res = Double.parseDouble(nums[0]);
            if (nums.length > 1) {
                int len = nums[1].length();
                double m = Math.pow(10, len);
                res += Double.parseDouble(nums[1]) / m;
            }

        } catch (Exception ex) {
            System.out.println("Błąd podczas konwersji");
        }
//        System.out.println(res);
        return res;
    }

    public void zad1() {
        try {
            File file = new File("lab9\\dane.txt");
            Scanner in = new Scanner(file);

            while (in.hasNext()) {
                String next = in.next();
                double d1 = convert(next);

                next = in.next();
                double d2 = convert(next);
                double wynik = Math.abs(d1-d2);
                System.out.print(wynik + ", ");

            }
            in.close();
        } catch (Exception ex) {
            System.out.println("Bład podczas wczytywania pliku");
            ex.printStackTrace();
        }
    }

    public void zad2() {
        Random r = new Random();
        Scanner in = new Scanner(System.in);

        System.out.print("Podaj wartosc n");
        int n = Integer.parseInt(in.nextLine());

        try {
            FileWriter fw = new FileWriter("losowe.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for( int i = 0; i < n; i++) {
                int rnum = r.nextInt(n);

                bw.write(Integer.toString(rnum));
                bw.write(System.getProperty("line.separator"));
            }

        } catch (Exception ex) {
            System.out.println("Błąd podczas zapisywania do pliku");
            ex.printStackTrace();
        }

    }

    public void zad3() {
        Scanner in = new Scanner(System.in);

        System.out.println("Podaj ścieżkę do pliku z rozszerzeniem .txt");
        String p1 = in.next();

        try {
            FileWriter fileWriter = new FileWriter(p1);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("Polskie znaki:ąęćłóśżź");
            bufferedWriter.close();

        } catch (IOException ex) {
            System.out.println("Błąd podczas zapisywania do pliku");
            ex.printStackTrace();
        }

        System.out.println("Podaj ścieżkę do pliku z rozszerzeniem .txt, dla drugiej wersji zadania");
        String p2 = in.next();

        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(p2));
            dataOutputStream.writeUTF("Polskie znaki:ąęćłóśżź");

        } catch (IOException ex) {
            System.out.println("Błąd podczas zapisywania do pliku");
            ex.printStackTrace();
        }
    }

    public void zad4() {
        Scanner in = new Scanner(System.in);
        System.out.print("Podaj nazwe pliku: ");
        String p = in.nextLine();

        try {
            File file = new File(p);
            Scanner fromFile = new Scanner(file);

            while (fromFile.hasNextLine())
                System.out.println(fromFile.nextLine());

        } catch (Exception ex) {
            System.out.println("Błąd podczas odczytu z pliku: " + p);
            ex.printStackTrace();
        }

    }
    public void zad5() {
    }

    public void zad6() {
    }

    private void zad7() {
    }
}
