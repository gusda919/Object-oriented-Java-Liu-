package myutil;

public class Mylist<E> extends CommonMethods<E> {

	private Node<E> newNode = new Node<>();

	public void add(E element) {

		if (this.getNode() != null) {

			Node<E> temp = new Node<E>(element);
			this.newNode.setNext(temp);
			this.newNode = this.newNode.getNext();
			this.stackSize(1);

		}

		else {

			this.setNode(new Node<E>(element));
			this.stackSize(1);
			this.newNode = this.getNode();

		}

	}

	public E getElementAt(int i) throws EmptyListException {

		if (!this.isEmpty() && (i < this.size())) {

			Node<E> temp = this.getNode();

			for (int j = 0; j < i; j++) {

				temp = temp.getNext();

			}

			return temp.getData();

		}


		else {

			throw new EmptyListException();

		}
	}

}
