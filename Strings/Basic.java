import java.util.*;
public class Basic{
    public static void main(String args[]){
        // Scanner sc = new Scanner(System.in);
        // String name = sc.nextLine();//next Line is for taking with space that means if u want sentence with space then use this. If u tale first and last name with space then use it
        // System.out.println("name is "+name);
        String firstName = "Samar";
        String lastName = "Barick";
        String fullName = firstName+" "+lastName;
        System.out.println(fullName);
        System.out.println(fullName.length());
        //char at
        for(int i=0;i<fullName.length();i++){
            System.out.println(fullName.charAt(i));
        }
        //compare
        if(firstName.compareTo(lastName)==0){
            System.out.println("Strings are equal");
        }else System.out.println("Strings are not equal");

        String name2 = fullName.substring(2,5);//here 2 is beginIndex and 5 is endIndex so it will give the string of 2-4
        System.out.println(name2);
    }
    //substring
    
}
//string are immutable in java
//once created in memory it cant be modified
//that s why we use string builder