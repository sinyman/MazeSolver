
package algoritmsAndDatastructures;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * A class for reading and writing mazes.
 * Also, this creates the graphs that the algorithms traverse.
 * @author Simon
 */
public class Maze {
    final private String baseURL = "./";
    final private BufferedImage mazeImage;
    private String[][] maze;
    private Position start;
    private int dimensionX;
    private int dimensionY;
    
    /**
     * Constructor.
     * @param mazeName String; The name of the .bmp file that contains the maze
     * (including .bmp-file extension)
     */
    public Maze(String mazeName) {
        mazeImage = loadMaze(mazeName);
        createMaze();
    }
    /**
     * Creates an ASCII graph of the available paths in the maze.
     */
    public void createMaze() {
        Stack helper = new Stack();
        this.dimensionX = mazeImage.getWidth();
        this.dimensionY = mazeImage.getHeight();
        maze = new String[dimensionX][dimensionY];
        
        for (int col = 0; col < dimensionY; col++) {
            for (int row = 0; row < dimensionX; row++) {
                maze[row][col] = determineSign(mazeImage, col, row);
            }
        }
    }
    /**
     * Method that checks whether the current pixel is a maze junction or not.
     * @param image BufferedImage; The maze
     * @param x int; The x position of the pixel
     * @param y int; The y position of the pixel
     * @return Boolean; Whether the pixel is a junction or not
     */
    private boolean isJunction(final BufferedImage image, final int x,
            final int y) {
        if(isPath(image, x, y)) {
            if (!isPath(image, x + 1, y) && !isPath(image, x - 1, y)) {
                return false;
            }
            if (!isPath(image, x, y + 1) && !isPath(image, x, y - 1)) {
                return false;
            }
        }

        return true;
    }
    /**
     * Method that checks whether a said pixel is part of the path and
     * not a wall.
     * @param image BufferedImage; The maze
     * @param x int; The x position of the pixel
     * @param y int; The y position of the pixel
     * @return Boolean; Whether the pixel is part of a path or not
     */
    private boolean isPath(final BufferedImage image, final int x,
            final int y) {
        try {
            return image.getRGB(x, y) == -1;
        } catch(ArrayIndexOutOfBoundsException e) {
            return false;
        }
        
    }
    /**
     * For determining what sign to draw for a specific pixel when creating
     * an ASCII maze.
     * @param mazeImage BufferedImage; The maze
     * @param x int; The x position of the pixel
     * @param y int; The y position of the pixel
     * @return String; The letter(string) to be drawn
     */
    private String determineSign(final BufferedImage mazeImage, final int x,
            final int y) {
        // This is the starting space
        if (isPath(mazeImage, x, y) && y == 0) {
            this.start = new Position(x, y);
            return "@";
        // It's the goal
        } else if (isPath(mazeImage, x, y) && y == mazeImage.getHeight() - 1) {
            return "G";
        // Space is a wall
        } else if (!isPath(mazeImage, x, y)) {
            return "X";
        // Space is a junction
        } else if (isJunction(mazeImage, x, y)) {
            return "+";
        // Space is path
        } else if (isPath(mazeImage, x, y)) {
            return " ";
        // Space is black/wall
        }  else {
            return "?";
        }
    }
    /**
     * Loads a specific file containing a maze from disk.
     * @param filename the name of the .bmp file that is the maze
     * @return BufferedImage; The maze, or null if no maze was loaded
     */
    private BufferedImage loadMaze(final String filename) {
        File mazeFile = new File(baseURL + filename);
        try {
            return ImageIO.read(mazeFile);
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }
    /**
     * This is for writing images to disk, solved mazes first-hand.
     * @param maze BufferedImage; The maze to be written
     * @param fname String; The desired name for the file on disk.
     * @return Boolean; Value depending on whether the write
     * was successful or not
     */
    public boolean writeMaze(final BufferedImage maze, final String fname) {
        try {
            if (ImageIO.write(maze, "bmp", new File(baseURL + fname
                    + ".bmp"))) {
                System.out.println(">>>ImageWRITE successful");
                return true;
            }
        } catch (IOException ioe) {
            System.out.println(">>>ImageWRITE unsuccessful");
        }
        return false;
    }
    
    /**
     * Returns a graphic representation of the maze.
     * @return String; A graphic representation of the maze in the form of a
     * string.
     */
    public String toString() {
        String toReturn = "";
        for(String[] array : maze) {
            for(String s : array) {
                toReturn = toReturn + s + " ";
            }
            toReturn = toReturn + "\n";
        }
        
        return toReturn;
    }

    public Position getStart() {
        return start;
    }

    public int getDimensionX() {
        return dimensionX;
    }

    public int getDimensionY() {
        return dimensionY;
    }

    public String[][] getMaze() {
        return maze;
    }
}
