import java.io.*;
import java.util.ArrayList;

public class Maze{
    private char[][] maze;
    private Node start;
    private Node goal;
    private IAlgorithm search;

    //constructor.
    // read in file and save to the maze array. if the char == P, create a new node for start; if char ==*, create a goal node
    public Maze(String file){
        File mazeFile = new File(file);
        maze = readMazeFile(mazeFile);
    }

    //readMazeFile
    //read in the file using a scanner class instance.
    public char[][] readMazeFile(File file){
        char[][] mArray = null;
        try{
            BufferedReader in = new BufferedReader(new FileReader(file));

            int rows = 0;
            int col = 0;
            String line;
            while((line = in.readLine()) != null){
                rows++;
                col = line.length();
            }

            BufferedReader inMaze = new BufferedReader(new FileReader(file));

            mArray = new char[rows][col];

            for(int i = 0; i < rows; i++){
                String inLine = inMaze.readLine();
                for(int j = 0; j < inLine.length(); j++) {
                    char c = inLine.charAt(j);
                    mArray[i][j] = c;

                    if(c == 'P'){
                        start = new Node(i,j, c);
                    }
                    if(c == '*'){
                        goal = new Node(i,j,c);
                    }
                }
            }


        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mArray;
    }

    //build maze.
    // start at the location of the start node previously saved and then create the search space graph
    // by checking each possible movement, 3 remaining directions excluding the parent,  and adding possible
    // moves to the children lists. continue until every non % has been added
    public void buildGraph(Node n){
        //recursion?
    }

    //maze solution
    // backtrack the final solution path and change those coordinate in the maze to a '.'
    public void setSolution(){
        Node n = goal;
        while(n != start){
            Node next = n.getParent();
            maze[next.getX()][next.getY()] = '.';
            n = next;
        }
    }

    //print maze
    // basic array print
    public void printMaze(){

        for(int i = 0; i <maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    //set search type
    // change search var to whichever search is desired
    public void setSearch(IAlgorithm s){
        search = s;
    }
    public Node getStart(){
        return start;
    }
    public Node getGoal(){
        return goal;
    }
}