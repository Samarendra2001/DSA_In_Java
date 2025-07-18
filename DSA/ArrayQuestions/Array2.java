//Stock Buy and Sell – Max one Transaction Allowed

import java.util.*;
public class Array2{
    //ist approach naive approach by using two for loop for al possible result
    //t-o(n)^2,s-o(1);
    // static int stockBuyAndSell(int arr[]){
    //     int res = 0;
    //     for(int i=0;i<arr.length;i++){
    //         for(int j=i+1;j<arr.length;j++){
    //             res = Math.max(res,(arr[j]-arr[i]));
    //         }
    //     }
    //     return res;
    // }


    //2nd and better approach where will have a count of minimum stock value
    //t -o(n),s-o(1)
    static int stockBuyAndSell(int arr[]){
        int res = 0;
        int minPrice = arr[0];
        for(int i=1;i<arr.length;i++){
            minPrice = Math.min(minPrice,arr[i]);
            res = Math.max(res,arr[i]-minPrice);
        }
        return res;
    }
    public static void main(String args[]){
        System.out.println("Enter the size of the array");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        //edge cases for at least one emenet
        if (size <= 0) {
            System.out.println("Invalid size, array must have at least one element.");
            return;
        }
        int arr[]= new int[size];
        System.out.println("Enter the array elements");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("this is the Array element");
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        //System.out.println();
        int result = stockBuyAndSell(arr);
        System.out.println("Maximum profit is: " +result);

    }
}