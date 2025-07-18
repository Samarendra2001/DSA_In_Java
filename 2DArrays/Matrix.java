//package 2DArrays;
import java.util.*;
public class Matrix {
    public static int SearchInMatrix(int arr[][],int target,int col,int row){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if (arr[i][j]==target){
                    System.out.println(target +"found at location"+ i +","+j +" ");
                }
            }
        }
        return -1;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row size");
        int row = sc.nextInt();
        System.out.println("ENter the column size");
        int col = sc.nextInt();
        System.out.println("Enter the target element");
        int target = sc.nextInt();
        int arr[][]=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(arr[i][j] + " ");
            }
        }
        System.out.println();
        SearchInMatrix(arr, target, col, row);
        // if(result!=-1){
        //     System.out.println("Number found at index "+ [i,j]);
        // }else System.out.println("Element  not found");


    }
}
