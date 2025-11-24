//package Meeting_Rooms_II;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static int minConferenceRooms(int[][] intervals){
        //sort intervals based on start time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        //min heap to track the end time of meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int[] interval : intervals){
            if(!minHeap.isEmpty() && interval[0]>=minHeap.peek()){
                minHeap.poll();
            }
            minHeap.add(interval[1]);
        }
        return minHeap.size();
    }
    public static void main(String args[]){
        int [][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println("Meeting Rooms II Problem Solution: " + minConferenceRooms(intervals));
    }
}
