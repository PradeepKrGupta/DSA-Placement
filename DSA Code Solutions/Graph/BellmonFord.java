
/*
Bellman Ford Algorithm to find the shortest Path 
Note: Advantage of Bellman ford Algo is that it will not gonna fail on negative weigth whereas Dikstra's will failed on Negative weigth
 =>shortest distance from the source to destination of all vertices
 => It uses Dynamic Programming Concept rather then Greedy

 => It will fail on Negative weight cycle ie. if wt a+b+c<0 i.e -ve wt cycle and to detect it we use the same relaxation code to print it.

 => Time Complexity: O(V*E)


*/

import java.util.ArrayList;
import java.util.*;

public class BellmonFord {
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
        graph[1].add(new Edge(1, 2, -4));

        // for vertex-2;
        graph[2].add(new Edge(2, 3, 2));

        // for vertex-3;
        graph[3].add(new Edge(3, 4, 4));

        // for vertex-4;
        graph[4].add(new Edge(4, 1, -1));       //Here instead of -1 wt if, we use the -10 then it's become negative edge cycle, where Bellman ford get's failed and not any algo is there to tackle it.

    }

    public static void bellmanFort(ArrayList<Edge>[] graph, int src, int V) {
        int dist[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // O(V*E)
        for (int k = 0; k < V - 1; k++) { // O(V)
            // O(E)
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;

                    // Here we add additional check just because of Java, since in Java if we add
                    // anything on infinity then it's become negative so, Here we check
                    // if(dist[u]!=Integer.MAX_VALUE)

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]) {
                        dist[v] = dist[u] + e.wt;
                    }
                }
            }
        }
        // ===============================================NotCompulosry=======================================================

        // To detect the negative edge cycle-------------using this code it's not
        // compulosry to use it,
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                int u = e.src;
                int v = e.dest;

                // Here we add additional check just because of Java, since in Java if we add
                // anything on infinity then it's become negative so, Here we check
                // if(dist[u]!=Integer.MAX_VALUE)

                if (dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]) {
                    System.out.println("Negative Edge cycle Exists!");
                }
            }
        }
        // =================================================================================================================

        // for printing the distance value
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        bellmanFort(graph, 0, V);
    }
}

// Output : 0 2 -2 0 4