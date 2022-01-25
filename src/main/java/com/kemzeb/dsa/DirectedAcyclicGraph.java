package com.kemzeb.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A non-generic graph data structure implementation that is
 * directed, acyclic, and utilzes adjacency lists. It also
 * implements the BFS and DFS transversal algorithms. Vertices are
 * represented as indices in the adjacency list.
 */
public class DirectedAcyclicGraph {
    private List<ArrayList<Integer>> adj;
    
    private DirectedAcyclicGraph() {}

    public DirectedAcyclicGraph(int V) {
        adj = new ArrayList<ArrayList<Integer>>(V);

        for(int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());
    }
    
    /**
     * Returns the number of vertices in the graph. Since the 
     * current implementation hides the adjacency list, the size 
     * will not change.
     */
    public int size() { return adj.size(); }
    
    /**
     * Adds a directed edge into the adjacency list.
     */
    public void addEdge(int fromVertex, int toVertex) {
        // TODO: throw execeptions if these branches become true
        if(fromVertex > this.size() || fromVertex < 0)
            return;
    
        // Ensure that we are push a vertex that is relevant
        if(toVertex > this.size() || toVertex < 0)
            return;

        adj.get(fromVertex).add(toVertex);
    }
    
    public void BFS(int root) {
        boolean[] visited = new boolean[this.size()];
        Queue<Integer> q = new LinkedList<>();

        visited[root] = true;
        q.add(root);
        
        while(!q.isEmpty()) {
            int vertex = q.poll();
            
            System.out.print(vertex + " ");
            
            for(int i = 0; i < this.adj.get(vertex).size(); i++) {
                int adjVertex = this.adj.get(vertex).get(i);
                
                if(!visited[adjVertex]) {
                    visited[adjVertex] = true;
                    q.add(adjVertex);
                }
            }
        }
        System.out.println();
    }

    public void DFS(int root) {
        boolean[] visited = new boolean[this.size()];
        DFSUtil(root, visited);
        System.out.println();
    }

    private void DFSUtil(int root, boolean[] visited) {
        visited[root] = true;
        
        System.out.print(root + " ");

        for(int i = 0; i < this.adj.get(root).size(); i++) {
            int adjVertex = this.adj.get(root).get(i);

            if(!visited[adjVertex])
                DFSUtil(adjVertex, visited);
        }
    }
}
