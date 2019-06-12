package src.LinkedList.palindrome;
/**
 *字符串通过单链表来存储，判断是一个回文串
 *思路：
 *1.使用快慢两个指针找到链表中间节点
 *2.从中间节点对后半部分逆序
 *3.前后半部分比较，判断是否为回文
 *4.后半部分逆序复原
 */

class PalindromeDemo{
    private Node head;
    private static Node nextNode;
    int len;
    private void addNodes(String data){
        Node newNode=new Node(data);
        if (head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }

    private Node addNode(String data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return head;
        }

        nextNode.next=newNode;
        return newNode;
    }

    private void printData(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    //获取中间节点
    private Node getMiddleNode(){
        if(head==null){
            System.out.println("链表为空");
            return null;
        }
        if(head.next==null){
            System.out.println("链表只有一个数据");
            return null;
        }
        Node fastNode=head;
        Node slowNode=head;
        while(fastNode.next!=null && fastNode.next.next!=null){
            fastNode=fastNode.next.next;
            slowNode=slowNode.next;
        }

        return slowNode;
    }

    //从中间节点对后半部分逆序 遍历逆序
    private void reverseNode(Node node){
        Node temp=node.next;//相当于头结点
        Node prev=null;
        Node front=null;
        while(temp!=null){
            prev=temp.next;//设置prev是temp结点的后续结点，即用prev来保持temp的后继结点
            temp.next=front;//逆转，使temp.next指向temp的前驱结点
            front=temp;//front向后移一步
            temp=prev;//temp向后移一步
        }
        node.next=front;//head指向原链表的最后一个结点，完成逆转
    }


    //前后部分比较
    private boolean compareNode(Node node){
        Node temp=node.next;
        Node pretemp=head;
        while(temp!=null){
            if((pretemp.data).equals(temp.data)){
                temp=temp.next;
                pretemp=pretemp.next;
            }else{
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        PalindromeDemo pal=new PalindromeDemo();
        nextNode=pal.addNode("0");
        nextNode=pal.addNode("1");
        nextNode=pal.addNode("2");
        nextNode=pal.addNode("3");
        nextNode=pal.addNode("4");
        // nextNode=pal.addNode("4");
        nextNode=pal.addNode("3");
        nextNode=pal.addNode("2");
        nextNode=pal.addNode("1");
        nextNode=pal.addNode("0");
        pal.printData();
        Node middleNode=pal.getMiddleNode();
        System.out.println("中间节点数据为："+middleNode.data);
        System.out.println("中间节点下一个节点数据为："+middleNode.next.data);
        pal.reverseNode(middleNode);
        pal.printData();
        boolean flag=pal.compareNode(middleNode);
        if(flag){
            System.out.println("是回文序列");
        }else{
            System.out.println("不是回文序列");
        }
        pal.reverseNode(middleNode);
        pal.printData();
    }
}

class Node{
    Node next=null;//下一个节点
    String data;

    Node(String data){
        this.data=data;
    }
    Node(Node next,String data){
        this.next=next;
        this.data=data;
    }
}
