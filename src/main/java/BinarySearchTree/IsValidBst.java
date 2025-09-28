package BinarySearchTree;

import java.util.*;

public class IsValidBst {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public boolean isValidBST(TreeNode root) {
            return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean valid(TreeNode root, long minValue, long maxValue) {
            if (root == null) return true;

            if (!(root.val > minValue && root.val < maxValue)) return false;

            return valid(root.left, minValue, root.val) && valid(root.right, root.val, maxValue);
        }
    }

    // Function to build tree from array (level-order traversal)
    public static TreeNode buildTreeFromArray(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < arr.length && !queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Add left child
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // Add right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // Helper function to print the tree (in-order traversal)
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case: [2,1,3]
        Integer[] input = {2, 1, 3};
        TreeNode root = buildTreeFromArray(input);

        System.out.println("Tree structure (in-order): ");
        printInOrder(root);
        System.out.println();

        boolean result = solution.isValidBST(root);
        System.out.println("Is valid BST: " + result);

        // Additional test cases
        System.out.println("\n--- Additional Test Cases ---");

        // Test case: [5,1,4,null,null,3,6] - Invalid BST
        Integer[] input2 = {5, 1, 4, null, null, 3, 6};
        TreeNode root2 = buildTreeFromArray(input2);
        System.out.println("Tree [5,1,4,null,null,3,6] - Is valid BST: " +
                solution.isValidBST(root2));

        // Test case: [2,2,2] - Invalid BST (duplicates)
        Integer[] input3 = {2, 2, 2};
        TreeNode root3 = buildTreeFromArray(input3);
        System.out.println("Tree [2,2,2] - Is valid BST: " +
                solution.isValidBST(root3));

        // Test case: [1] - Valid BST (single node)
        Integer[] input4 = {1};
        TreeNode root4 = buildTreeFromArray(input4);
        System.out.println("Tree [1] - Is valid BST: " +
                solution.isValidBST(root4));
    }
}