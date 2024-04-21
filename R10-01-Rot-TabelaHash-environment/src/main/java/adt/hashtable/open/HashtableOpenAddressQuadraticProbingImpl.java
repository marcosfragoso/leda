package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (this.isFull()) throw new HashtableOverflowException();
		if (this.search(element) == null) {
			int probe = 0;
			int hash = ((HashFunctionQuadraticProbing<T>) this.getHashFunction()).hash(element, probe);
			while (this.table[hash] != null && !this.table[hash].equals(this.deletedElement) && probe < this.capacity()) {
				probe++;
				hash = ((HashFunctionQuadraticProbing<T>) this.getHashFunction()).hash(element, probe);
				this.COLLISIONS++;
			}
			this.table[hash] = element;
			this.elements++;
		}
	}

	@Override
	public void remove(T element) {
		int index = this.indexOf(element);
		if (index != -1) {
			this.table[index] = this.deletedElement;
			this.elements--;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T search(T element) {
		T resp = null;
		int index = this.indexOf(element);
		if (index != -1) resp = (T) this.table[index];
		return resp;
	}

	@Override
	public int indexOf(T element) {
		int index = -1;
		if (!this.isEmpty()) {
			int probe = 0;
			int hash = ((HashFunctionQuadraticProbing<T>) this.getHashFunction()).hash(element, probe);
			while (this.table[hash] != null && !this.table[hash].equals(element) && probe < this.capacity()) {
				probe++;
				hash = ((HashFunctionQuadraticProbing<T>) this.getHashFunction()).hash(element, probe);
			}
			if (this.table[hash] != null && this.table[hash].equals(element)) {
				index = hash;
			}
		}
		return index;
	}
}
