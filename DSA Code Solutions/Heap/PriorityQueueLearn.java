// Sorting based on PriorityQueue also in reverse order;
import java.util.*;

public class PriorityQueueLearn{
    static class Students implements Comparable<Students>{
        String name;
        int rank;
        public Students(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Students s2){
            return this.rank-s2.rank;
        }
    }
    public static void main(String[] args){
        // For doing the acending order comparign based priority
        // PriorityQueue<Students> pq = new PriorityQueue<>();

        // suppose want to do reverse based comparign then
        PriorityQueue<Students> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // .add()----> O(logn)
        pq.add(new Students("Pradeep", 24));
        pq.add(new Students("Ram", 2));
        pq.add(new Students("Hari", 4));
        pq.add(new Students("Gopal", 6));


        // .remove()-----> O(logn) and .peek()-----O(1)
        while(!pq.isEmpty()){
            System.out.println(pq.peek().name+"->"+pq.peek().rank);
            pq.remove();
        }
    }
}