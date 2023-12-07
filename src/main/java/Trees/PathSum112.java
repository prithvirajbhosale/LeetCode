package Trees;

public class PathSum112 {
/*
simple approach, create a helper function that will calculate the left sum until root.left & root.right
is null, while doing this keep on adding it to the sum and keep on checking current sum
return which ever is true(either left or right)
 */


    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root == null) return false;
            int sum =0;
            return rootToleafPathsum(root,targetSum,sum);

        }

        private boolean rootToleafPathsum(TreeNode root, int targetSum, int sum){
            if(root == null) return false;

            if(root.left ==null && root.right == null){
                sum = sum + root.val;
                if(sum == targetSum){
                    return true;
                }

            }
            return rootToleafPathsum(root.left,targetSum,sum + root.val) || rootToleafPathsum(root.right,targetSum,sum + root.val);
        }
    }
}
