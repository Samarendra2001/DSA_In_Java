

import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class searchElement {
    public static int searchInArray(int arr[],int n,int target){
        for(int i =0;i<n;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        //int arr[]={1,2,12,14,13,18};
        System.out.println("Enter the size of the array");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        System.out.println("enter the target element");
        int target = sc.nextInt();
        int arr[]= new int[size];
        for(int i =0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        int result = searchInArray(arr, size,target);
        if(result!=-1){
            System.out.println("Element found at index"+result);
        }else System.out.println("Element not found");
    }
}

// for each loop

// it is similar to for loop but it is used to traverse the array or collection elements easily without using index variable
// syntax: for(dataType variableName : arrayName/collectionName){
//String names[]={"Aman","Suman","Raman","Karan"};
//for(String name:names){//it is like for every name in names array print the name
//System.out.println(name);
//}  