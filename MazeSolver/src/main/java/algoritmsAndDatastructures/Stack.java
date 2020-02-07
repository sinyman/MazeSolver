
package algoritmsAndDatastructures;

/**
 * Classic Stack data structure.
 * @author Simon
 */
public class Stack {
    private Position[] stack;
    private int top;
    
    /**
     * <b>Constructor</b>
     * Initializes a new Stack-object with 10 empty spots
    */
    public Stack() {
        this.stack = new Position[10];
        top = -1;
    }
    
    /**
     * <b>Push a new object into the stack</b>
     * @param newPos The position to be added to the stack
     * @return Boolean value based on whether the action was successful or not
     */
    public boolean push(final Position newPos) {
        boolean con = true;
        while(con) {
            try {
                top++;
                stack[top] = newPos;
                
                // Stops the looping after stack has been extended
                con = false;
            } catch(ArrayIndexOutOfBoundsException e) {
                // Reverts stack top index change after insertion failed
                // to avoid leaving an empty index between the old and 'new' stack
                top--;
                extendStack(10);
            }
        }
        return true;
    }
    
    /**
     * <b>Removes the topmost node and returns it</b>
     * @return Position, null if stack is empty
     */
    public Position pop() {
        Position toReturn = stack[top];
        stack[top] = null;
        // Resetting top index to new top
        top--;
        return toReturn;
    }
    
    /**
     * <b>Check the object at the top of the stack</b>
     * @return Position, null if stack is empty
     */
    public Position peek() {
        return stack[top];
    }
    
    /**
     * <b>Returns the amount of elements in stack</b>
     * @return int; The amount of objects in stack
     */
    public int size() {
        // Returns top+1 because stack indices start from 0
        return top + 1;
    }
    
    /**
     * <b>Checks if the stack is empty</b>
     * @return Boolean
     */
    public boolean isEmpty() {
        return top < 0;
    }
    
    private void extendStack(int amount) {
        Position[] newStack = new Position[stack.length + amount];
        for (int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }
        this.stack = newStack;
    }
}
