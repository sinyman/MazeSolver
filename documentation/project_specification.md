# Project Specification
Because input will be in the form of strings in a JSON file, I feel that a command line interface
will be sufficient for operating the program.

## Datastructures used
As specified in the course details, I will only be using arrays, primitive types and strings.
With these I will create the data structures and/or algorithms I need.
These are:
  * Priority Queue
  * Graph for mapping routes in the maze
      * Implemented as a Node-object with references to next and previous Node objects
  * A* algorithm for finding path through maze
  
## Why did I choose these?
In addition to arrays, primitives and strings, a priority queue is necessary in order to implement A*. After reading the ASCII maze from a JSON file, the program will generate a graph that later is traversed in 

## Problems to solve
* Finding a path from start to end in maze
* Creating a graph of nodes from the ASCII data
* Implementing A*
* Showing the found route in the terminal window in a clear manner
   * Alternatively displaying that no route was found
* Handling a situation where no route is found

## Program I/O
### Input:
A JSON file in the same directory as the program is run from either:
* Project root
* The folder in which a possible .jar-file is run from
 
### Output:
The original maze with a route mapped out on it in the terminal window

## Expected time and space complexities
### Time complexity
* Reading the file and constructing a graph
  * Parsing through the string line by line, character by character and creating the graph should be O(n)
* Traversing the graph with A* looking for a path is average case O(n log n)
