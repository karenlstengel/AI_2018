public class Maze{
    private char[][] maze;
    private Node start;
    private Node goal;
    private IAlgorithm search;

    //constructor.
    // read in file and save to the maze array. if the char == P, create a new node for start

    //build maze.
    // start at the location of the start node previously saved and then create the search space graph
    // by checking each possible movement (still waiting to see if diagonal movements are allowed) and adding possible
    // moves to the children lists. continue until every non % has been added

    //maze solution
    // backtrack the shortest (or one of) solution path and change that coordinate in the maze to a '.'

    //print maze
    // basic array print
    public void printMaze(int[][] array){

        for(int i = 0; i <array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    //set search type
    // change search var to whichever search is desired
    public void setSearch(IAlgorithm s){
        search = s;
    }
}