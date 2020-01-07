package com.bridgelabz.felloship.linkedlist;

import com.bridgelabz.felloship.linkedlist.linkedlist.*;
public class Stack<T> {
	linkedlist<T> s = new linkedlist<T>();;

	/*
	 * public void Stack() { s = }
	 */

	public void push(T data) {
		s.insert(data);

	}

	@SuppressWarnings("rawtypes")
	public Node gethead() {
		return s.getHead();
	}

	public T pop() {
		return s.pop();
	}

	public T peek() {
		// T position = s.pop();
		// s.insert(position);
		if (s.size() == 1) {
			return s.peek(0);
		}
		return s.peek(s.size()-1);
	}

	public boolean isEmpty() {
		return s.isEmpty();
	}

	public int size() {
		return s.size();
	}

	public void show() {
		s.show();
	}

	public void reverse() {
		s.RecursiveReverseList(s.getHead());
	}

}
