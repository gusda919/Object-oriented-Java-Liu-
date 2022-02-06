package myutil;

public class MyQueue<E> extends CommonMethods<E> {

	private Node<E> firstInQueue = new Node<>();

	public void enqueue(E element) {

		if (this.getNode() != null) {

			Node<E> temp = new Node<E>(element);
			this.firstInQueue.setNext(temp);
			this.firstInQueue = this.firstInQueue.getNext();
			this.stackSize(1);

		}

		else {

			this.setNode(new Node<E>(element));
			this.stackSize(1);
			this.firstInQueue = this.getNode();

		}

	}

	public E peek() throws EmptyStackException {
		if (!this.isEmpty()) {
			return this.getNode().getData();
		} else
			throw new EmptyStackException();
	}

	public E dequeue() {
		if (!this.isEmpty()) {

			E temp = this.getNode().getData();
			this.setNode(this.getNode().getNext());
			this.stackSize(-1);
			return temp;
		}

		else {

			throw new EmptyQueueException();

		}
	}
}
