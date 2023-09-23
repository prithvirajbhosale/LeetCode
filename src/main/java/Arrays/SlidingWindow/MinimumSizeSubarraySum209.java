package Arrays.SlidingWindow;

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.



Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 */
public class MinimumSizeSubarraySum209 {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int ans = Integer.MAX_VALUE;
            int left=0;
            int right=0;
            int sum=0;
            while(right<nums.length){
                sum += nums[right]; //keep adding window end
                while(sum >= target){
                    int len = right-left+1; //Length of the window
                    if(len<ans){  //updating the min window
                        ans = len;
                    }
                    sum -= nums[left]; //check new min window by removing left element and incrementing left pointer
                    left++;
                }
                right++;
            }
            if(ans == Integer.MAX_VALUE){
                ans = 0;
            }
            return ans;
        }
    }
}
