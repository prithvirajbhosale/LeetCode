package String;

import java.util.HashMap;

/*
Given a string S consisting of lowercase Latin Letters, the task is to find the first non-repeating character in S.

Examples:

Input: “geeksforgeeks”
Output: f
Explanation: As ‘f’ is first character in the string which does not repeat.
 */
public class FirstNonRepeatingString {
    static final int NO_OF_CHARS = 256;
    static char count[] = new char[NO_OF_CHARS];

    public static void main(String[] args) {
        firstNonRepeatingString("geeksforgeeks");
        System.out.println("First repeating character is " + firstNonRepeatingStringwithHashmap("geeksforgeeks"));
        System.out.println("First repeating character is via brute force approach is  " + firstNonRepeatingStringBruteForce("geeksforgeeks"));
    }

    static int firstNonRepeatingString(String str) {

        getCharCountArray(str);
        int index = -1, i;

        for (i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                index = i;
                break;
            }
        }

        return index;
    }

    static void getCharCountArray(String str) {
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;
    }

    public static Character firstNonRepeatingStringwithHashmap(String str) {
        //O(1)
        HashMap<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            mp.put(str.charAt(i), mp.getOrDefault(str.charAt(i), 0) + 1);
        }
        for (Character c : str.toCharArray()) {
            if (mp.get(c) == 1) {
                return c;
            }
        }
        return null;

    }

    public static Character firstNonRepeatingStringBruteForce(String str) {
        for (int i = 0; i < str.length(); i++) {
            boolean repeat = false;
            for (int j = 0; j < str.length(); j++) {
                if (i != j && str.charAt(i) == str.charAt(j)) {
                    repeat = true;
                    break;
                }
            }
            if (!repeat) {
                return str.charAt(i);
            }
        }
        return null;

    }
}
 