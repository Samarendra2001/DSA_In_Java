package FunctionsInJava;

import java.util.Scanner;

public class Basic {
    public static int PrintSum(int a, int b){
       int sum = a+b;
       return sum;

    }
    public static void main(String[] args){
        System.out.println("Enter first number");
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        System.out.println("Enter the second number");
        int num2 = sc.nextInt();
        int sum = PrintSum(num1, num2);
        System.out.println(sum);
    }
}
