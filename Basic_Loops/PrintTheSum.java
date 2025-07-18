import java.util.*;
public class PrinttheSum{
    public static void main(String[] args){
        System.out.println("Enter the number till you want the sum");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int Sum=0;
        for(int i =0;i<=num;i++){
            Sum = Sum+i;
        }
        System.out.println("The total Sum till this number is "+ Sum);   
    }
}