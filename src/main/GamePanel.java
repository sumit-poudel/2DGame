package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    final int fps = 60;
    final int scale = 3;
    final int orignalTileSize = 16;
    final public int tileSize = orignalTileSize * scale;
    final public int maxRows = 12;
    final public int maxCols = 16;
    final public int screenWidth = maxCols * tileSize;
    final public int screenHeight = maxRows * tileSize;
    final public int maxworldrows=50;
    final public int maxworldcols=50;
    Thread gameThread;
    final long second=1000000000;

    Keys kh=new Keys();
    Player player=new Player(kh,this);
    TileManager tileManager=new TileManager(this);

    GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true); //game panel will reaceive keyboard inputs
        this.requestFocus();
    }

    void startThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        final double givenTime = (double) second / fps;
        double initialTime = System.nanoTime();
        double delta = 0;

        while (gameThread != null) {
            double currentTime = System.nanoTime();
            delta += (currentTime - initialTime) / givenTime;
            if (delta >= 1) {
                delta=0;
                Update();
                repaint();

            }
            initialTime=currentTime;
        }
    }
    public void Update(){
    player.Update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D) g;
        tileManager.draw(g2);
        player.draw(g2);
        g2.dispose();
    }
}
