package TwoPointer;

public class ValidPalindrome {

    class Solution {
        public boolean isPalindrome(String s) {
            if(s.isEmpty()){
                return true;
            }

            String str = s.toLowerCase();

            str = str.replaceAll("[^a-zA-Z0-9]","");
            int start = 0;
            int end = str.length()-1;


            while(start<=end){
                if(str.charAt(start) != str.charAt(end)){
                    return false;
                }
                start++;
                end--;
            }

       /* StringBuilder newRevString = new StringBuilder(str);
        newRevString.reverse();
        String rev = newRevString.toString();

        if(str.equals(rev))
        return true;

        return false;*/

            return true;

        }
    }
}
