package minesweeper;


public class Pane {
    
    private int x; 
    private int y;
    private boolean mine;
    private int value;
    
    public Pane(int x, int y, boolean mine) {
        
        this.x = x;
        this.y = y;
        this.mine = mine;
        this.value = 99;
        
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
    
}
