package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    static class Solution {
        public static int[] twoSum(int[] nums, int target) {

            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i=0; i<nums.length ; i++){
                int num = nums[i];
                int diff = target - num;
                if(map.containsKey(diff)){
                    return new int[] { map.get(diff), i };
                }
                map.put(num,i+1);
            }
            return new int[] {};
        }

        public static void main(String[] args) {
            int array [] = new int[]{2,7,11,15};
           int [] result = twoSum(array,9);
            Arrays.toString(result);
        }
    }


}
