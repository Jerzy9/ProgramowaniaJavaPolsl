package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lab1 {

    public static void main(String[] args) {
//       Zadania zad = new Zadania();
//       //zad.zad2();
//
//       try {
//           zad.zad4();
//       } catch (IOException ex) {
//           System.out.println("Proszę podać liczbę");
//           ex.printStackTrace();
//       }
    }
}
class Zadania {

    public void zad1() {
        System.out.println("Konrad Zbylut");
    }

    public void zad2() {
        System.out.println("X X");
        System.out.println(" X ");
        System.out.println("X X");
    }

    public  void  zad3() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Liczba pierwsza: ");
        int a = Integer.parseInt(in.readLine());

        System.out.println("Liczba druga: ");
        int b = Integer.parseInt(in.readLine());

        //dodawanie
        System.out.println("dodawanie liczb: " + (a+b));
        //odejmowanie
        System.out.println("odejmowanie pierwszej od drugiej: " + (a - b));
        //mnożenie
        System.out.println("mnożenie liczb: " + (a*b));
        //dzielenie
        if(b == 0) System.out.println("nie dziel przez zero");
        else {
            System.out.print("dzielenie pierwszej przez drugą: " + (a / b));
        }
    }

    public void zad4() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Promień koła: ");
        int r = Integer.parseInt(in.readLine());

        double d = Math.PI*r*r;
        System.out.println("Powierzchnia koła: " + d);

    }

    public void zad5() {

    }
}
