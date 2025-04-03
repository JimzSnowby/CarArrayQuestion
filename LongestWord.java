import java.util.ArrayList;

/* Longest Word
Write a function that takes a String parameter and return the longest word in the string.
If there are two or more words that are the same length, return the first word from the string with that length.
Ignore punctuation and assume sen will not be empty.
Words may also contain numbers, for example "Hello world123 567"

Examples:
Input: "fun&!! time"
Output: time
Input: "I love dogs"
Output: love 
*/

public class LongestWord {
    public static void main(String[] args) {
        System.out.println(FindLongestWord("fun&!! time")); // Should return "time"
        System.out.println(FindLongestWord("I love! dogs09")); // Should return "love"
        System.out.println(FindLongestWord("The early%$ bird1123 catches#! the worm")); // Should return "catches"
    }

    public static String FindLongestWord(String sen) {
        String longestWord = "";
        ArrayList<Character> currentWord = new ArrayList<>();

        for (int i = 0; i < sen.length(); i++) {
            char ch = sen.charAt(i);

            // Check if element isn't a number or punctuation
            if (Character.isLetter(ch)) {
                currentWord.add(ch);
            } else { // If it's a space, digit, or punctuation, check the current word
                if (!currentWord.isEmpty()) {
                    // Convert currentWord to a string
                    String wordStr = ConvertToString(currentWord);

                    if (wordStr.length() > longestWord.length()) {
                        longestWord = wordStr;
                    }

                    currentWord.clear(); // Clear list for next word
                }
            }
        }

        // Final check for the last word in the loop
        if (!currentWord.isEmpty()) {
            String wordStr = ConvertToString(currentWord);

            if (wordStr.length() > longestWord.length()) {
                longestWord = wordStr;
            }
        }

        return longestWord;
    }

    // Helper function to convert ArrayList to String
    public static String ConvertToString(ArrayList<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }

        return sb.toString();
    }
}
