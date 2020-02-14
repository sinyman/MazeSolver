
package algoritmsAndDatastructures;

/**
 * Wallfollower algorithm for maze solving.
 * @author Simon
 */
public class Wallfollower {
    /*
    * Keeps track of where we are headed
    * 0 = down
    * 1 = left
    * 2 = up
    * 3 = right
    */
    private int direction = 0;
    
    /**
     * Solve a said maze.
     * @param maze Node; The maze as an array of strings.
     * @return Stack<Position>; A stack of containing objects of the paths to
     * the exit.
     */
    public Stack solve(Maze maze) {
        Stack route = new Stack();
        int startX = maze.getStart().getX();
        
       return traverseRightHand(maze.getMaze(), startX, 0, route); 
    }
    
    private Stack traverseRightHand(String[][] maze, int x, int y, Stack route) {
        route.push(new MazePos(x, y));
        if(maze[x][y] == "G") {
            return route;
        }
        if(isFree(maze, x - 1, y)) {
            traverseRightHand(maze, x - 1, y, route);
        } else if (isFree(maze,x, y + 1)) {
            traverseRightHand(maze, x, y + 1, route);
        } else if (isFree(maze, x + 1, y)) {
            traverseRightHand(maze, x + 1, y, route);
        } else {
            return route;
        }
        
        return route;
    }  
    
    private Stack traverseLeftHand(String[][] maze, int x, int y, Stack route) {
        route.push(new MazePos(x, y));
        if(maze[x][y] == "G") {
            return route;
        }
        if(isFree(maze, x + 1, y)) {
            traverseLeftHand(maze, x + 1, y, route);
        } else if (isFree(maze,x, y + 1)) {
            traverseLeftHand(maze, x, y + 1, route);
        } else if (isFree(maze, x - 1, y)) {
            traverseLeftHand(maze, x - 1, y, route);
        } else {
            return route;
        }
        
        return route;
    }
    
    private boolean isFree(String[][] maze, int x, int y) {
        return (maze[x][y].equals(" ") ||  maze[x][y].equals("+"));
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    
}
