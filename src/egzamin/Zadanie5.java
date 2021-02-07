package egzamin;

public class Zadanie5 {
    public static void main(String[] args) {
        Punkt2D punkt2D = new Punkt2D();
        Punkt2D punkt2Dv2 = new Punkt2D();

        Punkt2DKolor punkt2DKolor = new Punkt2DKolor();
        Punkt2DKolor punkt2DKolorv2 = new Punkt2DKolor();
    }

    static class Punkt2D {
        private int x;
        private int y;

        public Punkt2D(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Punkt2D() {}
    }

    static class Punkt2DKolor extends Punkt2D {

        public Punkt2DKolor(int x, int y) {
            super(x, y);
        }

        public Punkt2DKolor() {}
    }
}

//Odpowiedz: Do poprawnego działania oby klas niezbędne są konstruktory domyślne oraz parametryczne.
