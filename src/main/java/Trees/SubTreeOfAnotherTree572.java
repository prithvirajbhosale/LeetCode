package Trees;

public class SubTreeOfAnotherTree572 {
    class Solution {
            public boolean isSubtree(TreeNode root, TreeNode subRoot) {

                if (subRoot == null)
                    return true;

                if (root == null)
                    return false;

                //check if identical with the cuurent node as a root
                if(isIdentical(root,subRoot)){
                    return true;
                }

       /*If the tree with root as current node doesn't
           match then
           try left and right subtrees one by one */
                if(isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot)){
                    return true;
                }
                return false;
            }

            private boolean isIdentical(TreeNode root, TreeNode subRoot){
                if(root == null && subRoot == null) return true;


                if(root == null || subRoot == null) return false;

                //check if the root values are same, check all the data if it is same

                return(root.val ==subRoot.val && isIdentical(root.left,subRoot.left) &&isIdentical(root.right,subRoot.right));
            }
    }

}
