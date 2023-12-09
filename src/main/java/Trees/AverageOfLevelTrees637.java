package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelTrees637 {

    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> answer =new ArrayList<>();

            if(root == null) return answer;

            Queue<TreeNode> que = new LinkedList<>();
            que.add(root);

            while(!que.isEmpty()){

                int levelSize = que.size();
                double levelSum = 0.0;

                for(int i=0; i< levelSize; i++){
                    TreeNode current = que.poll();
                    levelSum+= current.val;
                    if(current.left!=null){
                        que.add(current.left);
                    }
                    if(current.right!=null){
                        que.add(current.right);
                    }
                }
                double avg = levelSum/levelSize;
                answer.add(avg);


            }

            return answer;

        }
    }
}
