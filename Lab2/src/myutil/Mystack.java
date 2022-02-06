package myutil;

import myutil.Node;

public class Mystack<E> extends CommonMethods<E> {

	public void push(E element) {

		if (this.getNode() != null) {
			
			
			
			Node<E> temp = new Node<E>(element);
			temp.setNext(this.getNode());
			this.setNode(temp);
			this.stackSize(1);
			
		} else {

			this.setNode(new Node<E>(element));
			this.stackSize(1);

		}

	}

	public E peek() throws EmptyStackException {
		if (!this.isEmpty()) {
			return this.getNode().getData();
		} else
			throw new EmptyStackException();
	}

	public E pop() throws EmptyStackException {

		if (!this.isEmpty()) {

			E temp = this.getNode().getData();
			this.setNode(this.getNode().getNext());
			this.stackSize(-1);
			return temp;
		}

		else {

			throw new EmptyStackException();

		}

	}

}
