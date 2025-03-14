package bcc.battleship;

import bcc.battleship.Constants;

public class Player {
    private Ship[] ships;        // Array to store the ships for this player
    private Grid myGrid;         // The grid representing the player's own ships and opponent's guesses
    private Grid opponentGrid;   // The grid representing the player's guesses on the opponent's ships
  
    // Constructor: Initialize the grids and the ships.
    public Player() {
        myGrid = new Grid();   // Initialize the player's own grid
        opponentGrid = new Grid();  // Initialize the opponent's grid (for recording guesses)
        ships = new Ship[5];    // Array to hold 5 ships (as per the game rules)
        
        // Initialize ships with the given lengths from Constants.java
        ships[0] = new Ship(Constants.SHIP_LENGTHS[0]); // Length 2
        ships[1] = new Ship(Constants.SHIP_LENGTHS[1]); // Length 3
        ships[2] = new Ship(Constants.SHIP_LENGTHS[1]); // Length 3
        ships[3] = new Ship(Constants.SHIP_LENGTHS[2]); // Length 4
        ships[4] = new Ship(Constants.SHIP_LENGTHS[3]); // Length 5
    }
    
    /**
     * This method is used to set a ship's location on the grid.
     * It sets the ship's row, column, and direction, then attempts to add it to the player's grid.
     * 
     * @param index The index of the ship in the array of ships.
     * @param row The row where the ship is to be placed.
     * @param col The column where the ship is to be placed.
     * @return true if the ship was successfully added to the grid, false otherwise.
     */
    
     public boolean chooseShipLocation(int index, int row, int col, int direction) {
        if (index < 0 || index >= ships.length) {
            return false; // Invalid index
        }
    
        Ship ship = ships[index]; // Get the ship at the given index
        ship.setLocation(row, col); // Set the ship's location
        ship.setDirection(direction); // Set the direction of the ship
        
        // Attempt to add the ship to the grid. The grid should validate if the placement is valid.
        return myGrid.addShip(ship); // If the ship is successfully placed, return true; otherwise, return false
    }

    
    public boolean recordOpponentGuess(int row, int col) {
        if (myGrid.hasShip(row, col)) {  // If there is a ship at the given location
            myGrid.markHit(row, col);  // Mark the location as a hit on the player's grid
            return true;  // Return true because the guess was a hit
        } else {
            myGrid.markMiss(row, col);  // Mark the location as a miss on the player's grid
            return false;  // Return false because the guess was a miss
        }
    }
    
    /**
     * This method records the player's own guess on the opponent's grid.
     * It checks if the opponent has a ship at the guessed location. If there is a ship, it marks a hit.
     * If there is no ship, it marks a miss.
     * 
     * @param row The row where the player guessed.
     * @param col The column where the player guessed.
     * @return true if the player's guess was correct (hit), false if the guess was incorrect (miss).
     */
    public boolean recordMyGuess(int row, int col) {
        if (opponentGrid.hasShip(row, col)) {  // If there is a ship at the given location on the opponent's grid
            opponentGrid.markHit(row, col);  // Mark the location as a hit on the opponent's grid
            return true;  // Return true because the guess was a hit
        } else {
            opponentGrid.markMiss(row, col);  // Mark the location as a miss on the opponent's grid
            return false;  // Return false because the guess was a miss
        }
    }
    
    /**
     * Getter method for the player's own grid.
     * 
     * @return the player's grid.
     */
    public Grid getMyGrid() {
        return myGrid;
    }
    
    /**
     * Getter method for the opponent's grid.
     * 
     * @return the opponent's grid.
     */
    public Grid getOpponentGrid() {
        return opponentGrid;
    }
}