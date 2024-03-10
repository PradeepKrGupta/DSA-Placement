/*
 Minimum Spanning Tree using Prims Algorithm
 Time Complexity: O(ElogE)
 Space Complexity: O(V+E)

 Approach : 
 1. First we create a Priority Queue which act as NON MST set from which non visited nodes will be visited i.e transfered to MST set with it's minimum edge
 2. Then we create Visted[] boolean Array to check weather the node already visted or not
 3. We will find the total cost.
 4. To do all these operations first we have to create Pair<nodes, edgeCost> and sort it based on edgeCost in increasing order

 */


import java.util.*;

public class MSTPrimsAlgo{
    static class Edge{
        int src, dest, wt;
        public Edge(int s, int d, int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    public static void createGraph(ArrayList<Edge>[]graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        graph[2].add(new Edge(2,3,50));
        graph[2].add(new Edge(2,0,15));

        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));
        graph[3].add(new Edge(3,0,30));

    }

    // creating the Pair Class and sort according to cost.
    public static class Pair implements Comparable<Pair>{
        int node;
        int cost;
        public Pair(int n, int c){
            this.node = n;
            this.cost = c;
        }

        @Override  //for sorting the pair according to the cost.
        public int compareTo(Pair p2){
            return this.cost-p2.cost;  //ascending
        }
    }



    // creating the Prims Algo
    public static void PrimsAlgo(ArrayList<Edge>[]graph, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();  //Non-MST
        boolean[] visited = new boolean[V];  //MST

        // Add the starting vertex to the priority queue
        pq.add(new Pair(0, 0)); // Assuming starting vertex is 0

        int mstcost = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visited[curr.node]){
                visited[curr.node] = true;
                mstcost += curr.cost;

                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);
                    if(!visited[e.dest]){
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }

        System.out.println("Minimum cost of MST is :"+mstcost);

    }



    public static void main(String[]args){
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        PrimsAlgo(graph, V);
    }
}


