//package FunctionsInJava;
import java.util.*;

public class Functions {
    public static int FactorialOfNumber(int a){
        int result = 1;
        for(int i=a;i>=1;i--){
            result = result*i;
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int number = sc.nextInt();
        int result = FactorialOfNumber(number);
        System.out.println("Factorial of"+number+"is"+result);
    }
}
