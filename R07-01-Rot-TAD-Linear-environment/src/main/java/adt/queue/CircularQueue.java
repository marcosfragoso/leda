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

		if (!isFull()) {
			this.elements += 1;
		}

		if (isEmpty()) {
			this.head = 0;
		}

		this.tail = (this.tail + 1) % this.array.length;
		this.array[tail] = element;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) throw new QueueUnderflowException();
		T result = this.array[this.head];

		if (this.head == this.tail) {
			this.head = -1;
			this.tail = -1;
		} else {
			this.head = (this.head + 1) % this.array.length;
		}
		this.elements -= 1;
		return result;
	}

	@Override
	public T head() {
		T result = null;
		if (!isEmpty()) {
			result = this.array[this.head];
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		return this.head == -1 && this.tail == -1;
	}

	@Override
	public boolean isFull() {
		return ((this.tail + 1) % this.array.length) == this.head;
	}

}
