package ContainsDuplicate;
import java.util.HashSet;

class ContainsDuplicate {
    public static boolean containsDuplicate(int nums[]){
        //create a hashset to store elements from the array
        HashSet<Integer> seenNumbers = new HashSet<>();
        //iterate through each element in the array
        for(int num:nums){
            //check if the number is alrady in hashset
            if(seenNumbers.contains(num)){
                return true;
            }
            //Add the element to the Hashset
            seenNumbers.add(num);
        }
        return false;//No duplicate found
    }
    public static void main(String args[]){
        int arr [] = {1,0,12,3,2,5,2};
        boolean result = containsDuplicate(arr);
        System.out.println("Contains Duplicate :" + result);
    }
}
