
import static org.junit.Assert.assertTrue;
import org.junit.*;
import algoritmsAndDatastructures.Stack;
import algoritmsAndDatastructures.MazePos;

/**
 * Class that contains the tests for the Stack data structure.
 * @author Simon Nyman
 */
public class StackTest {
    Stack stack;
    MazePos pos1;
    MazePos pos2;
    MazePos pos3;
    
    @Before
    public void setup() {
        stack = new Stack();
        pos1 = new MazePos(0,0);
        pos2 = new MazePos(1,2);
        pos3 = new MazePos(3,4);
    }

    @Test
    public void initialStackisEmpty1() {
        assertTrue(stack.size() == 0);
    }
    
    @Test
    public void initialStackisEmpty2() {
        assertTrue(stack.isEmpty());
    }
    
    @Test
    public void insertionWorks() {
        final int SIZE_BEFORE = stack.size();
        
        stack.push(pos1);
        
        assertTrue(SIZE_BEFORE + 1 == stack.size()
                    && stack.pop() == pos1
                );
    }
}
