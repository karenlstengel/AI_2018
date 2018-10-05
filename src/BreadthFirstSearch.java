/*
    @author Karen Stengel
    class to implement BFS on the maze

 */

import java.util.LinkedList;

public class BreadthFirstSearch implements IAlgorithm{
    @Override
    public void search(Maze maze){
        Node node = maze.getStart();
        boolean found = false;
        LinkedList<Node> frontier = new LinkedList<Node>();
        frontier.addFirst(node);

        //while node has children
        while(!node.getConnections().isEmpty()) {
            // for each child of node
                //if the child has been visited:
                    // if child cost < cost + 1
                    //don't change parent
                //else cost = cost(node) + 1
                    //set parent = node

                // check if they are the goal node.
                    //if they are goal; set found = true
                        // dont add child to queue
                    //else add child to queue and mark as visited.
            // remove node from queue
            // set fronteir.getfirst() as node
        }

    }
}