package CtCi.Trees_and_Graphs;
import java.util.*;

public class BuildOrder {
	public static List<Integer> buildOrder(int[][] processes) {
		// temp marks to check for cycles
		Set<Integer> tempMarks = new HashSet<Integer>();
		// perm marks to check for already visited processes
		Set<Integer> permMarks = new HashSet<Integer>();
		// order
		List<Integer> result = new LinkedList<Integer>();
		
		for (int i=0;  i< processes.length; i++) {
			if (!permMarks.contains(i)) {
				visit(i, processes, tempMarks, permMarks, result);
			}
		}
		
		return result;
	}
	
	public static void visit(int process, int[][] processes, Set<Integer> tempMarks, Set<Integer> permMarks, List<Integer> result) {
		// if cycle exist raise an error
		if (tempMarks.contains(process)) {
			throw new RuntimeException();
		}
		
		if (!permMarks.contains(process)) {
			tempMarks.add(process);
			for (int i : processes[process]) {
				visit(i, processes, tempMarks, permMarks, result);
			}
		}
		tempMarks.remove(process);
		permMarks.add(process);
		result.add(process);
	}
	
	public static void main(String[] args) {
		int[][] processes = {
				{},
				{0},
				{0},
				{1, 2},
				{3}	
		};
		
		List<Integer> order = buildOrder(processes);
		for (int i : order) {
			System.out.println(i + "\n");
		}
	}
}
