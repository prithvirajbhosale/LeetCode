package TwoPointer;

/*
Keep 2 pointers, left and right, now the height should be the minimum between 2 values, and the area will be minimum * the distance on x axis(right-left)
Whichever height is smaller move that pointer ahead

- **Time Complexity:** O(n). As only one traversal of the array is required, so time complexity is O(n).
- **Space Complexity:** O(1). No extra space is required, so space complexity is constant.
 */
public class MostWater11 {
    public int maxArea(int[] height) {
        int left =0, right = height.length -1;
        int sum=0;
        while(left<right){
            sum = Math.max(sum, Math.min(height[left],height[right])*(right-left));

            if (height[left] < height[right])
                left += 1;

            else
                right -= 1;
        }

        return sum;

    }
}
