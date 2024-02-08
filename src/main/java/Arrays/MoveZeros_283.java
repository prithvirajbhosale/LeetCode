package Arrays;

public class MoveZeros_283 {
    public static void moveZeroes(int[] nums) {
        // lets move all the non zero elements in the front and later fill with zero
        int i =0;
        for(int j=0; j<nums.length;j++){
            if(nums[j]!=0){
                nums[i] = nums[j];
                i++;
            }
        }
        for(int k=i; k<nums.length;k++){
            nums[k] =0;
        }
    }

    private static void swap(int [] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{0,1,0,3,12};
        moveZeroes(arr);
    }
}
