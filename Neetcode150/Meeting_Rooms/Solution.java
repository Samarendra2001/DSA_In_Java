//package Meeting_Rooms;

public class Solution {
    public static boolean canAttendMeetings(int[][] intervals){
        //sort intervals based on start time
        java.util.Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        for(int i =1;i<intervals.length;i++){
            if(intervals[i][0]<intervals[i-1][1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        int [][] intervals = {{5,10},{15,20}};
        System.out.println("Meeting Rooms Problem Solution: " + canAttendMeetings(intervals));
    }
}
