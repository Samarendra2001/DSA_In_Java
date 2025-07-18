package ContainerWith_Most_Water;

public class Solution {
    public static int maxContainWater(int height[]){
        int maxArea = 0;
        int left =0;
        int right = height.length-1;
        while(left<right){
            int width = Math.min(height[left],height[right]);
            int length = right- left;
            maxArea = Math.max(maxArea,width*length);
            if(height[left]<height[right]){
                left++;
            }
            else right--;
        }
        return maxArea;
    }
    public static void main(String args[]){
        int arr[] = {1,8,6,2,5,4,8,3,7};
        int result = maxContainWater(arr);
        System.out.println("Max water can be contained is " + result);
    }
}
