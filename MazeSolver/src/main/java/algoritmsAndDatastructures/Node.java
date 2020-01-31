
package algoritmsAndDatastructures;

/**
 * The graph will be built as a network of nodes connected to eachother
 * 
 * @author Simon
 */

public class Node {
    private boolean isStart;
    private boolean isGoal;
    private boolean visited;
    
    private Node up;
    private Node down;
    private Node left;
    private Node right;
    private Node previous;
    
    private int[] pos = new int[2];
    
    /**
     * Constructor 
     * @param start Boolean; Is this the start node?
     * @param goal Boolean; Is this the goal node?
     */
    public Node (boolean start, boolean goal, int x, int y) {
        //isStart
        pos[0] = x;
        pos[1] = y;
        visited = false;
    }
    
    public int getX() {
        return pos[0];
    }

    public int getY() {
        return pos[1];
    }
    
    public boolean isIsStart() {
        return isStart;
    }

    public boolean isIsGoal() {
        return isGoal;
    }
    
    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int[] getPos() {
        return pos;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

    public Node getUp() {
        return up;
    }

    public void setUp(Node up) {
        this.up = up;
    }

    public Node getDown() {
        return down;
    }

    public void setDown(Node down) {
        this.down = down;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    
}
