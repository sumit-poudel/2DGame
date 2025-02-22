package main;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
    JFrame window=new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setVisible(true);
    window.setLocationRelativeTo(null);
    GamePanel gp=new GamePanel();
    window.add(gp);
    window.pack();
    gp.startThread();
    }
}
