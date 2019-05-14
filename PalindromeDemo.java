/**
*�ַ���ͨ�����������洢���ж���һ�����Ĵ�
*˼·��
*1.ʹ�ÿ�������ָ���ҵ������м�ڵ�
*2.���м�ڵ�Ժ�벿������
*3.ǰ��벿�ֱȽϣ��ж��Ƿ�Ϊ����
*4.��벿������ԭ
*/
class PalindromeDemo{
	Node head;
	static Node nextNode;
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
	  return;
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

    //��ȡ�м�ڵ�
	private Node getMiddleNode(){
		if(head==null){
		  System.out.println("����Ϊ��");
		  return null;
		}
		if(head.next==null){
		  System.out.println("����ֻ��һ������");
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

    //���м�ڵ�Ժ�벿������
	private void reverseNode(Node node){
		Node temp=node.next;//�൱��ͷ���
		Node prev=null;
		Node front=null;
	  while(temp!=null){
		prev=temp.next;//����prev��temp���ĺ�����㣬����prev������temp�ĺ�̽��
		temp.next=front;//��ת��ʹtemp.nextָ��temp��ǰ�����
		front=temp;//front�����һ��
		temp=prev;//temp�����һ��
	  }
	  node.next=front;//headָ��ԭ��������һ����㣬�����ת  
	}



    //ǰ�󲿷ֱȽ�
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
	   System.out.println("�м�ڵ�����Ϊ��"+middleNode.data);
	   System.out.println("�м�ڵ���һ���ڵ�����Ϊ��"+middleNode.next.data);
	   pal.reverseNode(middleNode);
	   pal.printData();
	   boolean flag=pal.compareNode(middleNode);
	   if(flag){
	     System.out.println("�ǻ�������");
	   }else{
	     System.out.println("���ǻ�������");
	   }
       pal.reverseNode(middleNode);
       pal.printData();
	}
}

class Node{
	Node next=null;//��һ���ڵ�
	String data;

	Node(String data){
	 this.data=data;
	}
	Node(Node next,String data){
	 this.next=next;
	 this.data=data;
	}
}
