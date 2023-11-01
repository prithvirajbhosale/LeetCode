package LinkedList;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;


public class LinkedListCycle {
    static Node head;

    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }



   private static boolean detectCycle(Node node){

       HashSet<Node> hashSet = new HashSet<>();

       while (node!=null){
           if (hashSet.contains(node)){
               return true;
           }
           hashSet.add(node);
           node = node.next;

       }
     return false;
   }

    static public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }
    public static void main(String[] args)
    {
        LinkedListCycle llist = new LinkedListCycle();

        push(20);
        push(4);
        push(15);
        push(10);

        /*Create loop for testing */
        head.next.next.next.next = llist.head;

        if (detectCycle(head))
            System.out.println("Loop Found");
        else
            System.out.println("No Loop");
    }
}
