import static org.junit.Assert.assertTrue;
import org.junit.*;
import algoritmsAndDatastructures.MazePos;

/**
 *
 * @author Simon Nyman
 */
public class MazePosTest {
    MazePos pos1 = new MazePos(0,0);
    MazePos pos2 = new MazePos(1,2);
    MazePos pos3 = new MazePos(3,4);

    @Test
    public void getXWorks() {
        assertTrue(pos1.getX() == 0
                && pos2.getX() == 1
                && pos3.getX() == 3
        );
    }
    
    @Test
        public void getYWorks() {
        assertTrue(pos1.getY() == 0
                && pos2.getY() == 2
                && pos3.getY() == 4
        );
    }
        
    @Test
    public void toStringTest() {
        assertTrue(pos1.toString().equals("(0,0)")
                && pos2.toString().equals("(1,2)")
                && pos3.toString().equals("(3,4)")
        );
    }
    
}
