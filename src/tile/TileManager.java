package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    Tile[] tile = new Tile[10];
    GamePanel gp;
    int[][] mapData;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        mapData=new int[gp.maxworldrows][gp.maxworldcols];
        new Thread(() -> getTileImage()).start();
        new Thread(() ->  loadMap()).start();
    }

   public void getTileImage() {
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

   public void loadMap() {
        try {
        InputStream mapInputStream = getClass().getClassLoader().getResourceAsStream("maps/world01.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(mapInputStream));
       int rows = 0;
        int cols = 0;
            while (rows < gp.maxworldcols && cols < gp.maxworldrows) {
               String line = br.readLine();
                while (cols < gp.maxworldcols) {
                    String[] numbers = line.split(" ");
                    mapData[rows][cols] = Integer.parseInt(numbers[cols]);
                    cols++;
                }
                rows++;
                cols=0;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g2) {
        int num=mapData[40][40];
        g2.drawImage(tile[num].images, 0, 0, gp.tileSize, gp.tileSize, null);
    }
}
