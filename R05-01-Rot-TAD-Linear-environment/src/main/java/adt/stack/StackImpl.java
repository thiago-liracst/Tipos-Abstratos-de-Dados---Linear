package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		T result;

		if (isEmpty()) {
			result = null;
		} else {
			result = this.array[top];
		}

		return result;
	}

	@Override
	public boolean isEmpty() {
		boolean result = false;

		if (this.top==-1) {
			result = true;
		}

		return result;
	}

	@Override
	public boolean isFull() {
		boolean result = false;

		if (this.top==array.length-1) {
			result = true;
		}

		return result;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (this.isFull()) {
			throw new StackOverflowException();
		}
		this.top++;
		this.array[top] = element;
		
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (this.isEmpty()) {
			throw new StackUnderflowException();
		}
		T result = this.array[top];
		this.top--;
		return result;
	}

}
