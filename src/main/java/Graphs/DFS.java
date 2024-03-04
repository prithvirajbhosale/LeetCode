package Graphs;

import java.util.ArrayList;

public class DFS {
    class Solution {
        // Function to return a list containing the DFS traversal of the graph.
        public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here

            boolean visited [] = new boolean[V];
            //visited[0] = true;
            ArrayList<Integer> dfs = new ArrayList<>();
            dfs(0, visited, adj, dfs);

            return dfs;

        }

        private void dfs(int node, boolean visited [],ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> dfs ){
            visited[node] = true;
            dfs.add(node);

            for (int i = 0; i < adj.get(node).size(); i++){
                if (!visited[adj.get(node).get(i)])
                    dfs(adj.get(node).get(i), visited, adj,dfs);

            }
        }
    }
}
