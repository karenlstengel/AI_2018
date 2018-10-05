/*
    @author Karen Stengel
    class to implement BFS on the maze

 */

public class BreadthFirstSearch implements IAlgorithm{
    @Override
    public void search(Maze maze){
        Node start = maze.getStart();
        boolean found = false;

        //while node != goal && node has children
            // for each child of node that hasn't been visited
                // check if they are the goal node.
                // cost = cost(node) + 1
                    //if they are goal; set parent = node and set found = true
                    //else add child to queue and mark as visited.
    }
}