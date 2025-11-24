//package Valid_Parenthesis_greedy;

public class Solution {
    public static boolean isValid(String s){
        int minOpen = 0,maxOpen =0;
        for(char c:s.toCharArray()){
            if(c == '('){ // for open parenthesis increment both
                minOpen++;
                maxOpen++;
            }else if(c == ')'){ // for closing parenthesis decrement both
                minOpen = Math.max(minOpen-1,0);
                maxOpen--;
            } else{ // for '*' we can consider it as either '(', ')' or empty
                minOpen--;
                maxOpen++;
            }
            if(maxOpen<0){ // if maxOpen is negative means we have more ')' than '('
                return false;
            }
            minOpen = Math.max(minOpen,0); // minOpen should not be negative as we can't have more ')' than '('
        }
        return minOpen == 0; // if minOpen is 0 means we have valid parenthesis
    }
    public static void main(String args[]){
        String s = "(*))";
        System.out.println("Valid Parenthesis Problem Solution: " + isValid(s));
    }
}
