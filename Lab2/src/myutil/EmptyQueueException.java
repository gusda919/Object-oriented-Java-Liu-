package myutil;

public class EmptyQueueException extends RuntimeException {

	public EmptyQueueException() {

		super("end of queue is null");

	}

}
