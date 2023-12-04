package LinkedList;

public class LinkedListReverseNode2 {

    private static Node head;

    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    public static void main(String[] args)
    {
        LinkedListReverseNode2 llist = new LinkedListReverseNode2();
        push(20);
        push(4);
        push(15);
        push(10);

        /*Create loop for testing */
        head.next.next.next.next = llist.head;
    }

    static public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        LinkedListReverseNode2.Node new_node = new LinkedListReverseNode2.Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    public static Node reverseBetween(Node head, int left, int right) {
        Node current = head;
        while(head !=null && head.data == left){
            current = current.next;
        }
        while (current.data == right){
            Node temp = current.next;
            Node previous = current;


        }
        return current;
    }
}
