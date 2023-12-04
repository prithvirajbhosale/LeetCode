package Trees;

import java.util.*;


public class BinarySearchTree {

    static class node{
        int data;
        node left;
        node right;

        public node(int data, node left, node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /*Breadth first Search*/
    static void levelOrderTraversal(node root){
        Queue<node> q = new LinkedList<>();
        q.add(root);

        /*
        code to print it level wise
         */
        //add a delimiter
        q.add(null);

        while(!q.isEmpty()){
            node temp = q.poll();


            if(temp == null){
                //This means level is complete
                System.out.println();
                if (!q.isEmpty()){
                    //Queue still has some child nodes
                    q.add(null);
                }
            }else {
                if (temp.left !=null){
                    q.add(temp.left);
                }

                if (temp.right !=null){
                    q.add(temp.right);
                }

                System.out.println(temp.data + " ");
            }

        }


    }

    public static void main(String[] args) {
        node root = null;
        node root1 = null;
        root = buildTree(root);
       // System.out.println("buid tree 2 started ");
        //root1 = buildTree(root);

       // isSameTree(root,root1);



        System.out.println("In Order traversal is ");
        inOrderTraversal(root);

        System.out.println("Pre Order traversal is ");
        preOrderTraversal(root);

        System.out.println("Post Order traversal is ");
        postOrderTraversal(root);


    }

    //L N R
    static void inOrderTraversal(node root){
        //base case
        if(root == null) return;

        inOrderTraversal(root.left);
        System.out.println(root.data + " ");
        inOrderTraversal(root.right);

    }

    //NLR
    static void preOrderTraversal(node root){
        //base case
        if(root == null) return;

        System.out.println(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    //LRN
    static void postOrderTraversal(node root){
        //base case
        if(root == null) return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data + " ");

    }

    private static node buildTree(node root) {
        System.out.println("Enter the data");
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        root = new node(data);
        if (data == -1){
            return  null;
        }
        //1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
        System.out.println("Inserting in Left of " + data);
        root.left = buildTree(root.left);

        System.out.println("Inserting in right of the tree "+ data);
        root.right = buildTree(root.right);

        System.out.println("Printing the level order Traversal");
        levelOrderTraversal(root);


        return root;

    }

    static boolean isSameTree(node p, node q) {
        if(p.data != q.data) return false;

        Queue<node> que_left = new LinkedList<>();
        Queue<node> que_right = new LinkedList<>();
        que_left.add(p);
        que_right.add(q);

        while(!que_left.isEmpty() && !que_right.isEmpty()){
            node temp_left = que_left.poll();
            System.out.println(temp_left.data);
            node temp_right = que_right.poll();
            System.out.println(temp_right.data);

            if((temp_left !=null && temp_right != null) &&(temp_left.data ==temp_right.data)){
                continue;
            }else{
                return false;
            }

        }

        return true;
    }
}
