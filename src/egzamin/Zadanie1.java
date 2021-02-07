package egzamin;

import java.util.Scanner;

public class Zadanie1 {

    public static void main(String[] args) {
        oblicz();
    }

    public static void oblicz() {
        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Proszę podać długość krawędzi:");
            int a = in.nextInt();
            System.out.print("\nProszę podać wysokość: ");
            int h = in.nextInt();

            int pb = 4 * a * h;
            int v = a * a * h;

            System.out.println("Pole boczne: " + pb);
            System.out.println("Objętość: " + v);

        } catch (Exception ex) {
            System.out.println("Błędne dane, spróbuj ponownie");
            oblicz();
        }
    }
}
