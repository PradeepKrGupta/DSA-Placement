import java.util.*;

public class HasPath {

    static class Edge {
        int src, des, wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.des = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // for vertex-0;
        graph[0].add(new Edge(0, 1, 5));

        // for vertex-1;
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // for vertex-2;
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 4, 2));

        // for vertex-3;
        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 1, 3));

        // for vertex-4;
        graph[4].add(new Edge(4, 2, 2));

    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int des, boolean vis[]){
        if(src==des){
            return true;
        }
        vis[src] = true;
        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            if(!vis[e.des] && hasPath(graph, e.des, des, vis)){
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(hasPath(graph, 0, 3, new boolean[V]));
    }
}
