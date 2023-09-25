package day04;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;

public class SinglyLinkedList {
	static class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}
	Node head = new Node(0);

	void insert(int index, int value) {
		Node node = new Node(value);
		Node a = head;
		for (int i = 0; i < index; i++) {
			a = a.next;
			if (a == null) throw new NoSuchElementException();
		}
		node.next = a.next;
		a.next = node;
	}
	
	void delete(int index) {
		if (head.next == null) throw new NoSuchElementException();
		Node a = head;
		for (int i = 0; i < index; i++) {
			a = a.next;
			if (a == null) throw new NoSuchElementException();
		}
		a.next = a.next.next;
	}
	
	int get(int index) {
//		Node a = head;
//		for (int i = 0; i < index + 1; i++) {
//			a = a.next;
//			if (a == null) throw new NoSuchElementException();
//		}
//		return a.value;
//		
		Node node = head.next;
		while (node != null && index > 0) {
			index -= 1;
			node = node.next;
		}
		if (index > 0) throw new NoSuchElementException();
		return node.value;
	}
	
	void set(int index, int value) {
		Node a = head;
		for (int i = 0; i < index + 1; i++) {
			a = a.next;
			if (a == null) throw new NoSuchElementException();
		}
		a.value = value;
	}
	
	int find(int value) {
		Node a = head;
		int cnt = 0;
		while (a.next != null) {
			if (a.value == value) break;
			a = a.next;
			cnt++;
			if (a.next == null) cnt = -1;
		}
		return cnt;
		
//		Node a = head.next;
//		int index = 0;
//		while (a != null) {
//			if (a.value == value) return index;
//			a = a.next;
//			index++;
//		}
//		return -1;

	}
	
	int front() {
		if (head.next == null) throw new NoSuchElementException();
		return head.next.value;
	}
	
	int back() {
		if (head.next == null) throw new NoSuchElementException();
		Node a = head;
		while (a.next != null) {
			a = a.next;
		}
		return a.value;
	}
	
	void push_front(int value){
		var node = new Node(value);
		node.next = head.next;
		head.next = node;
	}
	
	void push_back(int value) {
		var node = new Node(value);
		Node a = head;
		while (a.next != null) {
			a = a.next;
		}
		a.next = node;
	}
	
	int pop_front() {
		if (head.next == null) throw new NoSuchElementException();
		int a = head.next.value;
		head.next = head.next.next;
		return a;
	}
	
	int pop_back() {
		if (head.next == null) throw new NoSuchElementException();
		Node a = head;
		Node s = head.next;
		while (s.next != null) {
			a = s;
			s = s.next;
		}
		a.next = null;
		return s.value;
	}
	
	boolean empty() {
		return head.next == null;
	}
	
	int length() {
		int cnt = 0;
		Node a = head;
		while (a.next != null) {
			a = a.next;
			cnt++;
		}
		return cnt;
	}
	
	void clear() {
		head.next = null;
	}
	
	void sort() {
		if (head.next == null) throw new NoSuchElementException();
//		Node a = head.next;
//		while (a.next != null){
//			Node b = head.next;
//			while(b.next != null) {
//				if (b.value > b.next.value) {
//					int change = b.value;
//					b.value = b.next.value;
//					b.next.value = change;
//				}
//				b = b.next;
//			}
//			a = a.next;
//		}
		
		Node i = head.next;
		while (i != null){
			Node node = head.next;
			while(node.next != null) {
				if (node.value > node.next.value) {
					int change = node.next.value;
					node.next.value = node.value;
					node.value = change;
				}
				node = node.next;
			}
			i = i.next;
		}
		
//		var node1 = this.head.next;
//		while (node1 != null) {
//			var node2 = node1.next;
//			while (node2 != null) {
//				if (node1.value > node2.value) {
//					var t = node1.value;
//					node1.value = node2.value;
//					node2.value = t;
//				}
//				node2 = node2.next;
//			}
//			System.out.printf("> ");
//			this.print();
//			node1 = node1.next;
//		}
	}
	
	void reverse() {
		if (head.next == null) throw new NoSuchElementException();
		Node f = new Node(0);
		Node h = head;
		while (h.next != null) {
			f.next = h.next;
			h = h.next;
		}
	}
	
	void print() {
		Node a = head.next;
		 while (a != null) {
			 System.out.printf("%3d", a.value);
			 a = a.next;
		 }
		 System.out.println();
	}
	
	public static void main(String[] args) {
		var sll = new SinglyLinkedList();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
//			sll.insert(i, r.nextInt(19) + 1);
			sll.insert(i, 10-i);
		}
		sll.print();
		sll.sort();
		sll.print();
		sll.reverse();
		sll.print();
		sll.insert(3, 40);
		sll.print();
		sll.delete(5);
		sll.print();
		System.out.println(sll.get(5));
		sll.set(5, 50);
		sll.print();
		System.out.println(sll.front());
		System.out.println(sll.back());
		sll.push_back(99);
		sll.push_front(0);
		sll.print();
		System.out.println(sll.pop_front());
		System.out.println(sll.pop_back());
		sll.print();
		System.out.println(sll.empty());
		System.out.println(sll.length());
		sll.clear();
		System.out.println(sll.empty());
		System.out.println(sll.length());
	}
}
