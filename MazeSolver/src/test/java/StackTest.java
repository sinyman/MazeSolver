
import static org.junit.Assert.assertTrue;
import org.junit.*;
import algoritmsAndDatastructures.Stack;

/**
 * Class that contains the tests for the Stack data structure.
 * @author Simon Nyman
 */
public class StackTest {
    Stack stack;
    
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
        // TODO implement
    }
}
