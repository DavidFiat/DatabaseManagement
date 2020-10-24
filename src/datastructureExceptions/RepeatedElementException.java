package datastructureExceptions;

public class RepeatedElementException extends Exception {

	public RepeatedElementException(Object a) {
		super("There is already an element with key " + a);
	}
}
