
package algoritmsAndDatastructures;

/**
 * A class for keeping track of positions in the maze more easily. Should work
 * like a Pair-object. This class exists just to keep the path stack in the
 * algorithms more logical and "clean".
 * @author Simon Nyman
 */
public class Position {
    int xCord;
    int yCord;
    
    /**
     * Constructor.
     * 
     * @param x int; The x-position of the element
     * @param y int; The y-position of the element 
     */
    public Position(int x, int y) {
        this.xCord = x;
        this.yCord = y;
    }

    public int getX() {
        return xCord;
    }

    public int getY() {
        return yCord;
    }
}
