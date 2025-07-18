import java.util.*;
public class SwitchCase{
    public static void main(String[] args) {
        System.out.println("enter a number");
        Scanner sc = new Scanner (System.in);
        int num = sc.nextInt();
        switch(num){
            case 1: System.out.println("red");
            break;
            case 2: System.out.println("Gren");
            break;
            case 3: System.out.println("blue");
            break;
            default: System.out.println("wrongInput");
        }
    }
}