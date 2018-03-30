package com.room.datastructure;

public class LinkedList {
	Node head = null;
	
	public class Node{
		int data;
		Node next;
		
		Node(int val){
			data = val;
			next = null;
		}
		
		
	}
	
	void add(int value){
		Node node = new Node(value);
		
		if(head == null)
			head = node;
		else
		{
			//travel to the end
			Node tempNode = head;
			while(tempNode.next != null){
				tempNode = tempNode.next;				
			}
			tempNode.next = node;
		}
	}
	
	void printList(){
		
		//travel to the end
		Node tempNode = head;
		while(tempNode != null){
			System.out.println(Integer.toString(tempNode.data));
			tempNode = tempNode.next;				
		}
			
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.add(100);
		list.add(200);
		list.add(300);
		
		
		list.printList();
	}

}
