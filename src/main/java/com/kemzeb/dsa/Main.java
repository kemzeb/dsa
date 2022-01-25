package com.kemzeb.dsa;

public class Main {
    // TODO: Move the testing logic into their own test cases    
    public static void main(String[] args) {
        DirectedAcyclicGraph graph = new DirectedAcyclicGraph(4);
        
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        
        System.out.println("BFS method call");
        graph.BFS(2);

        System.out.println("DFS method call");
        graph.DFS(2);
    }
}
