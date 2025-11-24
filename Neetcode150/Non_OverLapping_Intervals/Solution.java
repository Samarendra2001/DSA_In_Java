//package Non_OverLapping_Intervals;

import java.util.Arrays;

public class Solution {
    public static int eraseOverlapIntervals(int[][] intervals){
        if(intervals.length==0){
            return 0;
        }
        //sort intervals based on end time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        int countNonOverlapping =1;
        int lastIncludedEnd = intervals[0][1];
        for(int i =1;i<intervals.length;i++){
            if(intervals[i][0]>=lastIncludedEnd){
                countNonOverlapping++;
                lastIncludedEnd = intervals[i][1];
            }
        }
        return intervals.length - countNonOverlapping;
    }
    public static void main(String args[]){
        int [][] intervals = {{1,3},{1,3},{3,4},{1,3}};
        System.out.println("Non Overlapping Intervals Problem Solution: " + eraseOverlapIntervals(intervals));
    }
}
