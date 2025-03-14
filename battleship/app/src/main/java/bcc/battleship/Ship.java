package bcc.battleship;

public class Ship {
    private int row;
    private int col;
    private int length;
    private int direction;

    // Constructor. Create a ship and set the length.
    public Ship(int length) {
        this.length = length;
        this.row = Constants.UNSET;  // Initially, the row is unset.
        this.col = Constants.UNSET;  // Initially, the column is unset.
        this.direction = Constants.UNSET;  // Initially, the direction is unset.
    }

    // Has the location been initialized? 
    // Checks if the ship's location (row and column) is set.
    public boolean isLocationSet() {
        return row != Constants.UNSET && col != Constants.UNSET;
    }

    // Has the direction been initialized? 
    // Checks if the ship's direction has been set (either horizontal or vertical).
    public boolean isDirectionSet() {
        return direction != Constants.UNSET;
    }

    // Set the location of the ship (row and column) and the direction.
    public void setLocation(int row, int col) {
        this.row = row;
        this.col = col;
        this.direction = Constants.HORIZONTAL;
    }

    // Set the direction of the ship (horizontal or vertical).
    // This method is separate from the location to change direction without changing location.
    public void setDirection(int direction) {
        this.direction = direction;
    }

    // Getter for the row value (where the ship is placed on the grid).
    public int getRow() {
        return row;
    }

    // Check if the ship is oriented vertically.
    public boolean isVertical() {
        return direction == Constants.VERTICAL; // Ensure `vertical` is a boolean in Ship
    }

    // Getter for the column value (where the ship is placed on the grid).
    public int getCol() {
        return col;
    }

    // Getter for the length of the ship (how many grid spaces it occupies).
    public int getLength() {
        return length;
    }

    // Getter for the direction of the ship (horizontal or vertical).
    public int getDirection() {
        return direction;
    }

    // Helper method to convert the direction to a string representation.
    // Converts the ship's direction (horizontal or vertical) to a readable string.
    private String directionToString() {
        switch (direction) {
            case Constants.HORIZONTAL:
                return "horizontal";
            case Constants.VERTICAL:
                return "vertical";
            default:
                return "unset direction"; // Default case when the direction is unset
        }
    }

    // Helper method to get the (row, col) string value for the ship's location.
    // Returns a formatted string with the ship's current position.
    private String locationToString() {
        if (isLocationSet()) {
            return "(" + row + ", " + col + ")"; // Location is set
        } else {
            return "(unset location)"; // Location is not set
        }
    }

    // toString method to return a string representation of the ship.
    // Returns a full description of the ship, including its direction, length, and location.
    @Override
    public String toString() {
        return directionToString() + " ship of length " + length + " at " + locationToString();
    }
}