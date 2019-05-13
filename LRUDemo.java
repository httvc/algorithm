/**
*LRU�㷨ʵ��˼·
*�������ڻ����У������õ������ݣ���������ɾ����Ȼ���ٲ��뵽�����ͷ����
*�����ݲ��ڻ����У�
*    �������������������ɾ������β��㣬Ȼ���ٽ������ݲ��뵽�����ͷ����
*    �����������δ����ֱ�ӽ������ݲ��뵽�����ͷ��
*/

import java.util.Scanner;
class LRUDemo {
	private int maxLength=4;//���Ļ�������
	private int length=0;//ʵ�ʳ���
	private Node head=null;//ͷ���
    

    //��ӽ�� ������ӵ����� û���õ�
	private void addNode(int data){
	  Node newNode=new Node(data);
	  if (head==null){
		  head=newNode;
		  return;
	  }

	  Node temp=head;
	  while(temp.next !=null){
	    temp=temp.next;
	  }
	  temp.next=newNode;
	}

	//ɾ�����  û���õ�
	private void removeNode(int data){
		Node proNode=head;
		Node temp=head.next;
		while(temp !=null){
			if(temp.data!=data){
			  proNode=proNode.next;
			  temp=temp.next;
			}else{
			  proNode.next=temp.next;
			  break;
			}
		}
	}

    //��ȡ���ȣ�û���õ��˷���
	private int getLength(){
	   Node temp=head;
	   int length=0;
	   while(temp!=null){
	     length++;
		 temp=temp.next;
	   }
	   return length;
	}
   
   //LRU�㷨
    private void LRUAlgorithm(int data){
		if (head==null){
			addData(data);
			return;
		}

		 if (head.data==data){
		  return;
	  }

      Node temp=findNode(data);
	 
	  if(temp==null){//������û�д�����
		 if(length>=maxLength){
			//�������������������ɾ������β��㣬Ȼ���ٽ������ݲ��뵽�����ͷ��
			removeLastNode();
			addData(data);
		 }else{
			 //�����������δ����ֱ�ӽ������ݲ��뵽�����ͷ��
			 addData(data);
		 }

	  }else{//�������д�����  ��ɾ�����ٲ��뵽����ͷ��
	    deleteData(temp);
		addData(data);
	  }
	}

	//��ȡԪ�ص�ǰһ�����
	private Node findNode(int data){
	   Node temp=head;
	   while(temp.next!=null){
		  if(temp.next.data==data){
			System.out.println();
		    return temp;
		  }
		  temp=temp.next;
		   
	   }
       System.out.println();
	   return null;
	}


    //��Ԫ����ӵ�ͷ���
	private void addData(int data){
		Node newNode=new Node(data);
		Node temp=head;
		head=newNode;
		head.next=temp;
		length++;
	}


	//���ݽ��ɾ����һ��Ԫ��
	private void deleteData(Node node){
		node.next=node.next.next;
		length--;
	}


    //ɾ�����һ�����
	private void removeLastNode(){
		Node temp=head;
		if (temp.next==null){
			return;
		}
		
		while(temp.next.next!=null){
		  temp=temp.next;
		}
		Node pre=temp.next;
		temp.next=null;
		pre=null;
		length--;
		
	}

	//��������
	private void printLRU(){
	  Node temp=head;
	  while(temp!=null){
	   System.out.print(temp.data+" ");
	   temp=temp.next;
	  }
	  System.out.println();
	}


 	public static void main(String[] args) {

		LRUDemo lru=new LRUDemo();
		//lru.addNode(9);
		//lru.addNode(8);
		//lru.addNode(6);
		//lru.addNode(3);
		//lru.addNode(5);
		//lru.addNode(4);
		boolean flag=true;
		
		lru.LRUAlgorithm(9);
		lru.printLRU();
		lru.LRUAlgorithm(8);
		lru.printLRU();
		lru.LRUAlgorithm(6);
		lru.printLRU();
		lru.LRUAlgorithm(3);
		lru.printLRU();
		lru.LRUAlgorithm(5);
		lru.printLRU();
		lru.LRUAlgorithm(4);
		lru.printLRU();
		lru.LRUAlgorithm(3);
		lru.printLRU();
		lru.LRUAlgorithm(3);
		lru.printLRU();


	}

}

class Node{
	Node next=null;//��һ�����
	int data;//�������

	Node(int data){
	  this.data=data;
	}
}
