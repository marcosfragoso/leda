package adt.linkedList;


public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<T>();
		this.last = (DoubleLinkedListNode<T>) head;
	}

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>();
		newHead.setData(element);
		newHead.setNext(this.getHead());
		newHead.setPrevious(new DoubleLinkedListNode<>());

		if (this.getHead().isNIL()) {
			this.setLast(newHead);
		}
		this.setHead(newHead);
	}

	@Override
	public void insert(T element) {
		
		DoubleLinkedListNode<T> auxLast = new DoubleLinkedListNode<>();
		auxLast.setData(element);
		auxLast.setPrevious(this.getLast());
		auxLast.setNext(new DoubleLinkedListNode<>());

		this.getLast().setNext(auxLast);

		if (this.getLast().isNIL()) {
			this.setHead(auxLast);
		}
		this.setLast(auxLast);
		
	}

	@Override
	public void removeFirst() {
		if (!this.getHead().isNIL()) {
			this.setHead(this.getHead().getNext());
			if (this.getHead().isNIL()) {
				this.setLast((DoubleLinkedListNode<T>) this.getHead());
			} else {
				((DoubleLinkedListNode<T>) this.getHead()).setPrevious(new DoubleLinkedListNode<>());
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.getLast().isNIL()) {
			this.setLast(this.getLast().getPrevious());
			if (this.getLast().isNIL()) {
				this.setHead(this.getLast());
			} else {
				this.getLast().setNext(new DoubleLinkedListNode<>());
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
