package lab13;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        //Zadanie 5
//        zad5();
        //Zadanie 6
//        zad6();
    }

    private void zad1() {
        File file = new File("D:\\CodeProjects\\sping_intelij\\lab1\\src\\dane.txt");
        FileInputStream fileInputStream = null;

        if (!file.exists()) {
            System.out.println("Nie znaleziono pliku");

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
        File file = new File("D:\\CodeProjects\\sping_intelij\\lab1\\src\\dane.txt");
        FileInputStream fileInputStream = null;
        List<String> tab = new ArrayList<>();

        if (!file.exists()) {
            System.out.println("Nie znaleziono pliku");
        } else {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            assert fileInputStream != null;
            Scanner scanner = new Scanner(fileInputStream, StandardCharsets.UTF_8);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                tab.add(line);
            }

            Scanner in = new Scanner(System.in);
            System.out.print("Podaj szuakny ciąg znaków: ");
            String ff = in.nextLine();

            for (int i = 0; i < tab.size(); i++) {
                if (tab.get(i).equals(ff)) {
                    i++;
                    System.out.println("Znaleziono wiersz o indeksie: " + i);
                    return;
                }
            }
            System.out.println("Brak wyników");
        }
    }

    private void zad3() {
        Scanner in = new Scanner(System.in);
        List<String> tab = new ArrayList<>();

        System.out.println("Wpisuj linie tekstu, słowo \"break\" zakończy wpisywanie \n");
        while (true) {

            String newLine = in.nextLine();
            if (newLine.equals("break")) break;
            tab.add(newLine);
        }

        Collections.sort(tab);
        for (String line:tab)
            System.out.println(line);
    }

    private void zad4() {
        File file = new File("D:\\CodeProjects\\sping_intelij\\lab1\\src\\dane.txt");
        FileInputStream fileInputStream = null;
        List<String> tab = new ArrayList<>();

        if (!file.exists()) {
            System.out.println("Nie znaleziono pliku");
        } else {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            assert fileInputStream != null;
            Scanner scanner = new Scanner(fileInputStream, StandardCharsets.UTF_8);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                tab.add(line);
            }

            Collections.sort(tab);
            File file2 = new File("sotowane.txt");
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            assert fileOutputStream != null;
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            Collections.sort(tab);

            try {
                for (String line : tab) {
                    System.out.println(line);
                    bufferedWriter.write(line + "\n");
                }
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void zad5() {
        File file = new File("D:\\CodeProjects\\sping_intelij\\lab1\\src\\dane.txt");
        FileInputStream fileInputStream = null;

        if (!file.exists()) {
            System.out.println("Nie znaleziono pliku");
        } else {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            assert fileInputStream != null;
            Scanner scanner = new Scanner(fileInputStream, StandardCharsets.UTF_8);

            List<String> stringList = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                stringList.add(line);
            }

            Scanner inputScanner = new Scanner(System.in);
            System.out.print("Szukaj: ");
            String find = inputScanner.nextLine();
            int i = Collections.binarySearch(stringList, find);


            if (i != -1) {
                i++;
                System.out.println("Znaleziono wiersz o indeksie: " + i);
                return;
            }
            System.out.println("Brak wyników");
        }
    }

    private void zad6() {
        File file = new File("D:\\CodeProjects\\sping_intelij\\lab1\\src\\dane.txt");
        FileInputStream fileInputStream = null;
        List<String> tab = new ArrayList<>();

        if (!file.exists()) {
            System.out.println("Nie znaleziono pliku");
        } else {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            assert fileInputStream != null;
            Scanner scanner = new Scanner(fileInputStream, StandardCharsets.UTF_8);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                tab.add(line);
            }

            Collections.sort(tab);
            File file2 = new File("sotowane.txt");
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            assert fileOutputStream != null;
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            Collections.sort(tab);

            try {
                for (String line : tab) {
                    System.out.println(line);
                    bufferedWriter.write(line + "\n");
                }
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
