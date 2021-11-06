import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFS {

    class Graph {
        private int V; // amount of nodes in the graph
        private LinkedList<Integer> adj[];

        @SuppressWarnings("unchecked")
        public Graph(int v) {
            V = v;

            // initialize adjacency list for each node
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int v, int w) {
            adj[v].add(w);
        }

        public void dfsHelper(int v, boolean[] visited) {

            // mark node v as visited
            visited[v] = true;
            System.out.println(v + " ");

            // iterate over all connected nodes
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    dfsHelper(n, visited);
                }
            }
        }

        public void dfs(int v) {

            boolean[] visited = new boolean[V];
            dfsHelper(v, visited);
        }

        // iterative DFS using a stack
        public void DFS_iterative(int root) {
            LinkedList<Boolean> visited = new LinkedList<>();
            for (int i = 0; i < V; i++)
                visited.add(false);

            Stack<Integer> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                root = stack.pop();

                if (visited.get(root) == false) {
                    System.out.println(root);
                    visited.set(root, true);
                }
                Iterator<Integer> iter = adj[root].iterator();
                while (iter.hasNext()) {
                    int v = iter.next();
                    if (!visited.get(v))
                        stack.push(v);
                }
            }
        }
    }

}
