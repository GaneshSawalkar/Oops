package com.bridgelabz.fellowship.linkedlist;

import com.bridgelabz.fellowship.linkedlist.Linkedlist.*;

public class Stack<T> {
	Linkedlist<T> s = new Linkedlist<T>();;

	public void push(T data) {
		s.insert(data); // add node in stack

	}

	@SuppressWarnings("rawtypes")
	public Node gethead() {
		return s.getHead(); // get head position
	}

	public T pop() {
		return s.pop(); // delete top of stack
	}

	public T peek() {
		if (s.size() == 1) {
			return s.peek(0); // get top of stack value
		}
		return s.peek(s.size() - 1);
	}

	public boolean isEmpty() {
		return s.isEmpty(); // check stack empty or not
	}

	public int size() {
		return s.size(); // check size of stack
	}

	public void show() {
		s.show(); // display all stack
	}

	public void reverse() {
		s.RecursiveReverseList(s.getHead()); // Reverse stack value
	}

}
