/*
 To find the adjency list of the graph and it's neighbour
 */

import java.util.*;

public class AdjanceyLIST{
    static class Edge{
        int src;
        int des;
        int wt;
        public Edge(int s, int d, int w){
            this.src = s;
            this.des = d;
            this.wt = w;
        }

        public static void main(String[]args){
            int V = 5;
            ArrayList<Edge>[] graph = new ArrayList[V];

            for(int i=0;i<V;i++){
                graph[i] = new ArrayList<>();
            }

            // for vertex-0;
            graph[0].add(new Edge(0,1,5));

            // for vertex-1;
            graph[1].add(new Edge(1,0,5));
            graph[1].add(new Edge(1,2,1));
            graph[1].add(new Edge(1,3,3));

            // for vertex-2;
            graph[2].add(new Edge(2,3,1));
            graph[2].add(new Edge(2,1,1));
            graph[2].add(new Edge(2,4,2));

            // for vertex-3;
            graph[3].add(new Edge(3,2,1));
            graph[3].add(new Edge(3,1,3));

            // for vertex-4;
            graph[4].add(new Edge(4,2,2));

            // To print the specific list neighbours
            for(int i=0;i<graph[2].size();i++){
                Edge e = graph[2].get(i);
                System.out.println(e.des);
            }
        }
    }
}