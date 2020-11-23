package kolos1;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

public class Kolokwium1 {

    public Kolokwium1() {
        //Zadanie 1
//        zad1();
        //Zadanie 2
//        zad2();
        //Zadanie 3
//        zad3();
        //Zadanie 4
//        zad4();
        //Zadanie 5
        zad5();
    }

    public static void main(String[] args) {
        new Kolokwium1();
    }

    public void zad1() {
        Scanner sc = new Scanner(System.in);
        double r = -1 ,l = -1;

        while (r <= 0) {
            System.out.println("Podaj wartość promienia stożka musi być wieksza od zera");
            r = sc.nextDouble();
        }
        while (l <= r) {
            System.out.println("Podaj wartość tworzącej stożka, musi być wieksza do zera i większa od r");
            l = sc.nextDouble();
        }

        double pole = (Math.PI * r * l) + (Math.PI * r * r);
        System.out.println("Pole stożka: " + pole);

        double hSq = (l*l) - (r*r);

        double objetosc = (1.0/3.0) * Math.PI * r * r * Math.sqrt(hSq);
        System.out.println("Objętość stożka: " + objetosc);
    }

    static class Algorytm {

        public static double max(double[] tab) {
            double max = Double.MIN_VALUE;

            for (double v : tab) if (max < v) max = v;
            return max;
        }
    }

    public void zad2() {
        int n;
        double[] tab;
        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj długość: ");
        n = sc.nextInt();
        tab = new double[n];
        System.out.print("Podaj liczby: ");

        for(int i = 0; i < n; i++)
            tab[i] = sc.nextDouble();

        double max = Algorytm.max(tab);
        System.out.println("Max: " + max);
    }

    public void zad3() {
        System.out.println("Podaj ścieżkę do pliku: ");
        Scanner scp = new Scanner(System.in);
        try {
            String path = scp.nextLine();
            File file = new File(path);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                System.out.println(data);
            }
            sc.close();

        } catch (Exception ex) {
            ex.fillInStackTrace();
            System.out.println("Błędna sciezka do pliku");
        }
    }

    class Dane implements Comparable<Dane> {
        private int id;
        private String nazwisko;
        private Integer wynagrodzenie;

        public Dane(int id, String nazwisko, int wynagrodzenie) {
            this.id = id;
            this.nazwisko = nazwisko;
            this.wynagrodzenie = wynagrodzenie;
        }

        @Override
        public String toString() {
            return "Dane{" +
                    "id=" + id +
                    ", nazwisko='" + nazwisko + '\'' +
                    ", wynagrodzenie=" + wynagrodzenie +
                    '}';
        }

        @Override
        public int compareTo(Dane o) {
            return this.wynagrodzenie.compareTo(o.wynagrodzenie);
        }
    }

    public void zad4() {
        Dane[] pracownicy = {
                new Dane(1, "4", 5000),
                new Dane(1, "5", 4000),
                new Dane(1, "231", 3500),
                new Dane(1, "35", 75000),
                new Dane(1, "264", 2000),
        };
        Arrays.sort(pracownicy);

        for (Dane dane: pracownicy) {
            System.out.println(dane.toString());
        }
    }

    class Muzyka  {
        private Album[] albumy;

        public Muzyka() {
            this.albumy = new Album[]{
                    new Album(1, "White album", "The Beatles", 10.99, 1964, true),
                    new Album(2, "Black Album", "Metalica", 11.99, 1994, false),
                    new Album(3, "Warriors", "Imagine Dragons", 8.99, 2000,true),
                    new Album(4, "9th's symphony", "Ludvig von Beethoven", 21.99, 1750,true),
                    new Album(5, "Supermassive black hole", "Muse", 13.99, 2017,true)
            };
        }

        public void wydrukujAlbumy() {
            for (Album al:albumy) {
                System.out.println(al.toString());
            }
            System.out.println();
        }

        public void posortujWedlugNazwy() {
            Arrays.sort(this.albumy);
        }

        public void wypozyczAlbum(int id) {
            Optional<Album> album = Arrays.stream(albumy).filter(a -> a.id == id).findFirst();
            if (album.isEmpty()) System.out.println("Nie znaleziono albumu");
            if (!album.get().dostepna) System.out.println("Aktualnie ten album jest niedostepny");
            else  {
                album.get().dostepna = false;
                System.out.println("Wypożoczyny został album: " + album.get().nazwa);
            }
        }

        public void oddajAlbum(int id) {
            Optional<Album> album = Arrays.stream(albumy).filter(a -> a.id == id).findFirst();
            if (album.isEmpty()) System.out.println("Nie znaleziono albumu");
            if (album.get().dostepna) System.out.println("Ten album jest już oddany, proszę mnie nie kłamać");
            else  {
                album.get().dostepna = true;
                System.out.println("Zwrócony do wypożyczalni został album: " + album.get().nazwa);
            }
        }
    }

    class Album implements Comparable<Album> {
        private int id;
        private String nazwa;
        private String wykonawca;
        private double cena;
        private int rokWyd;
        private boolean dostepna;

        public Album(int id, String nazwa, String wykonawca, double cena, int rokWyd, boolean dostepna) {
            this.id = id;
            this.nazwa = nazwa;
            this.wykonawca = wykonawca;
            this.cena = cena;
            this.rokWyd = rokWyd;
            this.dostepna = dostepna;
        }

        @Override
        public String toString() {
            String dos = "DOSTĘPNA";
            if (!this.dostepna) dos = "NIEDOSTĘPNA";
            return "Album{" +
                    "id=" + id +
                    ", nazwa='" + nazwa + '\'' +
                    ", wykonawca='" + wykonawca + '\'' +
                    ", cena=" + cena +
                    ", rokWyd=" + rokWyd +
                    ", status=" + dos;
        }

        @Override
        public int compareTo(Album o) {
            return this.nazwa.compareTo(o.nazwa);
        }


    }

    public void zad5() {
        Muzyka wypożyczalnia = new Muzyka();
        wypożyczalnia.wydrukujAlbumy();

        wypożyczalnia.posortujWedlugNazwy();
        wypożyczalnia.wydrukujAlbumy();

        wypożyczalnia.wypozyczAlbum(1);
        wypożyczalnia.wydrukujAlbumy();

        wypożyczalnia.oddajAlbum(1);
        wypożyczalnia.wydrukujAlbumy();

    }
}
