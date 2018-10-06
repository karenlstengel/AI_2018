/*
    @author Karen Stengel
    class to implement BFS on the maze

 */

import java.util.LinkedList;

public class BreadthFirstSearch implements IAlgorithm{
    @Override
    public void search(Maze maze){
        System.out.println("BFS");
        Node node = maze.getStart();
        Node goal = maze.getGoal();
        boolean found = false;
        LinkedList<Node> frontier = new LinkedList<Node>();  //using as queue implementation
        frontier.addFirst(node);
        int expanded = 0;

        //while node has children
        while(!frontier.isEmpty()) {
            // for each child of node
            node = frontier.removeFirst();
            expanded++;
            System.out.println("expanded: " + expanded);

            for(int i = 0; i < node.getConnections().size(); i++) {

                    //if the child has been visited:
                    // if child cost < cost + 1
                    //don't change parent
                    //else cost = cost(node) + 1
                    //set parent = node
                    if (node.getConnections().get(i).getVisited() && (node.getConnections().get(i).getCost() < (node.getCost() + 1))) {

                        node.getConnections().get(i).setCost(node.getCost() + 1);
                        node.getConnections().get(i).addParent(node);


                    } else {
                        node.getConnections().get(i).setCost(node.getCost() + 1);
                        node.getConnections().get(i).addParent(node);
                    }
                    System.out.println(node.getConnections().get(i).getParent());

                    // check if they are the goal node.
                    //if they are goal; set found = true
                    // dont add child to queue
                    //else add child to queue and mark as visited.
                    if (node.getConnections().get(i) == goal) {
                        found = true;
                    }
                    if (!node.getConnections().get(i).getVisited()) {
                        frontier.addLast(node.getConnections().get(i));
                        node.getConnections().get(i).setVisited();
                    }

            }
            System.out.println(frontier.size());

        }
            maze.setSolution();
            System.out.println("Solved Maze (Breadth First Search): ");
            System.out.println("Nodes expanded: " + expanded);
            System.out.println("Path weight: " + maze.getGoal().getCost());
            maze.printMaze();

    }
}