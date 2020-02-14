
package algoritmsAndDatastructures;

/**
 * Wallfollower algorithm for maze solving.
 * @author Simon Nyman
 */
public class Wallfollower {
    
    /**
     * Solve a said maze.
     * @param maze Node; The maze as an array of strings.
     * @param choice int; Which version to use; 0 = right-hand, 1 = left-hand.
     * @return Stack<MazePos>; A stack of containing objects of the paths to
     * the exit.
     */
    public Stack solve(Maze maze, int choice) {
        Stack route = new Stack();
        int startX = maze.getStart().getX();
        
        if (choice == 0) {
            return traverseRightHand(maze.getMaze(), startX, 0, route);
        }
        
       return traverseLeftHand(maze.getMaze(), startX, 0, route); 
    }
    
    private Stack traverseRightHand(String[][] maze, int x, int y, Stack route) {
        route.push(new MazePos(x, y));
        if(maze[x][y].equals("G")) {
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
        if(maze[x][y].equals("G")) {
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
    
}
