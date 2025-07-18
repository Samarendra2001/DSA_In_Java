package TopKFrequentElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static int[] topKFrequentElemenet(int nums[],int k){//The method returns an array of integers, specifically the k most frequent numbers in nums.
        if(k==nums.length){//If k is equal to the length of the input array nums, it means that all numbers must be returned because k is as large as the total number of unique elements in nums.
            return nums;
        }
        Map<Integer,Integer>count = new HashMap<>();//Create a HashMap called count to store the frequency of each element in nums.Key-Value: The keys of the count map will be the elements of nums, and the values will be the count (frequency) of those elements in nums.
        for(int n:nums){//For each element n in nums, update the frequency count.
            count.put(n,count.getOrDefault(n,0)+1);//The count.getOrDefault(n, 0) function retrieves the current frequency of n from the map count. If the element n does not exist in the map, it returns the default value 0.
        }//The +1 increments the frequency count of the number n.
        Queue<Integer>heap = new PriorityQueue<>(//Create a min-heap (priority queue) called heap to store elements based on their frequency, with the least frequent element being at the root.
            (a,b)->count.get(a)-count.get(b));//compares two elements a and b based on their frequencies stored in the count map. If a has a lower frequency than b, a will be placed before b in the heap.
        for(int n:count.keySet()){//this loop iterates over the keys in the count map. Each key n represents a distinct element from nums.
            heap.add(n);//For each element n (from the count map), it is added to the heap.
            if(heap.size()>k){
                heap.poll();//f the heap's size exceeds k, the root element (the least frequent element) is removed using heap.poll(). This ensures that the heap always contains only the k most frequent elements.
            }
        }
        int ans [] = new int[k];//ans is an array of size k where we will store the result (the k most frequent elements).
        for(int i=0;i<k;i++){//The heap contains the k most frequent elements, with the least frequent element at the top.
            ans[i]=heap.poll();//We use a for loop to remove (poll) all k elements from the heap and store them in the ans array.
        }
        return ans;//return the ans array.
    }
    public static void main(String args[]){
        int arr[] = {1,1,2,3,4,5,3,3,2,2,3,4,5,2,1,3,1,3,5};
        int k =4;
        int result [] = topKFrequentElemenet(arr, k);
        System.out.println("Top "+k+" frequent elemnts : " + Arrays.toString(result));
    }
    
}
//The Arrays.toString() method is a static method from the java.util.Arrays class. It formats an array into a single string where:
