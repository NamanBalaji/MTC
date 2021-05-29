package CtCi.Trees_and_Graphs;
import java.util.*;
public class RoutesBetweenNodes {
	public static boolean routeExists(GraphNode start, GraphNode end) {
		if (start == end) {
			return true;
		}
		Deque<GraphNode> deque = new ArrayDeque<>();
		start.visit();
		deque.add(start);
		
		while(!deque.isEmpty()) {
			GraphNode curr = deque.remove();
			if (curr == end) {
				return true;
			}
			for (GraphNode neighbor : curr.getNeighbors()) {
				if (!neighbor.visited) {
					neighbor.visit();
					deque.add(neighbor);				
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		GraphNode node1 = new GraphNode(1);
        node1.addNeighbor(new GraphNode(3));
        node1.addNeighbor(new GraphNode(4));
        GraphNode node2 = new GraphNode(2);
        node2.addNeighbor(new GraphNode(5));
        node2.addNeighbor(new GraphNode(6));
        Graph.connectNodes(node1, node2);
        System.out.println(routeExists(node1, node2));
	}
}
