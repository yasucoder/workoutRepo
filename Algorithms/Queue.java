package com.room.datastructure;

public class Queue {
	
	private int front,rear,size;
	private int capacity;
	int[] queue = null;
	
	Queue(int capa){
		queue = new int[capa];
		front = size = 0;
		capacity = capa;
		rear = capacity - 1;
	}
	
	boolean isQueueFull(){		
		if(size == capacity)
			return true;
		return false;
	}
	boolean isQueueEmpty(){		
		if(size == 0)
			return true;
		return false;
	}
	void enqueue(int value){
		if(isQueueFull()){
			return;
		}
		
		rear = (rear+1)%capacity;
		queue[rear] = value;
		size++;
	}
	
	int dequeue(){
		int value;
		if(size == 0){
			System.out.println("queue is empty");
			return -1;
		}
		value = queue[front];
		front = (front +1)%capacity;
		size--;
		return value;
	}
	
	int front(){
		if (size == 0){
			System.out.println("queue is empty");
			return -1;
		}
			
		return queue[front];
	}
	
	int rear(){
		if (size == 0){
			System.out.println("queue is empty");
			return -1;
		}
			
		return queue[rear];
	}
	
	public static void main (String[] arg){
		Queue que = new Queue(5);
		que.enqueue(10);
		que.enqueue(20);
		que.enqueue(30);
		
		System.out.println(Integer.toString(que.front()));
		System.out.println(Integer.toString(que.rear()));
		
		while (!que.isQueueEmpty()){
			System.out.println(Integer.toString(que.dequeue()));
		}
	}

}
