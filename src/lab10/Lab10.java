package lab10;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Lab10 {

    public static void main(String[] args) {
        new Lab10();
    }

    public Lab10() {
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

    class Frame extends JFrame {

        private int WIDTH = 400, HEIGHT = 300;
        private JLabel label;
        private JButton btn;
        private JLabel label2;

        private void setFrame() {
            setTitle("Zadanie 1");
            setLocation(800, 300);
            setSize(WIDTH, HEIGHT);
            setResizable(false);
            setFocusable(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }

        public Frame() {
            label = new JLabel();
            btn = new JButton();
            label2 = new JLabel();

            label.setText("Konrad Zbylut");
            btn.setText("Click me!");
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
                    .addGap(170, 170, 170)
                    .addComponent(label2)))
                    .addContainerGap(150, WIDTH))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label)
                            .addGap(10, 10, 10)
                            .addComponent(btn)
                            .addGap(18, 18, 18)
                            .addComponent(label2)
                            .addContainerGap(150, WIDTH))
            );
            getContentPane().setLayout(layout);
            setFrame();
        }

        private void btnClicked() {
            String  s = JOptionPane.showInputDialog("Wpisz tekst:");
            label2.setText(s);
        }
    }

    private void zad1() {
        SwingUtilities.invokeLater(Frame::new);
    }

    class Frame2 extends JFrame {
        private int WIDTH = 400, HEIGHT = 300;
        private JLabel label;
        private JButton btn;
        private JLabel label2;

        private void setFrame() {
            setTitle("Zadanie 2");
            setLocation(800, 300);
            setSize(WIDTH, HEIGHT);
            setResizable(false);
            setFocusable(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }

        public Frame2() {
            label = new JLabel();
            btn = new JButton();
            label2 = new JLabel();

            label.setText("Objętość koła to:");
            btn.setText("Podaj wartość");
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
                            .addGap(170, 170, 170)
                            .addComponent(label2)))
                            .addContainerGap(150, WIDTH))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btn)
                            .addGap(10, 10, 10)
                            .addComponent(label)
                            .addGap(18, 18, 18)
                            .addComponent(label2)
                            .addContainerGap(150, WIDTH))
            );
            getContentPane().setLayout(layout);

            setFrame();
        }

        private void btnClicked() {
            String  s = JOptionPane.showInputDialog("Podaj promień:");
            double r;
            double v;

            try {
                r = Double.parseDouble(s);
                v = v(r);
                label2.setText("" + v);

            } catch (Exception ex) {
                System.out.println("Błędna wartość");
                label2.setText("Błędna wartość");
                btnClicked();
            }
        }

        private double v(double r) {
            double v;
            v = (4.0/3.0) * Math.PI * r * r * r;
            return v;
        }
    }

    public void zad2() {
        SwingUtilities.invokeLater(Frame2::new);
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

                v = v(r, h);
                p = p(r, h);
                label2.setText("v: " + v);
                label3.setText("p: " + p);

            } catch (Exception ex) {
                System.out.println("Błędna wartość");
                label2.setText("Błędna wartość");
                label3.setText("Błędna wartość");
                btnClicked();
            }
        }

        private double v(double r,double h) {
            double v;
            v = (1.0/3.0) * Math.PI * r * r * h;
            return v;
        }

        private double p(double r, double h) {
            double p;
            double l = Math.sqrt((h*h) + (r*r));
            p = (Math.PI * r * r) + (Math.PI * r * l);
            return p;
        }
    }

    public void zad3() {
        SwingUtilities.invokeLater(Frame3::new);
    }

    class Frame4 extends JFrame {
        private int WIDTH = 400, HEIGHT = 300;
        private JLabel label;
        private JButton btn;
        private JLabel label2, label3;

        private void setFrame() {
            setTitle("Zadanie 4");
            setLocation(800, 300);
            setSize(WIDTH, HEIGHT);
            setResizable(false);
            setFocusable(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }

        public Frame4() {
            label = new JLabel();
            btn = new JButton();
            label2 = new JLabel();
            label3 = new JLabel();

            label.setText("Twoje znaki to:");
            btn.setText("Rozpocznij");
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
        String toPrint = "";

        private void btnClicked() {
            String type = "";
            boolean isNumber = false;
            String  s = JOptionPane.showInputDialog("Podaj znak:");
            toPrint += s;

            label2.setText(toPrint);
            try {
                Double.parseDouble(s);
                isNumber = true;
            } catch (Exception ex){
                isNumber = false;
            }

            if(isNumber) type = "liczba";
            else if(s.equals(" ")) type = "odstęp";
            else if(s.equals(",") || s.equals(".")) type = "interpunkcja";
            else type = "litera";

            label3.setText("ostatni znak to:  " + type);
        }

    }

    public void zad4() {
        SwingUtilities.invokeLater(Frame4::new);
    }

    class Frame5 extends JFrame {
        private int WIDTH = 400, HEIGHT = 300;
        private JLabel label;
        private JButton btn;
        private JTextField label2;

        private void setFrame() {
            setTitle("Zadanie 5");
            setLocation(800, 300);
            setSize(WIDTH, HEIGHT);
            setResizable(false);
            setFocusable(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }

        public Frame5() {
            label = new JLabel();
            btn = new JButton();
            label2 = new JTextField();

            label.setText("");
            btn.setText("Print");
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
                                                    .addGap(10, 10, 10)
                                                    .addComponent(label2)))
                                    .addContainerGap(250, WIDTH))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(btn)
                                    .addGap(10, 10, 10)
                                    .addComponent(label)
                                    .addGap(18, 18, 18)
                                    .addComponent(label2)
                                    .addContainerGap(250, WIDTH))
            );
            getContentPane().setLayout(layout);

            setFrame();
        }

        private void btnClicked() {
           printNumbers();
        }

        private void printNumbers() {
            List<Integer> pier = new ArrayList<>();
            boolean isPrime = true;

            for (int i = 1; i < 1000; i ++) {
                for (int j = 2; j < i - 1; j ++ ) {
                    if(i % j == 0)  {
                        isPrime = false;
                        break;
                    }

                }
                if(isPrime) pier.add(i);
                isPrime = true;
            }
            label2.setText("" + pier);
        }
    }

    public void zad5() {
        SwingUtilities.invokeLater(Frame5::new);
    }
}
