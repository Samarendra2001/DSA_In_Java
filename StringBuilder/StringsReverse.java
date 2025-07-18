
import java.util.*;

public class StringsReverse {
    public static String reverseString(String str){
        char[] charArray = str.toCharArray();
        int start = 0;
        int end = charArray.length-1;
        //swap the character untill start meets end
        while(start<end){
            char temp = charArray[start];
            charArray[start]=charArray[end];
            charArray[end]=temp;
            start++;
            end--;
        }
        return new String(charArray);//convert char Array back to String
    }
    public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your String");
    String str = sc.nextLine();
    System.out.println("Original String is :" + str);
    String reversed = reverseString(str);
    System.out.println("Reverse String is " + reversed);

    }
}
//this is the most efficient way asof space complexity o(1) and time o(n);
//is we use String builder time complexity will be same but space will be O(n);
// public static String reverseString(String str) {
//     StringBuilder sb = new StringBuilder();
//     for (int i = str.length() - 1; i >= 0; i--) {
//         sb.append(str.charAt(i));  // Append characters in reverse order
//     }
//     return sb.toString();  // Return the reversed string
// }

//another method using built in method
// public static String reverseString(String str) {
//     // Create a StringBuilder with the input string
//     StringBuilder sb = new StringBuilder(str);
//     // Use the reverse() method of StringBuilder
//     sb.reverse();
//     // Convert StringBuilder back to String and return it
//     return sb.toString();
// }
