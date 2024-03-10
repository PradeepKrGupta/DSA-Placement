import java.util.ArrayList;
import java.util.*;
public class dfs {
    static class Edge{
        int src,des,wt;
        public Edge(int s, int d, int w){
            this.src = s;
            this.des=d;
            this.wt=w;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        
            for(int i=0;i<graph.length;i++){
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

    }
    public static void createdfs(ArrayList<Edge>[] graph, int curr, boolean vis[]){
        // Approach: 
        // 1. first we print the currenct element
        // 2. then we make the boolean of that element true 
        // 3. then we check wheather destination already visited or not
        // 4. then we call the recursive funtion


        System.out.print(curr+" ");
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.des]){
                createdfs(graph, e.des, vis);
            }
        }

    }

    public static void main(String[]args){
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        createdfs(graph, 0, new boolean[V]);
    }
}
