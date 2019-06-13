package src.LinkedList;

/**
 * 删除链表倒数第 n 个结点
 */
public class DelnLinkedList {
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

    private void deleteNNode(Node node,int n){
        if (node==null){
            return;
        }
        Node nNode=node;
        Node temp=node;
        for (int i = 0; i <n ; i++) {
            if (nNode.next==null){
                return;
            }
            nNode=nNode.next;
        }

        while (nNode.next!=null){
            temp=temp.next;
            nNode=nNode.next;
        }
       temp.next=temp.next.next;
    }

    public static void main(String[] args){
        DelnLinkedList linkedList=new DelnLinkedList();
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
        Node.printData(head);

        //linkedList.deleteNNode(head,1);
        linkedList.deleteNNode(head,4);
       // linkedList.deleteNNode(head,9);
        Node.printData(head);


    }
}
