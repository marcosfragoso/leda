package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.getHead().isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> auxHead = this.getHead();
		while (!auxHead.isNIL()) {
			size++;
			auxHead = auxHead.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> auxHead = this.getHead();
		while (!auxHead.isNIL() && auxHead.getData() != element) {
			auxHead = auxHead.getNext();
		}
		return auxHead.getData();
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> auxHead = this.getHead();
		if (this.isEmpty()) {
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, this.getHead());
			this.setHead(newHead);
		} else {
			while(!auxHead.isNIL()) {
				auxHead = auxHead.getNext();
			}
			auxHead.setData(element);
			auxHead.setNext(new SingleLinkedListNode<>());
		}
	}

	@Override
	public void remove(T element) {
		if (this.getHead().getData().equals(element)) {
			this.setHead(getHead().getNext());
		} else {
			SingleLinkedListNode<T> auxHead = this.getHead();
			while (!auxHead.isNIL() && auxHead.getData() != element) {
				auxHead = auxHead.getNext();
			}
			if (!auxHead.isNIL()) {
				auxHead.setData(auxHead.getNext().getData());
				auxHead.setNext(auxHead.getNext().getNext());
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Comparable[size()];
		SingleLinkedListNode<T> auxHead = this.getHead();
		int index = 0;

		while (!auxHead.isNIL()) {
			array[index++] = auxHead.getData();
			auxHead = auxHead.getNext();
		}
		return array;

	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
