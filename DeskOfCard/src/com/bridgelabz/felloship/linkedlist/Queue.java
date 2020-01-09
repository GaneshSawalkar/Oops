package com.bridgelabz.felloship.linkedlist;

import com.bridgelabz.felloship.linkedlist.linkedlist.Node;

public class Queue<T> {

	linkedlist<T> queue = new linkedlist<T>();

	public void enqueue(T j) {
		queue.insert(j); // add node
	}

	public void dequeue() {
		queue.DeleteAt(0); // delete first node
	}

	public T Dequeue() {
		return queue.pop(0); // delete first node
	}

	public T peek() {
		return queue.peek(0); // get first node value
	}

	public T peekpop() {
		return queue.peekQueue(0); // get first node value and pop it
	}

	public boolean isEmpty() {
		return queue.isEmpty(); // check is empty or not
	}

	public int sizeQ() {
		return queue.size(); // size of queue
	}

	public void show() {
		queue.show(); // show queue

	}

	@SuppressWarnings("rawtypes")
	public Node head() {
		return queue.getHead(); // get queue head position
	}

}
