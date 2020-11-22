package lab6;

import java.util.Arrays;


public class lab6 {

    private final Dane2[] dane2s = {
            new Dane2("Samsung", "232 345 123"),
            new Dane2("LG", "232 345 123"),
            new Dane2("OnePlus", "232 345 123"),
            new Dane2("Apple", "232 345 123"),
            new Dane2("Xiaomi", "232 345 123")
    };

    private final Pracownik[] pracownicy = {
            new Pracownik(3, "Kowal", "Dyrektor"),
            new Pracownik(2, "Adamek", "Dyrektor"),
            new Pracownik(4, "Kowalski", "Matematyk"),
            new Pracownik(5, "Paciorek", "Redaktor"),
            new Pracownik(1, "Szczurek", "Informatyk")
    };

    private final Ksiazka[] ksiazki = {
            new Ksiazka(3, "O obratach sfer niebieskich", "Mikołaj Kopernik", 1500),
            new Ksiazka(2, "Astrofizyka dla zabiegancyh", "Mikołaj Kopernik", 2018),
            new Ksiazka(5, "Stave Jobs", "Mikołaj Kopernik", 2017),
            new Ksiazka(4, "Podręcznik anatomii", "Mikołaj Kopernik", 1999),
            new Ksiazka(1, "Head first Java", "Mikołaj Kopernik", 2010)
    };

    public lab6() {
        //Zadanie 1
//        zad1();
        //Zadanie 2
//        zad2();
        //Zadanie 3
//        zad3();
        //Zadanie 4
//        zad4();
        //Zadanie 5
//        zad5();
        //Zadanie 6
        zad6();
    }

    public static void main(String[] args) {
        new lab6();
    }

    class Dane {
        String nazwa;
        String dane;

        public Dane(String nazwa, String dane){
            this.nazwa = nazwa;
            this.dane = dane;
        }

        @Override
        public String toString() {
            return nazwa + ": " + dane;
        }
    }

    public void zad1() {
        Dane dane = new Dane("Telefon Samsung", "352 532 534");
        System.out.println(dane.toString());
    }

    class Dane2 implements Comparable<Dane2> {
        String nazwa;
        String dane;

        public Dane2(String nazwa, String dane){
            this.nazwa = nazwa;
            this.dane = dane;
        }

        @Override
        public String toString() {
            return nazwa + ": " + dane;
        }

        @Override
        public int compareTo(Dane2 o) {
            return this.nazwa.compareTo(o.nazwa);
        }
    }

    public void zad2() {
        Arrays.sort(dane2s);

        for (int i = 0; i < dane2s.length; i++) System.out.println(dane2s[i].toString());

    }

    public Dane2[] sortR(Dane2[] d) {
        Arrays.sort(d);
        Dane2[] nd = new Dane2[d.length];
        for (int i = 0, j = d.length-1; i < d.length; i++, j--) {
            nd[i] = d[j];
        }
        return nd;
    }

    public void zad3() {
        Dane2[] d = sortR(dane2s);
        for (int i = 0; i < d.length; i++) System.out.println(d[i].toString());
    }

    static class Pracownik implements Comparable<Pracownik> {
        private int id;
        private String nazwisko;
        private String stanowisko;

        @Override
        public int compareTo(Pracownik d) {
            if(stanowisko == d.stanowisko)
                return this.nazwisko.compareTo(d.nazwisko);
            else
                return this.stanowisko.compareTo(d.stanowisko);
        }

        @Override
        public String toString() {
            return id + " - " + nazwisko + " - " + stanowisko;
        }

        public Pracownik(int id, String nazwisko, String stanowisko) {
            this.id = id;
            this.nazwisko = nazwisko;
            this.stanowisko = stanowisko;
        }
    }

    public void zad4() {
        Arrays.sort(pracownicy);
        for(int i = 0; i < pracownicy.length; i++) System.out.println(pracownicy[i].toString());
    }

    class Ksiazka implements Comparable<Ksiazka> {
        private int id;
        private String nazwa;
        private String autor;
        private int rokWydania;

        public Ksiazka(int id, String nazwa, String autor, int rokWydania) {
            this.id = id;
            this.nazwa = nazwa;
            this.autor = autor;
            this.rokWydania = rokWydania;
        }

        @Override
        public int compareTo(Ksiazka o) {
            return this.nazwa.compareTo(o.nazwa);
        }

        @Override
        public String toString() {
            return "Ksiazka{" +
                    "id=" + id +
                    ", nazwa='" + nazwa + '\'' +
                    ", autor='" + autor + '\'' +
                    ", rokWydania=" + rokWydania +
                    '}';
        }
    }

    public void zad6() {
        Arrays.sort(ksiazki);

        for (Ksiazka ksiazka : ksiazki) System.out.println(ksiazka.toString());
    }
}
