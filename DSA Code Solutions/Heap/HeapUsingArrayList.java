// import java.util.ArrayList;

// public class HeapUsingArrayList {

//     static ArrayList<Integer> list = new ArrayList<>();

//     static class Heap {

//         // Adding the Values into the heap....O(logn)
//         public static void add(int data) {
//             list.add(data);
//             int x = list.size() - 1;
//             int par = (x - 1) / 2;

//             while (x > 0 && list.get(x) < list.get(par)) { // O(logn)
//                 // swapping
//                 int temp = list.get(x);
//                 list.set(x, list.get(par));
//                 list.set(par, temp);

//                 x = par;
//                 par = (x - 1) / 2;
//             }
//         }

//         // finding the peek value....O(1)
//         public static int peek() {
//             if (list.isEmpty()) {
//                 System.out.println("Heap is empty");
//             }
//             return list.get(0);
//         }

//         // creating the heapify function that uses O(logn) time
//         private void heapify(int i) {
//             int left = 2 * i + 1;
//             int right = 2 * i + 2;
//             int minIdx = i;

//             if (left < list.size() && list.get(left) < list.get(minIdx)) {
//                 minIdx = left;
//             }

//             if (right < list.size() && list.get(right) < list.get(minIdx)) {
//                 minIdx = right;
//             }

//             if (minIdx != i) {
//                 // swapping
//                 int temp = list.get(i);
//                 list.set(i, list.get(minIdx));
//                 list.set(minIdx, temp);

//                 heapify(minIdx);
//             }
//         }

//         // Remove the minimum element (root) from the heap....O(logn)
//         public int remove() {
//             if (list.isEmpty()) {
//                 System.out.println("Heap is empty");
//             }
//             int data = list.get(0);
//             list.set(0, list.get(list.size() - 1));
//             list.remove(list.size() - 1);

//             heapify(0);
//             return data;
//         }

//         public static boolean isEmpty() {
//             return list.isEmpty();
//         }

//     }

//     public static void main(String[] args) {
//         Heap h = new Heap();
//         h.add(2);
//         h.add(3);
//         h.add(6);
//         h.add(5);
//         h.add(8);

//         while (!Heap.isEmpty()) {
//             System.out.println(h.peek());
//             h.remove();
//         }
//     }
// }



// ============The above one we also called as heap sort===========



// ===========Suppose if we want to do with maxHeap then we just need to change every '<' to '>' and rest everything will be same

import java.util.ArrayList;

public class HeapUsingArrayList {

    static ArrayList<Integer> list = new ArrayList<>();

    static class Heap {

        // Adding the Values into the heap....O(logn)
        public static void add(int data) {
            list.add(data);
            int x = list.size() - 1;
            int par = (x - 1) / 2;

            while (x > 0 && list.get(x) > list.get(par)) { // O(logn)
                // swapping
                int temp = list.get(x);
                list.set(x, list.get(par));
                list.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        // finding the peek value....O(1)
        public static int peek() {
            if (list.isEmpty()) {
                System.out.println("Heap is empty");
            }
            return list.get(0);
        }

        // creating the heapify function that uses O(logn) time
        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < list.size() && list.get(left) > list.get(minIdx)) {
                minIdx = left;
            }

            if (right < list.size() && list.get(right) > list.get(minIdx)) {
                minIdx = right;
            }

            if (minIdx != i) {
                // swapping
                int temp = list.get(i);
                list.set(i, list.get(minIdx));
                list.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        // Remove the minimum element (root) from the heap....O(logn)
        public int remove() {
            if (list.isEmpty()) {
                System.out.println("Heap is empty");
            }
            int data = list.get(0);
            list.set(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);

            heapify(0);
            return data;
        }

        public static boolean isEmpty() {
            return list.isEmpty();
        }

    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(2);
        h.add(3);
        h.add(6);
        h.add(5);
        h.add(8);

        while (!Heap.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}

