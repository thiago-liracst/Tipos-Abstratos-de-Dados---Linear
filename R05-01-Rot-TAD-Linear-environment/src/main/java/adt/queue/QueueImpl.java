package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		T result;

		if (isEmpty()) {
			result = null;
		} else {
			result = this.array[0];
		}

		return result;
	}

	@Override
	public boolean isEmpty() {
		boolean result = false;

		if (this.tail==-1) {
			result = true;
		}

		return result;
	}

	@Override
	public boolean isFull() {
		boolean result = false;

		if (this.tail==array.length-1) {
			result = true;
		}

		return result;
	}

	private void shiftLeft() {
		for (int i = 0; i<this.tail; i++) {
			this.array[i] = this.array[i+1];
		}
		this.tail--;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		this.tail++;
		this.array[tail] = element;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		T result = this.array[0];
		shiftLeft();
		return result;
	}

}
