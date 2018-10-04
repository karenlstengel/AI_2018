/*
    @authors Karen Stengel, Jared Thompson, Tim Wells
    Project for using search algorithms to solve a maze.
 */
public class Main{
    public static void main(String args[]){

        Maze test = new Maze("src/testMaze.txt");
        test.printMaze();

        test.buildGraph();
        test.setSearch(new AStar());
        test.search.search(test.getStart());
        //test.setSolution();
        System.out.println("solved Maze: ");
        test.printMaze();
        
    }
}