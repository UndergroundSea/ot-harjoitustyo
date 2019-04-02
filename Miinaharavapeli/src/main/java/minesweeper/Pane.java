package minesweeper;

import javafx.scene.control.Button;


public class Pane {
    
    private int x; 
    private int y;
    private boolean mine;
    private int value;
    private Button button;
    private boolean turned;
    
    public Pane(int x, int y, Button button) {
        
        this.x = x;
        this.y = y;
        this.mine = false;
        this.value = 99;
        this.button = button;
        this.turned = false;
        
    }
    
    public void setValue(int v) {
        this.value = v;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public boolean getMine() {
        return this.mine;
    }
    
    public void setMine(boolean mine) {
        this.mine = mine;
    }
    
    public void turn() {
        this.turned = true;
    }
    
   
    
}
