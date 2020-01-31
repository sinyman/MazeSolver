
package mazesolver.sinyman.mazesolver;

import inputOutput.MazeFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Simon
 */
public class MazeSolver {
    public static void main(String[] args) {
        System.out.println("---Welcome to MazeSolver---\n");
        MazeFactory mf = new MazeFactory();
        /*
        boolean con = true;
        String input = "";
        while (con) {
            System.out.println(""
                + "***********************************\n"
                + "*  Available actions              *\n"
                + "*  1. Load a maze                 *\n"
                + "*  2. Print loaded maze           *\n"
                + "*  3. Exit                        *\n"
                + "***********************************\n");

            input = takeInput();
            switch (input) {
                case "1":
                    System.out.println("Loading maze!");
                    break;
                case "2":
                    System.out.println("Printing maze!");
                    break;
                case "3":
                    System.out.println("Exiting!");
                    con = false;
                    break;
                default: System.out.println("Please input according to actions");
            }        
        }
        */
    }
    
    private static String takeInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = br.readLine();
        } catch (IOException ioe) {
            System.out.println("There was an error reading the input, please try again");
        }
        
        return input;
    }
}
