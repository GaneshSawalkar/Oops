
package com.bridgelabz.felloship.linkedlist;

public class linkedlist<T> {
	Node<T> head;
	Node<T> current;
	int position;

	public linkedlist() {
		head = null;
		current = null;
		position = -1;
	}

	// insert new node
	public void insert(T data) {
		Node<T> node = new Node<T>(data);

		if (head == null) {
			head = node;
			current = head;
		} else {

			current.next = node;
			current = current.next;
		}
		position++;
	}

	// delete new node using index value
	public T pop(int location) {
		Node<T> tc = head;
		Node<T> tp = null;
		int pos = 0;
		position--;
		while (pos != location) {
			tp = tc;
			tc = tc.next;
			pos++;
		}
		if (tc == head) {
			head = head.next;
			return tc.data;
		} else if (tc == current) {
			current = tp;
			tp.next = tc.next;
			return tc.data;
		} else {
			tp.next = tc.next;
			return tc.data;
		}
	}

	// insert node at using index value
	public void insertAt(T data, int index) {
		Node<T> node = new Node<T>(data);
		if (index == 0) {
			node.next = head;
			head = node;
		} else {
			Node<T> n1 = head;
			for (int i = 0; i < index - 1; i++) {
				n1 = n1.next;
			}
			Node<T> temp = n1.next;
			n1.next = node;
			node.next = temp;

		}
	}

	// peek node using index
	public T peek(int location) {
		Node<T> n = head;
		int tempPosition = 0;
		while (tempPosition != location) {
			n = n.next;
			tempPosition++;
		}
		return n.data;
	}

	// check is empty or not
	public boolean isEmpty() {
		Node<T> n = head;
		if (n == null)
			return true; // not empty list

		return false; // empty list
	}

	// show list of size (position)
	public int size() {
		return position + 1;
	}

	// reverse linked list recursively
	public void RecursiveReverseList(Node<T> n) {
		if (n.next == null) {
			head = n;
			return;
		}
		RecursiveReverseList(n.next);
		Node<T> temp = n.next;
		temp.next = n;
		n.next = null;
	}

	// remove node
	public T pop() {
		return pop(position);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void DeleteAt(int index) {
		if (head == null)
			return;

		Node<T> temp = head;

		if (index == 0) {
			head = temp.next; // Change head
			return;
		}

		for (int i = 0; temp != null && i < index - 1; i++)
			temp = temp.next;

		if (temp == null || temp.next == null)
			return;

		Node next = temp.next.next;

		temp.next = next;
	}

	// find loop detection
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void RemoveLoop(Node<T> loop) {

		Node ptr1 = head, ptr2 = null;

		while (ptr1.next != null) {
			ptr2 = loop;
			while (ptr2.next != loop && ptr2.next != ptr1) {
				ptr2 = ptr2.next;
			}

			if (ptr2.next == ptr1) {
				break;
			}

			ptr1 = ptr1.next;
		}
		ptr2.next = null;
	}

	// get head of list
	public Node<T> getHead() {
		return head;
	}

	// search node using value of node
	public boolean search(T data) {
		Node<T> n = head;
		while (n.next != null && n.data != (data)) {
			n = n.next;
		}
		if (n.data == data) {
			return true;
		} else {
			return false;
		}
	}

	public int index(T data) {
		Node<T> n = head;
		int pos = 0;
		while (n != null && n.data != data) {
			pos++;
			n = n.next;

		}
		if (n.data == data) {
			return pos;
		} else {
			return -1;
		}
	}

	// display all list info
	public void show() {
		Node<T> n = head;
		if (n == null) {
			System.out.println("empty");
		} else {
			while (n.next != null) {
				System.out.print(n.data + "-->");
				n = n.next;
			}
			System.out.print(n.data);
		}

	}

	// generate list loop
	public void loop() {
		Node<T> n = head;
		while (n.next != null) {
			n = n.next;

		}
		n.next = head;

	}

	@SuppressWarnings("hiding")
	public class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	// remove stack of top position
	public Node<T> stackTop() {
		Node<T> n = head;
		Node<T> prev = n;
		while (n.next != null) {
			prev = n;
			n = n.next;
		}
		Node<T> temp = prev.next;
		prev.next = null;

		return temp;
	}

	// get first position of list
	public T peekQueue(int i) {
		Node<T> n = head;
		int counter = 0;
		while (n.next != null && counter != i) {
			n = n.next;
			counter++;
		}
		T temp = n.data;
		position--;
		DeleteAt(i);
		return temp;
	}

	// get last position of queue list
	public T peekStack(int i) {
		Node<T> n = head;
		int counter = 0;
		if (head == null)
			System.out.println("empty");
		if (i == 0) {
			T temp = n.data;
			head = null;
			position = -1;
			return temp;
		}
		while (n != null && counter != i - 1) {
			n = n.next;
			counter++;
		}
		T temp = n.next.data;
		n.next = null;
		position--;
		return temp;

	}

}
