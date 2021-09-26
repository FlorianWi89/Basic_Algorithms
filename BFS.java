import java.util.Iterator;
import java.util.LinkedList;

public class BFS {

    class Graph {
        private int V; // No. of vertices
        private LinkedList<Integer> adj[]; // Adjacency Lists

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList<Integer>();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void bfs(int node) {
            boolean visited[] = new boolean[V];
            LinkedList<Integer> queue = new LinkedList<Integer>();

            visited[node] = true;
            queue.add(node);

            while (queue.size() != 0) {
                node = queue.poll();
                System.out.println(node + " ");

                Iterator<Integer> iter = adj[node].listIterator();
                while (iter.hasNext()) {
                    int n = iter.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }

    }

}
