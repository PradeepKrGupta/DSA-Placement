/*
 To find the strongly connected components in the graph we use the kosaraju algorithm which follow the following steps
 1. Get nodes in a stack(Topological sort)
 2. Transpose the graph i.e reverse the direction edge of the given graph
 3. Do DFS according to the stack nodes on the transpose graph.

 eg:

 1---------->0------->3
 ^         /           |
 |        /            |
 |      /              |
 | 
 |   /                 \/
 2  \/                  4

 */

import java.util.*;
public class Strongly_connected_component {
    static class Edge{
        int src;
        int dest;
        
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    // creating a topsort
    public static void topSort(ArrayList<Edge>[]graph, int curr, boolean vis[], Stack<Integer>s){
        vis[curr] = true;
        

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topSort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    // creating the dfs
    public static void dfs(ArrayList<Edge>[]graph, int curr, boolean vis[]){
        
        vis[curr] = true;
        System.out.print(curr+" ");

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }


    // creating the KosaRajuAlgo
    public static void KosaRajuAlgo(ArrayList<Edge> graph[], int V){
        // step 1 : 
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                topSort(graph, i, vis, s);
            }
        }

        // step2:
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for(int i=0;i<V;i++){
            transpose[i] = new ArrayList<Edge>();
        }

        for(int i=0;i<V;i++){
            vis[i] = false;
            for(int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j); //e.src(i)-->e.dest
                transpose[e.dest].add(new Edge(e.dest, e.src));  //e.dest(i)-->e.src(reversed)
            }
        }

        // step3:
        while(!s.isEmpty()){
            int curr = s.pop();  //removing the curr
            if(!vis[curr]){
                System.out.print("SCC :");
                dfs(transpose, curr, vis);
                System.out.println();
            }

        }

    }  


    public static void main(String[]args){
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        KosaRajuAlgo(graph, V);
    }
    
}
