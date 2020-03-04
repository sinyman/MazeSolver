
package mazesolver.sinyman.mazesolver;

import algoritmsAndDatastructures.Maze;
import algoritmsAndDatastructures.Wallfollower;
import algoritmsAndDatastructures.Tremaux;
import algoritmsAndDatastructures.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Simon
 */
public class MazeSolver {
    
    Maze mf;
    
    public static void main(String[] args) {
        System.out.println("---Welcome to MazeSolver---\n");
        Maze mf = new Maze("smallmaze.bmp");
        
        boolean con = true;
        String input;
        while (con) {
            System.out.println(""
                + "*******************************************\n"
                + "*  Available actions                      *\n"
                + "*  1. Load a maze                         *\n"
                + "*  2. Print loaded maze                   *\n"
                + "*  3. Solve with Wallfollower(Right hand) *\n"
                + "*  4. Solve with Wallfollower(Left hand)  *\n"
                + "*  5. Solve with Trémaux                  *\n"
                + "*  6. Exit                                *\n"
                + "*******************************************\n");
            System.out.println("What would you like to do?");
            input = takeInput();
            
            switch (input) {
                case "1":
                    //System.out.println("Name of maze file (including .bmp)");
                    System.out.println("Unavailable at the moment, only for use with small maze");
                    break;
                case "2":
                    System.out.println("Printing maze!");
                    System.out.println(mf);
                    break;
                case "3":
                    Stack stack = Wallfollower.solve(mf, 0);
                    System.out.println("Path length: "+stack.size());
                    break;
                case "4":
                    Stack stack2 = Wallfollower.solve(mf, 1);
                    System.out.println("Path length: "+stack2.size());
                    break;
                case "5":
                    break;
                case "6":
                    System.out.println("Exiting!");
                    con = false;
                    break;
                default: System.out.println("Please input according to actions");
            }
        }
    }
    
    private static String takeInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {System.out.print(": ");
            input = br.readLine();
        } catch (IOException ioe) {
            System.out.println("There was an error reading the input, please try again");
        }
        
        return input;
    }
    
    private boolean handleInput(String input, Maze mf) {
        

        return true;
    }
}
