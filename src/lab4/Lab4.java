package lab4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab4 {

    public static void main(String[] args) {
        new Lab4();
    }

    public Lab4() {
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
    }
    public void zad1() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        double a;
        double b;

        System.out.println("Input 2 real numbers (complete with commas) divided by spaces:");
        try {
            input = br.readLine();
        }
        catch(Exception ex){
            ex.fillInStackTrace();
            System.out.println("Error with br.readLine()");
        }

        Pattern r = Pattern.compile("(\\d+[.,]\\d+)\\s+(\\d+[.,]\\d+)");
        Matcher m = r.matcher(input);
        m.find();

        a = Double.parseDouble(m.group(1).replace(',', '.'));
        b = Double.parseDouble(m.group(2).replace(',', '.'));
        System.out.printf("Numbers: %f %f Sum: %f\n",a,b,a+b);
    }

    public void zad2() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        List<Integer> ints = new ArrayList<>();
        int sum = 0;

        System.out.println("Input few numbers divided by spaces:");
        try {
            input = br.readLine();
        }
        catch(Exception ex){
            ex.fillInStackTrace();
            System.out.println("Error with br.readLine()");
        }

        for (int i = 0; i < input.length(); i++) {
            char chatAt = input.charAt(i);
            if (chatAt == ' ') continue;

            try {
                int num = Integer.parseInt(String.valueOf(chatAt));
                ints.add(num);
                sum += num;
            } catch (Exception ex) {
                ex.fillInStackTrace();
                System.out.println("This isn't a number: " + chatAt);
            }
        }

        System.out.println(ints);
        System.out.println("Sum: " + sum);
    }

    public void zad3() {
        Scanner sc = new Scanner(System.in);
       String name = "Konrad Końdzio";

        String a;
        String input;
        System.out.println("Podaj swoje imię oraz zdrobnienie");
        input = sc.nextLine();

        Pattern r = Pattern.compile(input);
        Matcher m = r.matcher(name);

        if(m.find()) {
            a = m.group();
            System.out.println(a);
        }
    }

    public void zad4() {
        Scanner sc = new Scanner(System.in);
        String input;
        int counter = 0;

        System.out.println("Podaj różne słowa:");
        input = sc.nextLine();
        Pattern r = Pattern.compile("([a-zA-Z0-9]+)");
        Matcher m = r.matcher(input);

        while(m.find())
            counter++;
        System.out.println("Ilość wszsytkich słów: " + counter);
    }

    public void zad5() {
        String date1 = "21.11.2020";
        String date2 = "544.12.2019";
        Matcher m;
        Pattern r = Pattern.compile("(\\d{2}).\\d{2}.\\d{4}");

        System.out.println(date1);
        m = r.matcher(date1);
        if(m.matches())
            System.out.println("Pierwsza data jest poprawna");
        else
            System.out.println("Pierwsza data nie jest poprawna");

        System.out.println("\n" +date2);
        m = r.matcher(date2);
        if(m.matches())
            System.out.println("Druga data jest poprawna");
        else
            System.out.println("Druga data nie jest poprawna");
    }

    public void zad6() {
        Scanner sc = new Scanner(System.in);
        String input;
        String pat;

        System.out.println("Podaj słowa do sprawdzania");
        pat = sc.nextLine();

        input = sc.nextLine();
        while(input.contains(pat)) {
            System.out.println(input);

            input = sc.nextLine();
        }
    }

    public void zad7() {
        int tab[] = new int[10];
        int j =0;
        for (int i = 0; i < 100; i++) {
            double d = Math.random();
            int random = (int) (d*100);

             if (random < 20){
                 System.out.println(random);
                 j++;

                 if(j >= 10) break;
             }
        }
    }

    public void zad8() {
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 1; i <= 7; i++) {
            List list = new ArrayList();

            for (int j = 0; j < i; j++) {
                Random r = new Random();
                list.add(r.nextInt(10));
                System.out.print(list.get(j) + ", ");
            }
            lists.add(list);
            System.out.println();
        }
    }

    public void zad9() {
        char[] a = new char[26];
        char[] b = new char[34];
        char[] c= new char[34];

        int i = 0;

        for (; i < 26; i++) {
            a[i] = (char)('a'+i);
            b[i] = (char)('a'+i);
            c[i] = (char)('A'+i);
        }
        for(var j : "ąęśćżźłó".toCharArray()){
            b[i] = j;
            c[i] = (char)(j-1);
            i++;
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
