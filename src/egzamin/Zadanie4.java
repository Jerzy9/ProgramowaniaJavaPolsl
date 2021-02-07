package egzamin;

import java.util.Arrays;

public class Zadanie4 {

    public static void main(String[] args) {
        Ksiazka[] ksiazki = new Ksiazka[3];

        ksiazki[0] = new Ksiazka("Miś uszatek", "Adam krzak", 1989);
        ksiazki[1] = new Ksiazka("świnka peppa", "Marcin Brzechw", 1999);
        ksiazki[2] = new Ksiazka("Kubuś puchatek", "Izabella Goal", 2000);

        Arrays.sort(ksiazki);

        for (Ksiazka ksiazka: ksiazki) {
            System.out.println(ksiazka.toString());
        }
    }

    static class Ksiazka implements Comparable<Ksiazka>{
        private String tytul;
        private String autor;
        private int rokWydania;

        public Ksiazka(String tytul, String autor, int rokWydania) {
            this.tytul = tytul;
            this.autor = autor;
            this.rokWydania = rokWydania;
        }

        public String getTytul() {
            return tytul;
        }

        @Override
        public int compareTo(Ksiazka o) {
            return this.getTytul().compareTo(o.getTytul());
        }

        @Override
        public String toString() {
            return "Ksiazka{" +
                    "tytul='" + tytul + '\'' +
                    ", autor='" + autor + '\'' +
                    ", rokWydania=" + rokWydania +
                    '}';
        }
    }

}
