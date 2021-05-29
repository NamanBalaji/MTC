package CtCi.Trees_and_Graphs;
import java.util.*;

public class GraphNode {
    public int data;
    public boolean visited;
    private ArrayList<GraphNode> neighbors;
    
    public GraphNode(int data) {
    	this.data = data;
    	visited  = false;
    	this.neighbors = new ArrayList<GraphNode>();
    }
    
    public void visit() {
        visited = true;
    }

    public ArrayList<GraphNode> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(GraphNode neighbor) {
        neighbors.add(neighbor);
        neighbor.neighbors.add(this);
    }

    public void addDirectedNeighbor(GraphNode neighbor) {
        neighbors.add(neighbor);
    }
}
