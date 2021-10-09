import java.util.*;

public class Node_depth_in_Tree {

    // this is a BFS for tree
    public static void printLevels(ArrayList<ArrayList<Integer>> graph, int V, int root) {

        // array to store the levels
        int[] levels = new int[V];
        // array to mark nodes as visited to check them only once
        boolean[] visited = new boolean[V];

        Queue<Integer> queue = new LinkedList<Integer>();
        // push root node to queue
        queue.add(root);

        levels[root] = 0;
        visited[root] = true;

        while (queue.size() > 0) {
            root = queue.peek();
            queue.remove();

            // visit all neigh
            for (int i = 0; i < graph.get(root).size(); i++) {
                int next = graph.get(root).get(i);

                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    levels[next] = levels[root] + 1;
                }
            }
        }

    }

}
