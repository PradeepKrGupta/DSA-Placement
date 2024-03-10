import java.util.ArrayList;
import java.util.*;
public class bfs {
    static class Edge{
        int src;
        int des;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.des = d;
            this.wt = w;
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
    public static void createbfs(ArrayList<Edge>[] graph){
        // first create Queue
        Queue<Integer> q = new LinkedList<>();

        // By default vis is false because boolean always false in java bydefault.
        boolean vis[] = new boolean[graph.length];

        // adding the first element int the queue.
        q.add(0);
        

        // Approach 
        // 1. first we check wheather the queue is empty or not
        // 2. then we remove the current element
        // 3. then we check wheather we hava visited the element or not
        // 4. then we print the element
        // 5. then we make boolean array to true of that index
        // 6. then we add the destination element of the current element and the process will continue as to the end.
        
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.des);
                }
            }
        }

    }
    public static void main(String[] args){
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        createbfs(graph);
    }
}
