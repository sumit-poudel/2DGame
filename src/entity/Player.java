package entity;

import main.GamePanel;
import main.Keys;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {
    Keys kh;
    GamePanel gp;
    int spritCounter = 0;
    int spritCount = 0;

    public Player(Keys kh, GamePanel gp) {
        direction = "down";
        speed = 4;
        x = 100;
        y = 100;
        this.kh = kh;
        this.gp = gp;
        new Thread(this::getPlayerImage).start();
    }

    public void Update() {
        if (kh.down) {
            y += speed;
            direction = "down";
        }
        if (kh.up) {
            y -= speed;
            direction = "up";
        }
        if (kh.right) {
            x += speed;
            direction = "right";
        }
        if (kh.left) {
            x -= speed;
            direction = "left";
        }
        if (kh.left || kh.right || kh.up || kh.down)
            spritCounter++;
        if (spritCounter > 10) {
            if (spritCount == 0) {
                spritCount++;
            } else if (spritCount == 1) {
                spritCount--;
            }
            spritCounter = 0;
        }
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/boy_up_1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/boy_up_2.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/boy_down_1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/boy_down_2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/boy_left_1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/boy_left_2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/boy_right_1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/boy_right_2.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (direction) {
            case "down" -> {
                image = down1;
                if (spritCount == 1) {
                    image = down2;
                }
            }
            case "up" -> {
                image = up1;
                if (spritCount == 1) {
                    image = up2;
                }
            }
            case "left" -> {
                image = left1;
                if (spritCount == 1) {
                    image = left2;
                }
            }
            case "right" -> {
                image = right1;
                if (spritCount == 1) {
                    image = right2;
                }
            }
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
