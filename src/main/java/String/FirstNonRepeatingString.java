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

    public static void main(String[] args) {
        firstNonRepeatingString("geeksforgeeks");
    }

    class CountIndex {
        int count, index;

        // constructor for first occurrence
        public CountIndex(int index)
        {
            this.count = 1;
            this.index = index;
        }

        // method for updating count
        public void incCount() { this.count++; }
    }

     static int firstNonRepeatingString(String s){

        int count =0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i =0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
               map.get(s.charAt(i));
            }else{
                map.put(s.charAt(i),++count);
            }

        }
        return count;
    }
}
