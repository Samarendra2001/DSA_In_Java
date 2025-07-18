//two sum question
import java.util.*;
public class Array1 {
    //1. Using Naive approach. generating all possible pairs - time o(n)^2 space - o(1)
    // public static boolean twoSum(int arr[],int target){
    //     int n = arr.length;
    //     for(int i=0;i<n;i++){
    //         for(int j=i+1;j<n;j++){
    //             if(arr[i]+arr[j]== target){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    
    //2 nd approach using Sort the array and Binary search
    //time - o(nlog(n)), space - O(1)
    // static boolean binarySeacrh(int arr[],int left,int right,int target){
    //     while(left<=right){
    //         int mid = left+(right-left)/2;
    //         if(arr[mid]==target){
    //             return true;
    //         }
    //         if(arr[mid]>target){
    //             right=mid-1;
    //         }
    //         else left = mid +1;
    //     }
    //     return false;
    // }
    // static boolean twoSum(int arr[],int target){
    //     //first sort the array so that binary search will work 
    //     Arrays.sort(arr);
    //     for(int i=0;i<arr.length;i++){
    //         int complement = target-arr[i];

    //         //use binary search
    //         if(binarySeacrh(arr,i+1, arr.length, complement)){
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    //3rd approach - Sorting and two pointer
    //time = o(nlog(n)), space = o(1);
    // 
    
    //4 th approach using hashing
    //time = o(n); space = o(n);
    static boolean twoSum(int arr[],int target){
        HashSet<Integer>set = new HashSet<>();
        for(int i =0;i<arr.length;i++){
            int complement = target-arr[i];

            //check if complement present in the hashset
            //if not then add
            if(set.contains(complement)){
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }
    public static void main(String args []){
        System.out.println("Enter the size of the array");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        System.out.println("Enter the Array elements");
        int arr [] = new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the target element");
        int target = sc.nextInt();
        boolean result = twoSum(arr, target);
        System.out.println(result);

    }
}
