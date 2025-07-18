import java.util.*;

public class PrintNumbers {
    public static void main(String[] args){
        System.out.println("Enter the NUmber till want to print");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i=0;
        // for(int i =0;i<=n;i++){
        //     System.out.println(i);
        // }
        // while(i<=n){
        //     System.out.println(i);
        //     i++;
        // }
        do{
            System.out.println(i);
            i++;
        }while(i<=n);
    }
}
