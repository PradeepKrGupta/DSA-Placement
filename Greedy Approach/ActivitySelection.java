/*
 You are given n activities with their start and end times. Select the maximum number of activities  that can be performed by a single person, assuming that a person can only work on one activity at a time. Activities are sorted according to end time

 start time = [10, 12, 20]
 end time =   [20, 25, 30]

 ans = 2(A0 and A2)

 */
// ==========================Time complexity (O(n))=========================
// import java.util.*;
//  public class ActivitySelection{
//     public static void Activities(List<Integer> ans){
//         System.out.println("Activities are: ");
//         for(int i=0;i<ans.size();i++){
//             System.out.print("A"+ans.get(i)+" ");
//         }
//         System.out.println();
//     }
//     public static int maxActivities(int start_time[], int end_time[]){
//         if(start_time.length == 0 || end_time.length==0){
//             return 0;
//         }
//         ArrayList<Integer> ans = new ArrayList<>();
//         int count = 1;
//         ans.add(0);
//         int lastend = end_time[0];
//         for(int i =1;i<start_time.length;i++){
//             if(start_time[i] >= lastend){
//                 count++;
//                 ans.add(i);
//                 lastend = end_time[i];
//             }
//         }
//         Activities(ans);
//         return count;
//     }
//     public static void main(String args[]){
//         int start_time[] = {10, 12, 20};
//         int end_time[] = {20, 25, 30};

//         System.out.println(maxActivities(start_time,end_time));
//     }
//  }




// Suppose the endtime is not sorted then we use the below approach where we sort the end_time.


// =============================Time complexity 0(nlogn)====================
import java.util.*;
 public class ActivitySelection{
    public static void Activities(List<Integer> ans){
        System.out.println("Activities are: ");
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }
    public static int maxActivities(int start_time[], int end_time[]){
        if(start_time.length == 0 || end_time.length==0){
            return 0;
        }

        // creating the 2D array to store the activities start and end time with their indexes, so that later we sort it.
        int[][] Allactivities = new int[start_time.length][3];
        for(int i=0;i<start_time.length;i++){
            Allactivities[i][0] = i;
            Allactivities[i][1] = start_time[i];
            Allactivities[i][2] = end_time[i];
        } 

        // Now using comparator for sorting the times according to end time
        Arrays.sort(Allactivities, Comparator.comparingDouble(o->o[2]));

        ArrayList<Integer> ans = new ArrayList<>();

        int count = 1;
        ans.add(Allactivities[0][0]);  //Here Allactivites[0][0] because 0 is for index_column 0;
        int lastend = Allactivities[0][2];  //Here Allactivites[0][2] because 2 is for end_time column 2;
        for(int i =1;i<start_time.length;i++){
            if(Allactivities[i][1] > lastend){   //Here Allactivites[0][1] because 1 is for start_time column 1;
                count++;
                ans.add(Allactivities[i][0]);
                lastend = Allactivities[i][2];
            }
        }
        Activities(ans);
        return count;
    }
    public static void main(String args[]){
        int start_time[] = {1,3, 0, 5, 8, 5};
        int end_time[] = {2, 4, 6, 7, 9, 9};
        // int start_time[] = {1, 3, 2, 5};
        // int end_time[] = {2, 4, 3, 6};

        // 1 3 2 5
        // 2 4 3 6

        System.out.println(maxActivities(start_time,end_time));
    }
 }