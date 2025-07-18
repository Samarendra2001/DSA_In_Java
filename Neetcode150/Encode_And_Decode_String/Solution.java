package Encode_And_Decode_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    //encodes a list of strings to a single string
    public static String encode(List<String>strs){
         // If the list is empty, return a special character as a string (represents empty list).
         if (strs.size() == 0) {
            return Character.toString((char) 258); // Unicode character 258 serves as a marker for an empty list.
        }

        // Use Unicode character 257 as a separator between strings. This character is unlikely to appear in input strings.
        String separate = Character.toString((char) 257); 

        // Use a StringBuilder for efficient string concatenation.
        StringBuilder sb = new StringBuilder(); 

        // Iterate through the list of strings.
        for (String s : strs) {
            sb.append(s); // Append the string.
            sb.append(separate); // Append the separator.
        }

        // Remove the extra separator added at the end of the string.
        sb.deleteCharAt(sb.length() - 1); 

        // Return the final encoded string.
        return sb.toString();
    }
    //Decodes a single string to a list of strings
    public static List<String> decode(String s){
        // If the encoded string matches the special character for an empty list, return an empty list.
        if (s.equals(Character.toString((char) 258))) {
            return new ArrayList(); // Return an empty ArrayList.
        }

        // The separator used for decoding (same as in encoding).
        String separate = Character.toString((char) 257);

        // Use `split` with the separator to convert the string back into a list.
        // The second argument `-1` ensures trailing empty strings are preserved.
        return Arrays.asList(s.split(separate, -1));
    }
    public static void main(String args[]){
         // Test with a list of strings
         List<String> strs = Arrays.asList("hello", "world", "foo", "bar");
         // Encode the list of strings
        String encodedString = encode(strs);
        System.out.println("Encoded String: " + encodedString);
         // Decode the string back into a list of strings
         List<String> decodedList = decode(encodedString);
         System.out.println("Decoded List: " + decodedList);
 
         // Test with an empty list
         List<String> emptyList = new ArrayList<>();
         String encodedEmpty = encode(emptyList);
         System.out.println("Encoded Empty List: " + encodedEmpty);
 
         List<String> decodedEmpty = decode(encodedEmpty);
         System.out.println("Decoded Empty List: " + decodedEmpty);
    }
}
