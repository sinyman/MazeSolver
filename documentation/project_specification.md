# Project Specification
Because input will be in the form of ASCII-strings in a JSON file, I feel that a command line interface
will be sufficient for operating the program. If I have time at the end of the course I may implement a GUI for showing the path through the mazes.

## Datastructures used
As specified in the course details, I will only be using arrays, primitive types and strings.
With these I will create the data structures and/or algorithms I need.
These are:
  * Queue for BFS
  * Stack for DFS
  * Graph for mapping routes in the maze
      * Implemented as a Node-object with references to next and previous Node objects
  * BFS and DFS algorithms for finding path through graph
  * Wall follower(Right-hand, left-hand) algorithm
  
## Why did I choose these?
In addition to arrays, primitives and strings, a queue is necessary in order to implement BFS/DFS. After reading the ASCII maze from a JSON file, the program will generate a graph that can later be traversed with either BFS or DFS.

As for the wall follower algorithm, it will operate on a 2D-array representing the maze.

Why did I choose BFS, DFS and wallfollower? I feel that it would be interesting to see how they each perform in relation to each other depending on what the maze looks like.

## Problems to solve
* Finding a path from start to end in maze
* Creating a graph of nodes from the ASCII data
    * Maybe come up with a smarter way to create nodes instead of creating nodes for every step. For handling corridors?
* Implementing BFS, DFS, Wallfollower
* Showing the found route in the terminal window in a clear manner
   * Alternatively displaying that no route was found
* Handling a situation where no route is found

## Program I/O
### Input:
A JSON file(mazes.json) in the same directory as the program is run from either:
* Project root
* The folder in which a possible .jar-file is run from
 
### Output:
The original maze with a route mapped out on it in the terminal window

## Expected time and space complexities
### Time complexity
* Reading the file and constructing a graph
  * Parsing through the string line by line, character by character and creating the graph should be O(n)
* Traversing the graph with either BFS or DFS looking for a path is O(V+E), where V is the number of nodes/steps in the maze and E is the number of adjacent nodes from each node
* Wallfollower should run in polynomial time, that is O(n^k)

### Space complexity
* BFS/DFS is O(|V|), because you need to visit all nodes. This program however will terminate when ther first possible route is found.
* Wallfollower is constant O(1), as there is no other data structures needed other than the maze in order to traverse it.
