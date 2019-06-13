package src.LinkedList;

/**
 * 两个有序的链表合并
 */
public class MergeLinkedList {
    private Node merge(Node head1,Node head2){
        if (head1==null || head2==null){
           return head1==null? head2 : head1;
        }

        Node head3;
        if (head1.data<=head2.data){
            head3=head1;
            head1=head1.next;
        }else {
            head3=head2;
            head2=head2.next;
        }

        Node temp=head3;

        while (head1!=null && head2!=null){
            if (head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
            }else {
                temp.next=head2;
                head2=head2.next;
            }
            temp=temp.next;
        }

        if (head1==null){
            temp.next=head2;
        }
        if (head2==null){
            temp.next=head1;
        }
        return head3;
    }

    public static void main(String[] args){
        MergeLinkedList linkedList=new MergeLinkedList();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node3;
        node3.next = node5;
        node2.next = node4;

        Node node11=linkedList.merge(node1,node2);
        Node.printData(node11);

    }
}
