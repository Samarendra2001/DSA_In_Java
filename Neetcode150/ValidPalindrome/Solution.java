//package ValidPalindrome;

public class Solution {
    public static boolean isPalindrome(String s){
          // Initialize two pointers, one starting at the beginning of the string
        // and the other starting at the end of the string.
        int left = 0;
        int right = s.length() - 1;

        // Loop until the two pointers meet in the middle
        while (left < right) {
            
            // Move the left pointer forward if the character is not alphanumeric
            // (i.e., neither a letter nor a digit).
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Move the right pointer backward if the character is not alphanumeric.
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare the characters pointed by `left` and `right`.
            // Convert both characters to lowercase to perform a case-insensitive comparison.
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                // If the characters are not the same, the string is not a palindrome.
                return false;
            }

            // If the characters match, move both pointers towards the middle.
            left++;
            right--;
        }

        // If the loop completes, the string is a valid palindrome.
        return true;
    }

    public static void main(String[] args) {
        //Solution sol = new Solution();

        // Test cases
        String test1 = "A man, a plan, a canal: Panama";
        String test2 = "race a car";
        String test3 = " ";

        System.out.println("\"" + test1 + "\" is palindrome: " + isPalindrome(test1));
        System.out.println("\"" + test2 + "\" is palindrome: " + isPalindrome(test2));
        System.out.println("\"" + test3 + "\" is palindrome: " + isPalindrome(test3));
    }
}
