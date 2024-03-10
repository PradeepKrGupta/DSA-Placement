/* 
Using Dikstra's Algorithm to find the shortest Path
Approach: 
1.first we create Distance array.
2.then we find out the direct distance from source to destination, if Direct Distance is not there then we update it with infinity
3. Then we need to find out the eachnode which is visited and distance is shortest.
4. then we use relaxation where we check
             if (dist[u]+wt<dist[v]){
                dist[v] = dist[u]+wt;
             }
5. We repeat step 4 till all nodes

=> It uses Greedy Approach rather then DP
=> Time Complexity using Priority Queue is : O(V+ElogV) and without Priority Queue : O(V^2)

*/

// Code

import java.util.*;

public class DikstraAlgoShortestPath {
    static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // for vertex-0;
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // for vertex-1;
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        // for vertex-2;
        graph[2].add(new Edge(2, 4, 3));

        // for vertex-3;
        graph[3].add(new Edge(3, 5, 1));

        // for vertex-4;
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) { // Path based sorting for pairs
            return this.path - p2.path;
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        dist[src] = 0;
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.n]) {
                vis[curr.n] = true;
                // Neighbours
                for (Edge e : graph[curr.n]) {
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[curr.n] + wt < dist[v]) {
                        dist[v] = dist[curr.n] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        // Printing the all source to vertices shortest distance
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        int src = 0;
        dijkstra(graph, src);
    }
}
