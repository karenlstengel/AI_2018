import java.util.*;

import static java.lang.Thread.sleep;

public class AStar implements IAlgorithm{
    @Override
    public void search(Maze maze) {
        int expanded = 0;
        Stack<Node> frontier = new Stack<Node>(); //initialize a stack of nodes and push the start node onto it
        maze.getStart().setVisited();
        frontier.push(maze.getStart());
        while(!frontier.empty() && frontier.peek() != maze.getGoal()) //iterate through until there are no more nodes left unexpanded
        {
            Node current = frontier.pop();
            expanded++;
            ArrayList<Node> children = current.getConnections();
            for(int i = 0; i < children.size(); i++)
            {
                if(children.get(i) != current) {
                    if (children.get(i).getVisited()) {
                        if (g(children.get(i)) > g(current) + 1) {
                            children.get(i).addParent(current);
                        }
                    }
                        else {
                        children.get(i).setVisited();
                        children.get(i).addParent(current);
                        insertNode(frontier, children.get(i), maze.getGoal());
                    }
                }
            }
        }
        maze.setSolution();
        System.out.println("Solved Maze (A*): ");
        System.out.println("Nodes expanded: " + expanded);
        System.out.println("Path weight: " + g(maze.getGoal()));
        maze.printMaze();
    }
    public void insertNode(Stack<Node> frontier, Node inNode, Node goal){
        if(frontier.empty())
        {
            frontier.push(inNode);
        }
        else {
            Stack<Node> temp = new Stack<Node>();
            while(!frontier.empty() && f(frontier.peek(), goal) <= f(inNode, goal)) {
                temp.push(frontier.pop());
            }
            frontier.push(inNode);
            while(!temp.empty()) {
                frontier.push(temp.pop());
            }
        }
    }
    public int f(Node inNode, Node goal){
        int x1 = inNode.getX();
        int y1 = inNode.getY();
        int x2 = goal.getX();
        int y2 = goal.getY();
        return g(inNode) + Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    public int g(Node inNode) {
        int g = 0;
        Node temp = inNode;
        while(temp.getParent() != null)
        {
            g++;
            temp = temp.getParent();
        }
        return g;
    }
}