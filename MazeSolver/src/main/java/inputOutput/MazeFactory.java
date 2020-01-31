
package inputOutput;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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
     * Loads a specific file containing a maze from disk
     * 
     * @param filename the name of the .bmp file that is the maze
     * @return BufferedImage the maze, or null if no maze was loaded
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
