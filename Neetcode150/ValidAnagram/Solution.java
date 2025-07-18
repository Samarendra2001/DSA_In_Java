package ValidAnagram;

public class Solution {
    public static boolean isAnagram(String s, String t){
        //if the lengths are different they can't be anagram
        if(s.length()!=t.length()){
            return false;
        }
        //create a new array to count character frequencies
        int charCounts [] = new int[26]; // [0, 0, ..., 0] (size 26)
        //increment the counter for each character in 's' and decrement for each in't
        for(int i=0;i<s.length();i++){
            charCounts[s.charAt(i) - 'a']++;//it means in ASCII a starts at 97 so if a appears then 97-97 then 0 index then ++ =1 similarly for c it wil be 99-97 +1 = 3 so this is index so in 3rd index it will be -- means -1
            charCounts[t.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(charCounts[i]!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        String s = "cart";
        String t = "tarc";
        boolean result = isAnagram(s,t);
        System.out.println(result);
    }
}
