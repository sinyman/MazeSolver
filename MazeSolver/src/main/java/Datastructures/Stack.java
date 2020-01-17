
package Datastructures;

/**
 *
 * @author Simon
 */
public class Stack {
    Node[] stack;
    int top;
    
    /**
     * <b>Constructor</b>
     * Initializes a new Stack-object with 10 empty spots
    */
    public Stack() {
        // OBS OBS OBS 'Set init array size to 10' OBS OBS OBS
        this.stack = new Node[0];
        top = -1;
    }
    
    /**
     * <b>Push a new object into the stack</b>
     * 
     * @param newNode The node to be added to the stack
     * @return Boolean value based on whether the action was successful or not
     */
    public boolean push(Node newNode) {
        
        boolean con = true;
        while(con) {
            try {
                top++;
                stack[top] = newNode;
                
                // Stops the looping after stack has been extended
                con = false;
            } catch(ArrayIndexOutOfBoundsException e) {
                // Reverts stack top index change after insertion failed
                // to avoid leaving an empty index between the old and 'new' stack
                top--;
                extendStack();
            }
        }
        return true;
    }
    
    /**
     * <b>Removes the topmost node and returns it</b>
     * 
     * @return Node, null if stack is empty
     */
    public Node pop() {
        Node toReturn = stack[top];
        stack[top] = null;
        // Resetting top index to new top
        top--;
        return toReturn;
    }
    
    /**
     * <b>Check the object at the top of the stack</b>
     * 
     * @return Node, null if stack is empty
     */
    public Node peek() {
        return stack[top];
    }
    
    /**
     * <b>Returns the amount of elements in stack</b>
     * 
     * @return int
     */
    public int size() {
        // Returns top+1 because stack indices start from 0
        return top + 1;
    }
    
    /**
     * <b>Checks if the stack is empty</b>
     * 
     * @return Boolean
     */
    public boolean isEmpty() {
        return top < 0;
    }
    
    private void extendStack() {
        Node[] newStack = new Node[stack.length + 10];
        for(int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }
        this.stack = newStack;
    }
}
