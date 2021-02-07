package egzamin;

import java.awt.*;
import javax.swing.*;


public class Zadanie3 {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new img());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setResizable(false);
        frame.setVisible(true);
    }


    static class img extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.yellow);
            g.fillRect(0, 0, 300, 300);
            g.setColor(Color.black);
            g.drawRect(30,30,200,200);
            g.drawLine(30,30,230,230);
            g.drawLine(230,30,30,230);
        }
    }

}
