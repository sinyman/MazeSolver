
package algoritmsAndDatastructures;

/**
 * Trémaux algorithm for solving mazes.
 * @author Simon Nyman
 */
public class Tremaux {
    
    private String[][] maze;
    /* 
        Directional variables for determining movement direction in maze.
        Initial direction is down
    */
    private int dirX = 0;
    private int dirY = 1;
    
    /**
     * Solve a said maze.
     * @param maze Maze-object; The maze to solve
     */
    public void solve(Maze maze) {
        this.maze = maze.getMaze();
        int startX = maze.getStart().getX();
        
        traverse(startX,0);
        
    }
    
    /**
     * Recursive function that traverses the maze and performs the necessary 
     * actions for the Trémaux algorithm.
     * @param x int; x-coordinate of the position in the maze
     * @param y int; y-coordinate of the position in the maze 
     */
    private void traverse(int x, int y) {
        // Standing on goal space
        if(isGoal(x, y)) {
            drawRoute();
            
        } else {
            // Is a junction
            if (maze[x][y].equals("+")) {
                /*
                Because the use of Math.random is prohibited and where you go
                doesn't really make a difference for the execution of the
                algorithm, I will be choosing path in a junction clockwise.
                */
                if(!isVisited(x+1, y) || isGoal(x+1, y)) {
                    setMovementDirection("right");
                    traverse(x + dirX, y + dirY);
                }
                if (!isVisited(x, y+1) || isGoal(x, y+1)) {
                    setMovementDirection("down");
                    traverse(x + dirX, y + dirY);
                }
                if (!isVisited(x-1, y) || isGoal(x-1, y)) {
                    setMovementDirection("left");
                    traverse(x + dirX, y + dirY);
                }
                if (!isVisited(x, y-1) || isGoal(x, y-1)) {
                    setMovementDirection("up");
                    traverse(x + dirX, y + dirY);
                }
                
            } else {
                //Move forward to next junction marking each space
                maze[x][y] = "1";
                traverse(x + dirX, y + dirY);
            }
            /*
                If everything around you is visited or a wall, backtrack until
                you find somewhere to go. At the same time mark every space
                that lead to the dead end.
            */
            maze[x][y] = "2";
        }
        
    }
    
    private void drawRoute() {
        
    }
        
    private boolean isGoal(int x, int y) {
        return maze[x][y].equals("G");
    }
    
    private boolean isVisited(int x, int y) {
        return !maze[x][y].equals(" ");
    }
    
    private void setMovementDirection(String dir) {
        switch (dir) {
            case "left": dirX = -1; dirY = 0;
                        break;
            case "up": dirX = 0; dirY = -1;
                        break;
            case "right": dirX = 1; dirY = 0;
                        break;
            case "down": dirX = 0; dirY = 1;
                        break;
        }
    }
}
