package src.LinkedList;

public class Node {
    Node next;
    int data;
    public Node(int data){
        this.data=data;
    }

    public Node(Node next,int data){
        this.next=next;
        this.data=data;
    }
    public static void printData(Node node){
        if (node==null){
            return;
        }
        Node temp=node;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}
