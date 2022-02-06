package myutil;

public class Node<E> {

	E data;
	private Node<E> next;

	public Node() {
		this.next = null;

	}

	public Node(E object) {
		this.data = object;
		this.next = null;

	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

}
