import java.util.*;

public class PrintTheTable {
    public static void main(String[] args){
        System.out.println("Enter the table number");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int result =1;
        for(int i =1;i<=10;i++){
            result=num*i;
            System.out.println(num +"*"+i+"="+ result);
        }
        //System.out.println("table of "+num+"is"+result);
    }
}
