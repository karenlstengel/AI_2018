import java.io.*;

public class Maze{
    private Node[][] maze;
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
    public Node[][] readMazeFile(File file){
        Node[][] mArray = null;
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

            mArray = new Node[rows][col];

            for(int i = 0; i < rows; i++){
                String inLine = inMaze.readLine();
                for(int j = 0; j < inLine.length(); j++) {
                    char c = inLine.charAt(j);
                    mArray[i][j] = new Node(i,j,c);
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
    //create a temporary 2d array of same size as maze. create a new node for each index with the x,y coords and the symbol.
    // THEN, start at the beginning of the graph create the search space graph
    // by checking each possible movement, 3 remaining directions excluding the parent,  and adding possible
    // moves to the children lists. continue until every non % has been added  (should have a skeleton form of the maze
    public void buildGraph(){ //leave parent as null until search/solution is done
        //want to ignore the boundaries
        for(int i = 1; i < maze.length - 1; i++){
            for(int j = 1; j < maze[0].length - 1; j++){
                //if getSymbol == ' '
                if(maze[i][j].getSymbol() == ' '){
                    //set connections
                    if(maze[i - 1][j].getSymbol() != '%'){
                        //set connections
                        if(!maze[i][j].getConnections().contains(maze[i-1][j])){
                            //add next node to i,j's children list
                            maze[i][j].addChild(maze[i-1][j]);
                        }
                        if(!maze[i-1][j].getConnections().contains(maze[i][j])){
                            //add next node to i,j's children list
                            maze[i-1][j].addChild(maze[i][j]);
                        }
                    }
                    if(maze[i + 1][j].getSymbol() != '%'){
                        //set connections
                    }
                    if(maze[i][j - 1].getSymbol() != '%'){
                        //set connections
                    }
                    if(maze[i][j + 1].getSymbol() != '%'){
                        //set connections
                    }
                }
                //elseif getSymbol == '*'
                else if( maze[i][j].getSymbol() == '*'){
                    // set connections and set as goal node
                    goal = maze[i][j];
                }
                //elseif getSymbol == 'P'
                else if(maze[i][j].getSymbol() == 'P'){
                    //set connections and set as start node
                    start = maze[i][j];
                }
                //else (getSymbol) == ' '
                else{
                    // do nothing; remove. just for visualization
                }
            }
        }
    }

    //maze solution
    // backtrack the final solution path and change those coordinate in the maze to a '.'
    public void setSolution(){
        Node n = goal;
        while(n != start){
            Node next = n.getParent();
            maze[next.getX()][next.getY()].setSymbol('.');
            n = next;
        }
    }

    //print maze
    // basic array print
    public void printMaze(){

        for(int i = 0; i <maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                System.out.print(maze[i][j].getSymbol());
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