package lab14;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Lab14 {

    public static void main(String[] args) {
        new Lab14();
    }

    public Lab14() {
        //Zadanie 1
//        zad1();
        //Zadanie 2
//        zad2();
        //Zadanie 3
//        zad3();
        //Zadanie 4
        zad4();
    }

    private void zad1() {
        JFrame jFrame = new JFrame();
        JPanel jPanel = new JPanel();
        JLabel jLabel = new JLabel("Hello World");

        jPanel.add(jLabel);
        jFrame.add(jPanel);

        jFrame.setSize(300, 300);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    class Panel extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D graphics2D = (Graphics2D) g;
            Rectangle2D rectangle2D = new Rectangle2D.Double(100, 100, 200, 150);

            Ellipse2D ellipse2D = new Ellipse2D.Double();
            ellipse2D.setFrame(rectangle2D);

            Line2D line2D = new Line2D.Double(100, 100, 300, 250);

            Ellipse2D circle2D = new Ellipse2D.Double();
            circle2D.setFrameFromCenter(rectangle2D.getCenterX(), rectangle2D.getCenterY(), rectangle2D.getCenterX() + 150, rectangle2D.getCenterY() + 150);

            graphics2D.draw(rectangle2D);
            graphics2D.draw(ellipse2D);
            graphics2D.draw(circle2D);
            graphics2D.draw(line2D);
        }
    }

    private void zad2() {
        JFrame jFrame = new JFrame();
        Panel panel = new Panel();

        panel.setBackground(Color.yellow);
        jFrame.add(panel);

        jFrame.setSize(400, 400);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    class Panel2 extends JPanel {
        private final Image img;

        public Panel2() {
            img = Toolkit.getDefaultToolkit().getImage("D:\\CodeProjects\\sping_intelij\\lab1\\src\\lab14\\obrazek.png");

            MediaTracker mediaTracker = new MediaTracker(this);
            mediaTracker.addImage(img,0);

            try {
                mediaTracker.waitForID(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void paint(Graphics graphics) {
            super.paint(graphics);

            int width = this.img.getWidth(this);
            int height = this.img.getHeight(this);

            graphics.drawImage(this.img, 0, 0, null);

            for (int i = 0; i * width <= this.getWidth(); i++) {
                for (int j = 0; j * height <= this.getHeight(); j++) {
                    if (i + j > 0) {
                        graphics.copyArea(0, 0, width, height, i * width, j * height);
                    }
                }
            }
        }
    }

    private void zad3() {
        JFrame jFrame = new JFrame();
        Panel2 panel = new Panel2();

        panel.setBackground(Color.yellow);
        jFrame.add(panel);

        jFrame.setSize(500, 500);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    static class TicTacToe {
        private java.util.List<JButton> buttons = new ArrayList<>();
        private static final JFrame jFrame = new JFrame();
        private String currentC = "X";

        private TicTacToe() {
            GridLayout gridLayout = new GridLayout(3, 3);
            jFrame.setLayout(gridLayout);
            for (int i = 0; i < 9; i++) {
                JButton jButton = new JButton(".");
                addActionListener(jButton);
                buttons.add(jButton);
                jFrame.add(jButton);
            }

            jFrame.setSize(300, 300);
            jFrame.setResizable(false);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setVisible(true);
        }

        private void addActionListener(JButton jButton) {
            jButton.addActionListener(e -> {
                JButton button = (JButton) e.getSource();

                button.setEnabled(false);
                button.setText(currentC);
                if (currentC.equals("X")) {
                    currentC = "O";
                } else {
                    currentC = "X";
                }

                this.checkIfWon();
            });
        }

        private void checkIfWon() {
            String text = buttons.get(0).getText();
            if (!text.equals(".") && text.equals(buttons.get(3).getText()) && text.equals(buttons.get(6).getText()))
                this.win(text);
            if (!text.equals(".") && text.equals(buttons.get(1).getText()) && text.equals(buttons.get(2).getText()))
                this.win(text);
            if (!text.equals(".") && text.equals(buttons.get(4).getText()) && text.equals(buttons.get(8).getText()))
                this.win(text);

            text = buttons.get(1).getText();
            if (!text.equals(".") && text.equals(buttons.get(4).getText()) && text.equals(buttons.get(7).getText()))
                this.win(text);

            text = buttons.get(2).getText();
            if (!text.equals(".") && text.equals(buttons.get(5).getText()) && text.equals(buttons.get(8).getText()))
                this.win(text);
            if (!text.equals(".") && text.equals(buttons.get(4).getText()) && text.equals(buttons.get(6).getText()))
                this.win(text);

            text = buttons.get(3).getText();
            if (!text.equals(".") && text.equals(buttons.get(4).getText()) && text.equals(buttons.get(5).getText()))
                this.win(text);

            text = buttons.get(6).getText();
            if (!text.equals(".") && text.equals(buttons.get(7).getText()) && text.equals(buttons.get(8).getText()))
                this.win(text);
        }

        private void win(String text) {
            JOptionPane.showMessageDialog(jFrame, "Wygrany: " + text);
            for (int i = 0; i < buttons.size(); i++) {
                buttons.get(i).setText(".");
                buttons.get(i).setEnabled(true);
            }
        }
    }

    private void zad4() {
        TicTacToe newGame = new TicTacToe();
    }
}
