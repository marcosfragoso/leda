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
		T result = null;
		if (!isEmpty()) {
			result = this.array[this.top];
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		return this.top == -1;
	}

	@Override
	public boolean isFull() {
		return this.top + 1 == this.array.length;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()) throw new StackOverflowException();
		this.top++;
		this.array[this.top] = element;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) throw new StackUnderflowException();
		T aux = this.array[this.top];
		this.top--;
		return aux;
	}

}
