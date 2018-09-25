import java.io.*;

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
            System.out.println(rows + ", " +  col);

            BufferedReader inMaze = new BufferedReader(new FileReader(file));
            int temp =0;
            mArray = new char[rows][col];
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < col; j++){
                    char c = (char)inMaze.read();
                    if(c != '\n') {
                        mArray[i][j] = c;
                        System.out.print(temp++ + " " + mArray[i][j]);
                    }
                }
                System.out.println();
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
    // by checking each possible movement (still waiting to see if diagonal movements are allowed) and adding possible
    // moves to the children lists. continue until every non % has been added

    //maze solution
    // backtrack the shortest (or one of) solution path and change that coordinate in the maze to a '.'

    //print maze
    // basic array print
    public void printMaze(){
        System.out.println(maze.length + ", " + maze[0].length);

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
}