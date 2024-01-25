package Arrays;

public class RemoveDuplicatesFromSortedArray80 {
    public static int removeDuplicates(int[] nums) {
        int i =0;

        for(int n : nums){

            if(i<2 || n!=nums[i-2]){
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int nums [] = new int[]{1,1,1,2,2,3};
        System.out.println("Result is " + removeDuplicates(nums));



    }
}
