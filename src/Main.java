/*
    @authors Karen Stengel, Jared Thompson, Tim Wells
    Project for using search algorithms to solve a maze.
 */
public class Main{
    public static void main(String args[]){

        Maze test = new Maze("src/testMaze.txt");
        test.printMaze();

        test.buildGraph();
        test.setSearch(new BreadthFirstSearch());
        test.search.search(test);
        /*test.setSolution();

        Maze test2 = new Maze("src/largeMaze.txt");
        test2.buildGraph();
        test2.setSearch(new GreedyBestFirst());
        test2.search.search(test2);
         */
    }
}