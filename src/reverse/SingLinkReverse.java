package src.reverse;

public class SingLinkReverse {
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

    private void printData(Node node){
        if (node==null){
            return;
        }
        Node temp=node;
        while (temp!=null){
            System.out.print(temp.data);
            temp=temp.next;
        }
        System.out.println();
    }

    //正常倒序算法
    private Node reverseData(Node node){
        Node temp=node;
        Node prev=null;
        Node front=null;

        while (temp!=null){
            prev=temp.next;
            temp.next=front;
            front=temp;
            temp=prev;
        }
        return front;
    }

    //递归倒序
    private Node recursionReverseData(Node node){

        if (node.next==null){
            return node;
        }
        Node temp=node.next;
        node.next=null;
        Node pre = recursionReverseData(temp);
        temp.next=node;
        return  pre;
    }

    public static void main(String[] args){
        SingLinkReverse singLinkReverse=new SingLinkReverse();
        nextNode = singLinkReverse.insertNode(1);
        nextNode=singLinkReverse.insertNode(2);
        nextNode=singLinkReverse.insertNode(3);
        nextNode = singLinkReverse.insertNode(4);
        nextNode=singLinkReverse.insertNode(5);
        nextNode=singLinkReverse.insertNode(6);
        singLinkReverse.printData(head);
        Node reverse=singLinkReverse.reverseData(head);
        singLinkReverse.printData(reverse);
        Node recursionData = singLinkReverse.recursionReverseData(reverse);
        singLinkReverse.printData(recursionData);
    }

}

class Node{
    Node next;
    int data;

    public Node(int data){
        this.data=data;
    }

}