package LinkedList;

import org.springframework.stereotype.Component;


public class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }


    //insert at head

    static Node insertAtHead(int data,Node head){
        if (head ==  null){
            head.data = data;
            head.next = null;
        }
        Node temp = new Node(data);
        temp.next = head;
        head = temp;

        return head;
    }

    static void insertAfterANode(Node head,int position, int data){
        Node temp = head;
        int cnt = 1; //saying that  head is the first node

        // now travers till position -1
        while (cnt<position-1){
            temp = temp.next;
            cnt++;
        }
        Node newNode = new Node(data);
        //first lets point it to the next node
        newNode.next = temp.next;
        //Now lets cut the previous link
        temp.next = newNode;

    }
     static void deleteNode(Node head,int position){
        Node current = head;
     }

    static void insertAtEnd(int data,Node head){
        if (head == null) {
            System.out.println("Empty Linked List");
        }
        Node current = head;
        while (current.next!= null){
            current = current.next;
        }
        Node node = new Node(data);
        current.next = node;

    }

    //Print LinkedList
    static void printLinedList(Node head){
        if (head == null) {
            System.out.println("Empty Linked List");
        }
        Node temp = head;
         System.out.println("Nodes : ");
        while (temp!= null){
            System.out.print(temp.data);
            System.out.print("   ");
            temp = temp.next;
        }
    }

    static Node reverseLinkedList(Node head){
        Node current = head;
        Node previous = null;
        //Make previous point to null and current to head
        while (current!= null){
            Node temp = current.next;
            //we will point previous to current
            // 100->122->10->20
            //below statemnet will make next pointer point to null (in 1st iteration)
          current.next = previous;
          //now we will shift the previous pointer to current, but we loosed the next adress hence stored it in temp
          previous = current;
          //making the temp as current to retain the address
          current= temp;
        }
        return previous;

    }

    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node head = node1;

        head = insertAtHead(100,head);
        Node tail = node1;


        insertAtEnd(20,head);

       // insertAtHead(10,new Node(30));
        printLinedList(head);

        insertAfterANode(head,2,122);

        printLinedList(head);

        head = reverseLinkedList(head);

        printLinedList(head);
    }
}
