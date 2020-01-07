package com.bridgelabz.felloship.linkedlist;

import com.bridgelabz.felloship.linkedlist.linkedlist.Node;

public class Queue<T> {

	linkedlist<T> queue = new linkedlist<T>();

	/*
	 * public void Queue() { queue = new linkedlist<T>(); }
	 */

	public void enqueue(T j) {
		queue.insert(j);
	}

	public void dequeue() {
		queue.DeleteAt(0);
	}

	public T Dequeue() {
		return queue.pop(0);
	}

	public T peek() {
		return queue.peek(0);
	}

	public T peekpop() {
		return queue.peekQueue(1);
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public int sizeQ() {
		return queue.size();
	}

	public void show() {
		queue.show();

	}

	@SuppressWarnings("rawtypes")
	public Node head() {
		return queue.getHead();
	}

}
