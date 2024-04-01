package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {
		
	}

	@Override
	public void insertFirst(T element) {
		if (this.isEmpty()) {
			this.insert(element);
		} else {
			RecursiveDoubleLinkedListImpl<T> auxNode = new RecursiveDoubleLinkedListImpl<>();
			auxNode.setData(this.getData());
			this.setData(element);
			auxNode.setNext(this.getNext());
			this.setNext(auxNode);
			auxNode.setPrevious(this);
			((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(auxNode);
		}
		
	}

	@Override
	public void insert(T element) {
		if (this.isEmpty()) {
			this.setData(element);
			this.setNext(new RecursiveDoubleLinkedListImpl<>());
			if (this.getPrevious() == null) {
				this.setPrevious(new RecursiveDoubleLinkedListImpl<>());
			}
		} else {
			this.getNext().insert(element);
		}
	}

	@Override
	public void removeFirst() {
		if (this.getPrevious().isEmpty() && this.getNext().isEmpty()) {
			this.setData(null);
			this.setNext(null);
			this.setPrevious(null);
		} else {
			this.setData(this.getNext().getData());
			this.setNext(this.getNext().getNext());
			((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
		}
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty()) {
			if (this.getData().equals(element)) {
				if (this.getPrevious().isEmpty() && this.getNext().isEmpty()) {
					this.setData(null);
					this.setNext(null);
					this.setPrevious(null);
				} else {
					this.setData(this.getNext().getData());
					this.setNext(this.getNext().getNext());
					if (this.getNext() != null) {
						((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
					}
				}
			} else {
				this.getNext().remove(element);
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()) {
			if (this.getNext().isEmpty()) {
				this.setData(null);
				this.setNext(null);
				if (this.getPrevious().isEmpty()) {
					this.setPrevious(null);
				}
			} else {
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
