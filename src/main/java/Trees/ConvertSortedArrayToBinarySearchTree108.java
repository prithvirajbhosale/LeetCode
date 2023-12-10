package Trees;


/*
    Easy solution
        calculate the start end and mid of the array
            Mid becomes the root
            First half becomes the left part
            2nd half becomes the right part of the tree

 */
public class ConvertSortedArrayToBinarySearchTree108 {

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return buildTree(nums,0,nums.length-1);
        }

        private TreeNode buildTree(int[] nums,int start, int end){

            if(start>end){
                return null;
            }
            int mid = (start+end)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildTree(nums,start,mid-1);
            root.right = buildTree(nums,mid+1,end);

            return root;

        }
    }
}
