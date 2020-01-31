
package inputOutput;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import algoritmsAndDatastructures.Node;
import algoritmsAndDatastructures.Stack;

/**
 * A class for reading and writing mazes
 * Also, this creates the graphs that the algorithms traverse
 * 
 * @author Simon
 */
public class MazeFactory {
    private String baseURL = "./";
    
    // Constructor
    public MazeFactory() {}
    
    /**
     * Creates a graph of the available paths in the maze
     * Each space in the graph is not represented by a node
     * 
     * @return Node; The first node is the starting point of the graph
     */
    public Node createMazeGraph() {
        BufferedImage mazeImage = loadMaze("smallmaze.bmp");
        Stack helper = new Stack();

        int width = mazeImage.getWidth();
        int height = mazeImage.getHeight();
        Node start;
        
        for(int col = 0; col < height; col++) {
            for(int row = 0; row < width; row++) {
                // Starting node, first white on top row
                if(col == 0 && isPath(mazeImage, row, col)) {
                    start = new Node(true, false, row, col);
                    helper.push(start);
                // Goal node, first white on bottom row
                } else if(col == height-1 && isPath(mazeImage, row, col)) {
                    Node end = new Node(false, true, row, col);
                    helper.push(end);
                }
            }
        }

        return new Node(false, false, 0, 0);
    }
    
    private boolean isPath(BufferedImage image, int x, int y) {
        return image.getRGB(x, y) == -1;
    }

    
    /**
     * Draws an ASCII version of the maze to print in console
     *
     * @return String; An ASCII string representation of the maze
     */
    public String drawASCIIMaze() {
        BufferedImage mazeImage = loadMaze("smallmaze.bmp");
        String mazeAscii = "";
        int width = mazeImage.getWidth();
        int height = mazeImage.getHeight();
        
        for(int col = 0; col < height; col++) {
            for(int row = 0; row < width; row++) {
                mazeAscii = mazeAscii.concat(determineSign(mazeImage, row, col));
            }
            // Start on new row
            mazeAscii = mazeAscii.concat("\n");
        }
        return mazeAscii;
    }
    
    private String determineSign(BufferedImage mazeImage, int x, int y) {
        // This is the starting space
        if(isPath(mazeImage, x, y) && y == 0) {
            return "@";
        // It's the goal
        } else if (isPath(mazeImage, x, y) && y == mazeImage.getHeight()-1) {
            return "G";
        // Space is white/path
        } else if (isPath(mazeImage, x, y)) {
            return " ";
        // Space is black/wall
        } else {
            return "X";
        }
    }
    
    /**
     * Loads a specific file containing a maze from disk
     * 
     * @param filename the name of the .bmp file that is the maze
     * @return BufferedImage; The maze, or null if no maze was loaded
     */
    public BufferedImage loadMaze(String filename) {
        File mazeFile = new File(baseURL + filename);
        
        try {
            BufferedImage maze = ImageIO.read(mazeFile);
            System.out.println(">>>ImageREAD successful");
            return maze;
        } catch (IOException ioe) {
            System.out.println(">>>ImageREAD unsuccessful");
            ioe.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * This is for writing images to disk, solved mazes first-hand.
     * 
     * @param maze BufferedImage; The maze to be written
     * @param fname String; The desired name for the file on disk.
     * 
     * @return Boolean; Value depending on whether the write was successful or not
     */
    public boolean writeMaze(BufferedImage maze, String fname) {
        try {
            if (ImageIO.write(maze, "bmp", new File(baseURL + "./"+fname+".bmp"))) {
                System.out.println(">>>ImageWRITE successful");
                return true;
            }
        } catch (IOException ioe) {
            System.out.println(">>>ImageWRITE unsuccessful");
        }
        
        return false;
    }
}
