import java.util.ArrayList;

public class Node{
    private int x;
    private int y;
    private ArrayList<Node> children;
    private Boolean visited;
    private ArrayList<Node> parents;
    private char symbol;
    private int cost;

    //constructor
    public Node(int x, int y, char symbol){
        this.x = x;
        this.y = y;
        this.symbol = symbol;
        visited = false;
        cost = 0;
    }

    //set methods

    public void setVisited(){
        visited = true;
    }

    public void addChild(Node node){
        children.add(node);
    }

    public void setSymbol(char symbol){
        this.symbol = symbol;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    public void addParent(Node parent) {
        parents.add(parent);
    }

    //get methods
    public int getCost(){
        return cost;
    }

    public char getSymbol(){
        return symbol;
    }

    public Node getParent(int i) {
        return parents.get(i);
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }
}