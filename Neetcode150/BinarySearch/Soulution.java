package BinarySearch;

public class Soulution {
    public static int Search(int nums [],int target){
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1; // Target not found
    }
    public static void main(String args[]){
        int arr []= {1,2,3,5,9};
        int key = 9;
        int result = Search(arr, key);
        System.out.println("key found at" + result);
    }
}
