package src.LinkedList;



public class IsCircleLinkedList {
    static Node head;
    static Node nextNode;

    private Node insertNode(int data){
        Node newNode=new Node(data);
        if (head==null){
            head=newNode;
            return newNode;
        }
        nextNode.next=newNode;
        return newNode;
    }

    private boolean isCirle(Node node){
        if (node==null){
            return false;
        }
        Node slow=node.next;
        Node fast=node.next.next;
        while (slow !=null &&fast!=null && fast.next !=null){
            if (slow==fast){
                return true;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return false;
    }
    public static void main(String[] args){
        IsCircleLinkedList linkedList=new IsCircleLinkedList();
        for (int i = 1; i <101 ; i++) {
            nextNode = linkedList.insertNode(i);
        }
       boolean flag= linkedList.isCirle(head);
        System.out.println(flag);
        nextNode.next=head;
        flag=linkedList.isCirle(head);
        System.out.println(flag);
       // Node.printData(head);

    }
}
