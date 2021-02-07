package kolos2;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kolokwium2 {

    public static void main(String[] args) {
        new Kolokwium2();
    }

    public Kolokwium2() {
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

    }

    static class Algorytm {

        static public double skalar(double[] tab1, double[] tab2) {
            double s = 0;
            int len = tab1.length;

            if (tab1.length == tab2.length)
                for (int i = 0; i < len ; i++) {
                    s += tab1[i] * tab2[i];
                }

            return s;
        }

    }

    private void zad1() {
        double[] tab1 = {1,2,3}, tab2 = {3,2,1};
        double skalar = Algorytm.skalar(tab1, tab2);
        System.out.println(skalar);
    }

    static class Algorytm2 {

        static public void sortowanie(List<Double> tab) {
            for (int i = 1; i < tab.size(); i++) {
                int j = i - 1;
                double key = tab.get(i);

                while (j >= 0 && tab.get(j) > key) {
                    tab.set(j+1, tab.get(j));
                    j--;
                }

                tab.set(j + 1, key);
            }
        }
    }

    private void zad2() {
        Scanner in;
        List<Double> list = new ArrayList<>();
        try {
            File file = new File("kolos2\\zad2in.txt");
             in = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("Nie znaleziono pliku");
            return;
        }

        while (in.hasNextDouble()) {
            list.add(in.nextDouble());
        }

        System.out.println(list);
        Algorytm2.sortowanie(list);
        System.out.println(list);

    }

    class Frame3 extends JFrame {
        private int WIDTH = 400, HEIGHT = 300;
        private JLabel label;
        private JButton btn;
        private JLabel label2;
        private JLabel label3;

        private void setFrame() {
            setTitle("Zadanie 3");
            setLocation(800, 300);
            setSize(WIDTH, HEIGHT);
            setResizable(false);
            setFocusable(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }

        public Frame3() {
            label = new JLabel();
            btn = new JButton();
            label2 = new JLabel();
            label3 = new JLabel();

            label.setText("Obliczone wartości to:");
            btn.setText("Podaj wartości");
            btn.addActionListener(evt -> btnClicked());

            GroupLayout layout = new GroupLayout(getContentPane());

            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(155, 155, 155)
                                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                            .addComponent(btn)
                                                            .addComponent(label)))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(155, 155, 155)
                                                    .addComponent(label2))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(155, 155, 155)
                                                    .addComponent(label3)))
                                    .addContainerGap(150, WIDTH))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(btn)
                                    .addGap(15, 15, 15)
                                    .addComponent(label)
                                    .addGap(15, 15, 15)
                                    .addComponent(label2)
                                    .addGap(15, 15, 15)
                                    .addComponent(label3)
                                    .addContainerGap(150, WIDTH))
            );
            getContentPane().setLayout(layout);

            setFrame();
        }

        private void btnClicked() {
            String  rs = JOptionPane.showInputDialog("Podaj promień:");
            String  hs = JOptionPane.showInputDialog("Podaj wysokość:");
            double r, h;
            double v, p;

            try {
                r =  Double.parseDouble(rs);
                h = Double.parseDouble(hs);

                if (r <= 0 || h <= 0) throw new Exception();

                v = v(r, h);
                p = p(r, h);
                label2.setText("v: " + v);
                label3.setText("p: " + p);

            } catch (Exception ex) {
                System.out.println("Błędna wartość");
                label2.setText("Błędna wartość");
                label3.setText("");
            }
        }

        private double v(double r,double h) {
            return Math.PI * r * r * h;
        }

        private double p(double r, double h) {
            return (2 * Math.PI * r * r) +  (2 * Math.PI * r * h);
        }
    }

    private void zad3() {
        SwingUtilities.invokeLater(Frame3::new);
    }

    class Punkt2D {
        protected int x;
        protected int y;

        public Punkt2D(int x, int y) {
            this.x = x;
            this.y = y;
            System.out.println("2D parametryczny");
        }

        public Punkt2D() {
            System.out.println("2D domyślny");
        }

        @Override
        public String toString() {
            return "Punkt2D{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    class Punkt3D extends Punkt2D {
        int z;

        public Punkt3D() {
            System.out.println("3D domyślny");
        }
        public Punkt3D(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
            System.out.println("3D parametryczny");
        }

        @Override
        public String toString() {
            return "Punkt3D{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }
    }

    //Odpowiedz:
    //W języku Java wywołanie kontruktora klasy nadrzędnej zawsze musi się odbyć, niezależnie od parametrów

    private void zad4() {
        System.out.println("Test 2D:");
        Punkt2D p2 = new Punkt2D(1, 2);

        System.out.println();

        System.out.println("Test 3D:");
        Punkt3D p3 = new Punkt3D(1, 2, 3);

    }

    class Punkt3DKolor extends Punkt3D {

        public Punkt3DKolor(int r, int g, int b) {
            super();
            if (isValid(r) && isValid(g) && isValid(b)) {
                this.x = r;
                this.y = g;
                this.z = b;
            }
        }

        public Punkt3DKolor() {}

        private boolean isValid(int i) {
            return i >= 0 && i <= 255;
        }

        public int getR() {
            return this.x;
        }

        public int getG() {
            return this.y;
        }

        public int getB() {
            return this.z;
        }

        public void setR(int x) {
            if (isValid(x)) this.x = x;
        }

        public void setG(int y) {
            if (isValid(y)) this.y = y;
        }

        public void setB(int z) {
            if (isValid(z)) this.z = z;
        }

        @Override
        public String toString() {
            return "Punkt3DKolor{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }
    }

    private void zad5() {
        Punkt3DKolor punkt3Dkolor = new Punkt3DKolor(-1, -3, -2);

        System.out.println(punkt3Dkolor.toString());

        punkt3Dkolor.setR(33);
        punkt3Dkolor.setG(44);
        punkt3Dkolor.setB(55);

        System.out.println(punkt3Dkolor.toString());

        punkt3Dkolor.setR(0);
        punkt3Dkolor.setG(-5);
        punkt3Dkolor.setB(333);

        System.out.println(punkt3Dkolor.toString());
    }
}
