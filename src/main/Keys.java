package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keys implements KeyListener {
public boolean up,down,left,right;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
       int keycode=e.getKeyCode();
        if(keycode==KeyEvent.VK_W){
            up=true;
        } if(keycode==KeyEvent.VK_S){
            down=true;
        } if(keycode==KeyEvent.VK_A){
            left=true;
        }
        if (keycode == KeyEvent.VK_D) {
            right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
  int keycode=e.getKeyCode();
        if(keycode==KeyEvent.VK_W){
            up=false;
        } if(keycode==KeyEvent.VK_S){
            down=false;
        } if(keycode==KeyEvent.VK_A){
            left=false;
        }
        if (keycode == KeyEvent.VK_D) {
            right = false;
        }
    }
}
