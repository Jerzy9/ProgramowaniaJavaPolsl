package lab3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lab3 {

    public static void main(String[] args) {
        new Lab3();
    }

    public Lab3() {
        zad1();

        zad2();

        zad3();

        zad4();

        zad5();

        zad6();

        zad7();
    }

    public void zad1() {
        System.out.println("Zadanie 1");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String text_line = "";
        System.out.println("Wypisuj tekt na ekran, słowo 'quit' kończy operacje: ");

        while (!text_line.equals("quit")) {

            try {
                text_line = in.readLine();
            } catch (IOException ex) {
                ex.fillInStackTrace();
            }
            System.out.println(text_line);

        }
    }

    public void zad2() {
        System.out.println("\nZadanie 2");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String text_line = "";
        int counter = 0;

        System.out.println("Wpisz tekst: ");
        try {
            text_line = in.readLine();
        } catch (IOException ex) {
            ex.fillInStackTrace();
        }

        for (int i = 0; i < text_line.length() ; i++) {
            if (text_line.charAt(i) == 'a') counter ++;
        }

        System.out.println("Liczba litery a we wprowdzonym  tekście to: " + counter);
    }

    public void zad3() {
        System.out.println("\nZadanie 3");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String text_line = "";

        System.out.println("Wpisz tekst: ");
        try {
            text_line = in.readLine();
        } catch (IOException ex) {
            ex.fillInStackTrace();
        }

        StringBuilder result = new StringBuilder();
        boolean isSpace = false;

        for (int i = 0; i < text_line.length() ; i++) {

            if (text_line.charAt(i) == ' ') {
                isSpace = true;
                continue;
            }
            if (isSpace) {
                result.append(" ");
                isSpace = false;
            }
            result.append(text_line.charAt(i));
        }
        System.out.println(result);
    }

    public void zad4() {
        System.out.println("\nZadanie 4");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String text_line = "";

        System.out.println("Wpisz tekst: ");
        try {
            text_line = in.readLine();
        } catch (IOException ex) {
            ex.fillInStackTrace();
        }

        int counter = 0;
        for (int i = 0; i < text_line.length() -1; i++) {
            String twoLetters = "" +text_line.charAt(i) + text_line.charAt(i+1);
            if (twoLetters.equals("ab")) counter++;
        }

        System.out.println("liczba dwuznaku 'ab' to: " + counter);
    }

    public void zad5() {
        System.out.println("\nZadajnie 5");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String text_line = "";

        System.out.println("Wpisz tekst: ");
        try {
            text_line = in.readLine();
        } catch (IOException ex) {
            ex.fillInStackTrace();
        }

        boolean isSpace = false;
        int counter = 0;
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < text_line.length() ; i++) {

            if (text_line.charAt(i) == ' ') {
                isSpace = true;
                continue;
            }
            if (isSpace) {
                counter++;
                isSpace = false;
                str.append(text_line.charAt(i));
            }
        }

        if (str.charAt(str.length()-1) != ' ') counter++;

        System.out.println("Liczba słów to: " + counter);
    }

    public void zad6() {
        System.out.println("\nZadajnie 6");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String text_line = "";

        System.out.println("Wpisz tekst: ");
        try {
            text_line = in.readLine();
        } catch (IOException ex) {
            ex.fillInStackTrace();
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < text_line.length() ; i++) {
            char currentChar = text_line.charAt(i);

            if (currentChar == ' ') {
                if (res.length() > 0) {
                    System.out.println(res);
                    res = new StringBuilder();
                }
                continue;
            }
            res.append(currentChar);
        }
        System.out.println(res);
    }

    public void zad7() {
        System.out.println("\nZadanie 7");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String text_line = "";
        System.out.println("Wypisuj tekt na ekran, słowo 'quit' kończy operacje: ");

        while (!text_line.equals("quit")) {
            try {
                text_line = in.readLine();
            } catch (IOException ex) {
                ex.fillInStackTrace();
            }

            for (int i = 0; i < text_line.length(); i++) {
                char currentChar = text_line.charAt(i);

                if (currentChar == ' ') continue;

                text_line = text_line.substring(i);
                break;
            }

            for (int i = text_line.length() - 1; i > 0; i--) {
                char currentChar = text_line.charAt(i);

                if (currentChar == ' ') continue;

                text_line = text_line.substring(0, i+1);
                break;
            }

            System.out.println(text_line);
        }
    }
}
