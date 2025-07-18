//Greedy algorithms is the problem solving technique where we make the locally optimum
//choice at each stage and hope to achieve a global optimum.


//1.You are given n activities with their start and end times. select thr maximum no.of activities
//that can be performed by a single person, assuming that a person can only work on a single activity at a time. Activities are sorted according to end time

//Activity selection problem is a common type of problem asked in interviews in various form like
//disjoint set, max.meeting in a room like these
import java.util.*;
public class ActivitySelection {
    public static void SelectionProblem(int start[],int end[]){
        //if sorting is not there then we have to sort it so we are taking 2D array for sorting 
        //and we'll be taking 3 coloumn 1 is index 2nd is start and 3rd is end for storing the original array so that after sorting we'll get to know through their index whether original array or not
        int activities [][] = new int[start.length][3];//3*3
        for(int i=0;i<start.length;i++){
            activities[i][0] = i;//1st column assign with index
            activities[i][1]= start[i];//2nd start
            activities[i][2] = end[i];//3rd end
        }
        Arrays.sort(activities,Comparator.comparingDouble(o->o[2]));//sort based on 2nd column that means on end
        ArrayList<Integer>ans = new ArrayList<>();
        int maxAct = 1;//bcz we have to select the 1st activity
        ans.add(activities[0][0]);//here we select the ist index
        int lastEnd = activities[0][2];//here we select the last end .
        for(int i=0;i<end.length;i++){
            if(activities[i][1]>=lastEnd){
                //activity select
                maxAct++;
                ans.add(activities[i][0]);//here we add the index 
                lastEnd = activities[i][2];//update the last end
            }
        }
        System.out.println("max activities = "+ maxAct);
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int start[] = {1,3,0,5,8,5};
        int end []= {2,4,6,7,9,9,};
        SelectionProblem(start, end);
    }
}
//if sorting is already there 

// maxAct = 1;
// ans.add(0);
// int lastEnd = end[0];
// for(int i=1;i<end.length;i++){
//     if(start[i]>=lastEnd){
//         maxAct++;
//         ans.add(i);
//         lastEnd= end[i];
//     }
// }
