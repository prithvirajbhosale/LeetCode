package Trees;

public class CountCompleteTreeNodes222 {

    class Solution {
        int count =0;
        public int countNodes(TreeNode root) {
            if(root ==null) return 0;

            count++;
            countNodes(root.left);
            countNodes(root.right);

            return count;


        }

    }
}
