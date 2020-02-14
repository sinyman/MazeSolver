
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
    MazePos pos1 = new MazePos(0,0);
    MazePos pos2 = new MazePos(1,2);
    MazePos pos3 = new MazePos(3,4);
    
    @Before
    public void setup() {
        stack = new Stack();
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
    
    @Test
    public void peekWorks() {
        boolean rightElement = false;
        stack.push(pos1);
        stack.push(pos2);
        
        rightElement = stack.peek() == pos2;
        stack.pop();
        rightElement = stack.peek() == pos1;
        
        assertTrue(rightElement);
    }
    
    @Test
    public void stackExtendingWorks() {
        for(int i = 0; i < 15; i++) {
            stack.push(new MazePos(3,3));
        }
        
        assertTrue(stack.size() > 10);
    }
}
