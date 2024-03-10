/*
 Given an array of jobs where every job has deadline and profit if the job is finished before  the deadline. It is also given that every job takes a single unit of time,m so the max possible deadline for anyjob is 1. Maximize the total profit if only one job  can be scheduled at a time

 job A = 4, 20
 job B = 1, 10
 job C = 1, 40
 job D = 1, 30          ans = C, A (maxjob = 2)
 */
import java.util.*;
public class JobSequencing {
    static class Job{
        int id;
        int deadline;
        int profit;

        public Job(int i, int d, int p){
            id=i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[] args){
        int[][] jobsinfo = {{4, 20},{1, 10},{1, 40},{1, 30}};

        ArrayList<Job> jobs = new ArrayList<>();
        for(int i=0;i<jobsinfo.length;i++){
            // where  the array is used as a constructor argument and parameter as id, deadline and profit as i, [i][0] , [i][1] respectively.
            jobs.add(new Job(i, jobsinfo[i][0], jobsinfo[i][1]));
        }

        // Collections.sort(jobs, (obj1, obj2)-> obj1.profit-obj2.profit); // sort based on the profit value of each job in ascending order


        Collections.sort(jobs, (obj1, obj2)-> obj2.profit-obj1.profit); // sort based on the profit value of each job in descending order

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for(int i=0;i<jobs.size();i++){
            Job currtime = jobs.get(i);
            if(currtime.deadline > time){
                seq.add(currtime.id);
                time++;
            }
        }
        // printing
        System.out.println("Max Job : "+seq.size());
        for(int i=0;i<seq.size();i++){
            System.out.println(seq.get(i)+" ");
        }
        System.out.println();


    }
}
