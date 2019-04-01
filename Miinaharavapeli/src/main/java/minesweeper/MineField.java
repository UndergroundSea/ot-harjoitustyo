package minesweeper;

public class MineField {
    
    private Pane[][] grid;
    private boolean alive;
    
    public MineField(int x, int y) {
        
        this.grid = new Pane[x][y];
        this.alive = true;
        
    }
    
    public void setPane(Pane pane, int x, int y) {
        grid[x][y] = pane; 
    }
    
    public void countValue(Pane pane) {
        int x = pane.getX();
        int y = pane.getY();
        int mines = 0;
        
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                
                if (x < 0 || y < 0 || x > 9 || y > 4) {
                    continue;
                }
                
                if (grid[i][j].getMine()) {
                    mines++;
                }
                
            }
        }
        
        grid[x][y].setValue(mines);
        
    }
    
}
