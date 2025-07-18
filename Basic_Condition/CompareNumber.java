//package Basic_Condition;
import java.util.*;
public class CompareNumber {
    public static void main(String[] args) {
        System.out.println("Enter first number");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("Enter second number");
        int b = sc.nextInt();
        if(a==b){
            System.out.println("a is eqal to b");
        }else if(a>b) System.out.println("a is greater than b");
        else System.out.println("b is greater than a");
    }
}
