
public class Main{
    public static void main(String args[]){
        System.out.println("Welcome to Maze World!");

        Node hi = new Node(2,3, '*');
        System.out.println(hi.getSymbol());

        Maze test = new Maze("src/testMaze.txt");
        test.printMaze();

        test.buildGraph(test.getStart());
        //test.setSolution();
        System.out.println("solved Maze: ");
        test.printMaze();
        
    }
}