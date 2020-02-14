
import org.junit.Test;
import static org.junit.Assert.*;
import algoritmsAndDatastructures.Maze;
/**
 * Class that contains the tests for the Maze I/O.
 * @author Simon Nyman
 */
public class MazeTest {
    Maze maze = new Maze("smallmaze.bmp");
    
    @Test
    public void mazeInitializationWorks() {
        assertTrue(maze != null);
    }
    
    @Test
    public void printingMazeWorks() {
        final String EXPECTED_MAZE = "X X X X X @ X X X X X\n" +
                                     "X +       +       + X\n" +
                                     "X   X X X X X X X   X\n" +
                                     "X +       + X +   + X\n" +
                                     "X X X X X   X   X X X\n" +
                                     "X +       + X +   + X\n" +
                                     "X   X X X X X X X   X\n" +
                                     "X   X     +     X   X\n" +
                                     "X   X X X   X X X   X\n" +
                                     "X +       + X     + X\n" +
                                     "X X X X X G X X X X X";
        assertEquals(EXPECTED_MAZE, maze.toString());
    }
}
