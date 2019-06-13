package src.LinkedList;

/**
 * 求链表的中间结点的值
 */
public class MiddleLinkedList {
    static Node head;
    static Node nodeNext;

    private Node insertNode(int data){
        Node newNode=new Node(data);
        if (head==null){
            head=newNode;
            return newNode;
        }
        nodeNext.next=newNode;
        return newNode;
    }

    private int MiddleNode(Node node){
        if (node==null){
            return 0;
        }

        if (node.next==null){
            return node.data;
        }
        Node slow=node;
        Node fast=node;

        while (slow.next!=null && fast!=null &&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }

    public static void main(String[] args){
        MiddleLinkedList linkedList=new MiddleLinkedList();
        nodeNext = linkedList.insertNode(1);
        nodeNext = linkedList.insertNode(2);
        nodeNext = linkedList.insertNode(3);
        nodeNext = linkedList.insertNode(4);
        nodeNext = linkedList.insertNode(5);
        nodeNext = linkedList.insertNode(6);
        nodeNext = linkedList.insertNode(7);
        nodeNext = linkedList.insertNode(8);
        nodeNext = linkedList.insertNode(9);
        nodeNext = linkedList.insertNode(10);
        nodeNext = linkedList.insertNode(11);
        Node.printData(head);

       System.out.println(linkedList.MiddleNode(head));
    }
}
