package minesweeper;

public class MineField {
    
    private Pane[][] grid;
    private boolean alive;
    private int turnedPanes;
    
    public MineField(int x, int y) {
        
        this.grid = new Pane[x][y];
        this.alive = true;
        this.turnedPanes = 0;
        
    }
    
    public void setPane(Pane pane, int x, int y) {
        grid[x][y] = pane; 
    }
    
    public void endGame() {
        this.alive = false;
    }
    
    public boolean getAlive() {
        return this.alive;
    }
    
    public int countValue(Pane pane) {
        int x = pane.getX();
        int y = pane.getY();
        int mines = 0;
        
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                
                if (i < 0 || j < 0 || i > 9 || j > 4) {
                    continue;
                }
                
                if (grid[i][j].getMine()) {
                    mines++;
                }
                
            }
        }
        
        return mines;
//        grid[x][y].setValue(mines);
        
    }
    
    public void turnPane() {
        this.turnedPanes++;
    }
    
    public int getTurnedPanes() {
        return this.turnedPanes;
    }
    
}
