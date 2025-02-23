package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TileManager {
    Tile[] tile= new Tile[10];
    int[][] mapData;
    int rows, cols;
    String line;
    GamePanel gp;

    public TileManager(GamePanel gp) {
        this.gp = gp;
    new Thread(()->getTileImage()).start();
    }

    void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].images = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water.png"));
            tile[1] = new Tile();
            tile[1].images = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/grass.png"));
            tile[2] = new Tile();
            tile[2].images = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/sand.png"));
            tile[3] = new Tile();
            tile[3].images = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/tree.png"));
            tile[4] = new Tile();
            tile[4].images = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/wall.png"));
            tile[5] = new Tile();
            tile[5].images = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/earth.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void loadMap() {

    }

    public void draw(Graphics2D g2) {
       g2.drawImage(tile[4].images,0,0,gp.tileSize, gp.tileSize, null);
    }
}
