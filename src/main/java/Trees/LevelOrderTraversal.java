package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {



       static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

        public static List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            List<List<Integer>> finalAns = new ArrayList<List<Integer>>();
            if(root ==null)
            {
                return finalAns;
            }
            q.add(root);

            while(!q.isEmpty()){
                int levels = q.size();
                List<Integer> sublevels = new ArrayList<>();

                for(int i=0;i<levels;i++){
                    if(q.peek().left!=null){
                        q.add(q.peek().left);
                    }
                    if(q.peek().right!=null){
                        q.add(q.peek().right);
                    }
                    sublevels.add(q.remove().val);
                }
                finalAns.add(sublevels);

            }
            return finalAns;
        }


    public static void main(String[] args) {
           TreeNode left = new TreeNode(9);
           TreeNode right = new TreeNode(20);
        TreeNode treeNode = new TreeNode(3,left,right);
        //TreeNode treeNode1 = new TreeNode(9,null,null);

        levelOrder(treeNode);
    }


}
