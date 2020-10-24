package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		if (isEmpty()) {
			this.head++;
			this.tail++;
		} else {
			this.tail = (this.tail+1) % this.array.length;
		}

		this.elements++;
		this.array[tail] = element;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		T result = array[head];

		if (this.head==this.tail) {
			this.head = -1;
			this.tail = -1;
		} else {
			this.head = (this.head+1) % this.array.length;
		}

		this.elements--;
		return result;
	}

	@Override
	public T head() {
		T result;

		if (isEmpty()) {
			result = null;
		} else {
			result = this.array[head];
		}

		return result;
	}

	@Override
	public boolean isEmpty() {
		boolean result = false;

		if (this.head==-1 && this.tail==-1) {
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

}
