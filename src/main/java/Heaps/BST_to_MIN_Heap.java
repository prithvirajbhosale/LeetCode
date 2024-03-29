package Heaps;

import java.util.ArrayList;

public class BST_to_MIN_Heap {
    // Java implementation to convert the given
// BST to Min Heap
    class Gfg {

        static class Node {

            int data;
            Node left, right;

            // Constructor
            Node()
            {
                this.data = 0;
                this.left = this.right = null;
            }

            Node(int data)
            {
                this.data = data;
                this.left = this.right = null;
            }
        }

        private static void preOrder(Node root)
        {
            if (root == null)
                return;
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        private static void bstToArray(Node root,
                                       ArrayList<Integer> arr)
        {
            // ArrayLIst stores elements in inorder fashion
            if (root == null)
                return;

            bstToArray(root.left, arr);

            arr.add(root.data);

            bstToArray(root.right, arr);
        }

        static int index;
        private static void arrToMinHeap(Node root,
                                         ArrayList<Integer> arr)
        {
            if (root == null)
                return;
            root.data = arr.get(index++);

            arrToMinHeap(root.left, arr);
            arrToMinHeap(root.right, arr);
        }
        static void convertToMinHeap(Node root)
        {
            // initialize static index to zero
            index = 0;
            ArrayList<Integer> arr = new ArrayList<Integer>();
            bstToArray(root, arr);

            arrToMinHeap(root, arr);
        }

        // Driver's code
        public static void main(String[] args)
        {

            // BST formation
            Node root = new Node(4);
            root.left = new Node(2);
            root.right = new Node(6);
            root.left.left = new Node(1);
            root.left.right = new Node(3);
            root.right.left = new Node(5);
            root.right.right = new Node(7);

            System.out.print(
                    "Preorder Traversal Before Conversion :"
                            + "\n");
            preOrder(root);

            // Function call
            convertToMinHeap(root);

            System.out.print(
                    "\nPreorder Traversal After Conversion :"
                            + "\n");
            preOrder(root);
        }
    }

}
