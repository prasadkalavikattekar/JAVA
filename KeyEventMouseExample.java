// /program to demonstrate key and mouse event./


import java.awt.event.*;
import javax.swing.*;

public class KeyEventMouseExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Key and Mouse Event Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel keyLabel = new JLabel("Key Pressed: ");
        JLabel mouseLabel = new JLabel("Mouse Event: ");

        frame.add(panel);
        panel.add(keyLabel);
        panel.add(mouseLabel);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                keyLabel.setText("Key Pressed: " + e.getKeyChar());
            }
        });

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseLabel.setText("Mouse Event: Clicked at (" + e.getX() + ", " + e.getY() + ")");
            }
        });

        frame.setFocusable(true);
        frame.requestFocusInWindow();
        frame.setVisible(true);
    }
}