
package myutil;

import myutil.Node;

public class CommonMethods<E> {

	private Node<E> node = null;
	private int Size;

	public Node<E> getNode() {
		return this.node;

	}

	public void stackSize(int index) {
		this.Size = this.Size + index;

	}

	public void setNode(Node<E> node) {
		this.node = node;
	}

	public boolean isEmpty() {

		return this.node == null;

	}

	public int size() {

		return this.Size;

	}

}
