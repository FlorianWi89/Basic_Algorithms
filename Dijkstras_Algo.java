public class Dijkstras_Algo {

    // this implementation is for matrix-graph representation
    class ShortestPath {
        int Vertices = 9;

        int minDistance(int[] dist, boolean[] shortestPathTreeSet) {
            int min = Integer.MAX_VALUE, min_index = -1;

            for (int v = 0; v < Vertices; v++) {
                if (shortestPathTreeSet[v] == false && dist[v] <= min) {
                    min = dist[v];
                    min_index = v;
                }
            }
            return min_index;
        }

        // O(vertices^2) Time
        void dijkstra(int[][] graph, int start) {
            int[] dist = new int[Vertices];

            boolean[] sptSet = new boolean[Vertices];

            for (int i = 0; i < Vertices; i++) {
                dist[i] = Integer.MAX_VALUE;
                sptSet[i] = false;
            }
            dist[start] = 0;

            for (int count = 0; count < Vertices - 1; count++) {
                int u = minDistance(dist, sptSet);
                sptSet[u] = true;

                for (int v = 0; v < Vertices; v++) {
                    if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                            && dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }
    }

}
