package egzamin;

import java.io.*;

public class Zadanie6 {

    public static void main(String[] args) {
        Ksiazka ksiazka = new Ksiazka("Miś uszatek", "Adam krzak", 1989);
        System.out.println(ksiazka);

        serialize(ksiazka, "ksiazka.ser");
        Ksiazka ksiazkaDes =  deserialize("ksiazka.ser");

        System.out.println(ksiazkaDes);
    }

    public static void serialize(Ksiazka ksiazka, String fN) {
        File file = new File(fN);
        try {
            ObjectOutputStream ks = new ObjectOutputStream(new FileOutputStream(file));
            System.out.println("Obiekt zapisany do " + file.getAbsolutePath());

            ks.writeObject(ksiazka);
            System.out.println(ksiazka);

        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Błąd");
        }
    }

    public static Ksiazka deserialize(String fN) {
        File file1 = new File(fN);
        Ksiazka ksiazka = null;
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(file1));
            ksiazka = (Ksiazka) is.readObject();
        } catch (IOException | ClassNotFoundException ex) {

        }
        return ksiazka;
    }
}

class Ksiazka implements Comparable<Ksiazka>, Serializable {
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
    public String toString() {
        return "Ksiazka{" +
                "tytul='" + tytul + '\'' +
                ", autor='" + autor + '\'' +
                ", rokWydania=" + rokWydania +
                '}';
    }

    @Override
    public int compareTo(Ksiazka o) {
        return this.getTytul().compareTo(o.getTytul());
    }

}
