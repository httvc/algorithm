/**
*LRU算法实现思路
*此数据在缓存中，遍历得到此数据，将此数据删除，然后再插入到链表的头部。
*此数据不在缓存中：
*    如果缓存数据已满，先删除链表尾结点，然后再将此数据插入到链表的头部。
*    如果缓存数据未满，直接将此数据插入到链表的头部
*/

import java.util.Scanner;
class LRUDemo {
	private int maxLength=4;//最大的缓存数量
	private int length=0;//实际长度
	private Node head=null;//头结点
    

    //添加结点 数据添加到后面 没有用到
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

	//删除结点  没有用到
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

    //获取长度，没有用到此方法
	private int getLength(){
	   Node temp=head;
	   int length=0;
	   while(temp!=null){
	     length++;
		 temp=temp.next;
	   }
	   return length;
	}
   
   //LRU算法
    private void LRUAlgorithm(int data){
		if (head==null){
			addData(data);
			return;
		}

		 if (head.data==data){
		  return;
	  }

      Node temp=findNode(data);
	 
	  if(temp==null){//链表中没有此数据
		 if(length>=maxLength){
			//如果缓存数据已满，先删除链表尾结点，然后再将此数据插入到链表的头部
			removeLastNode();
			addData(data);
		 }else{
			 //如果缓存数据未满，直接将此数据插入到链表的头部
			 addData(data);
		 }

	  }else{//链表中有此数据  先删除，再插入到链表头部
	    deleteData(temp);
		addData(data);
	  }
	}

	//获取元素的前一个结点
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


    //将元素添加到头结点
	private void addData(int data){
		Node newNode=new Node(data);
		Node temp=head;
		head=newNode;
		head.next=temp;
		length++;
	}


	//根据结点删除下一个元素
	private void deleteData(Node node){
		node.next=node.next.next;
		length--;
	}


    //删除最后一个结点
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

	//遍历链表
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
	Node next=null;//下一个结点
	int data;//结点数据

	Node(int data){
	  this.data=data;
	}
}
