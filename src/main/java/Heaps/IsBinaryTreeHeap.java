package Heaps;

public class IsBinaryTreeHeap {
    /*
        Point to remeber to solve the question

        1. check if it is Complete binary tree
        2. as it should be CBT, check only 3 conditions
            a. if only root is present
            b. only LEFT child is present (CBT property)
            c. If both child are present and their parent data is greater then child

     */
    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    class Solution {
        boolean isHeap(Node tree) {

            //First lets check if it is complete binary tree, bcoz CBT has left filled
            //then right

            return (isCBT(tree,0,countNodes(tree)) && isMaxHeap(tree));
        }

        private int countNodes(Node root)
        {
            if (root == null)
                return 0;
            return (1 + countNodes(root.left)
                    + countNodes(root.right));
        }

        private boolean isCBT(Node root, int index, int total_node){

        /*
        to check if it is complete binary tree we can have count of total nodes
        if in case we have right child and dont have right child then
        the index number will be greater than the total nodes where we can
        say that it is not CBT
        */
            if(root == null) return true;
            if(index>=total_node) return false;

            return isCBT(root.left, 2*index+1,total_node) &&isCBT(root.right, 2*index+2,total_node);

        }


        private boolean isMaxHeap(Node tree){

            Node root = tree;
            //only root exists then it is max heap
            if(root.left == null && root.right == null){
                return true;
            }else if(root.right == null){
                return (root.data > root.left.data);
            }else{
                boolean left = isMaxHeap(root.left);
                boolean right = isMaxHeap(root.right);

                if(left && right && (root.data > root.left.data && root.data > root.right.data)) {
                    return true;
                }
            }
            //only left child exists(as it is complte binary tree it will have left first not right)

            // both left and right exists
            return false;
        }
    }
}
