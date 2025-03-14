package bcc.battleship;

import bcc.battleship.Constants;

public class Grid {
    private Location[][] grid;
    private final int rows = Constants.GRID_SIZE;
    private final int cols = Constants.GRID_SIZE;

    
    // Create a new Grid and initialize each Location.
    public Grid() {
        grid = new Location[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Location();
            }
        }
    }

    
    // Mark a hit in the specified location.
    public void markHit(int row, int col) {
        grid[row][col].setStatus(Location.HIT);
       
    }
    
    // Mark a miss in the specified location.
    public void markMiss(int row, int col) {
        grid[row][col].setStatus(Location.MISS);

    }
    
    // Set the status of the Location at (row, col).
    public void setStatus(int row, int col, int status) {
        grid[row][col].setStatus(status);

    }
    
    // Get the status of the Location at (row, col).
    public int getStatus(int row, int col) {
        return grid[row][col].getStatus();
    }
    
    // Return whether this Location has already been guessed.
    public boolean alreadyGuessed(int row, int col) {
        int status = grid[row][col].getStatus();
        return status == Location.HIT || status == Location.MISS;
    }
    
    // Set whether there is a ship at this location.
    public void setShip(int row, int col, boolean val) {
        grid[row][col].setShip(val);
    }
    
    // Return whether there is a ship at this location.
    public boolean hasShip(int row, int col) {
        return grid[row][col].hasShip();
    }
    
    // Get the Location object at this row and column.
    public Location get(int row, int col) {
        return grid[row][col];
    }
    
    // Return the number of rows.
    public int numRows() {
        return rows;
    }
    
    // Return the number of columns.
    public int numCols() {
        return cols;
    }
    

    //maybe convert to boolean?
    public boolean addShip(Ship s) {
        int row = s.getRow();
        int col = s.getCol();
        int length = s.getLength();
        boolean isVertical = s.isVertical();
        if (isVertical) {
            if (row + length > rows) return false;
            for (int i = 0; i < length; i++) {
                if (hasShip(row + i, col)) return false;
            }
            for (int i = 0; i < length; i++) {
                setShip(row + i, col, true);
            }
        } else {
            if (col + length > cols) return false;
            for (int i = 0; i < length; i++) {
                if (hasShip(row, col + i)) return false;
            }
            for (int i = 0; i < length; i++) {
                setShip(row, col + i, true);
            }
        }
        return true;
    }

    public boolean allShipsSank(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasShip(i, j) && getStatus(i, j) != Location.HIT) {
                    return false;
                }
            }
        }
        return true;
    }
}
