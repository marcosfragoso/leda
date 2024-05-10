package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer floor = null;
		for (Integer element : array) {
			this.insert(element);
		}
		floor = floor(numero, floor);
		return floor;
	}

	
	private Integer floor(double numero, Integer floor) {
		Integer root = this.extractRootElement();
		if (root != null) {
			if  (numero >= root && (floor == null || root >= floor)) {
				floor = floor(numero, root);
			} else {
				floor = floor(numero, floor);
			}
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer ceil = null;
		for (Integer element : array) {
			this.insert(element);
		}
		ceil = ceil(numero, ceil);
		return ceil;
	}

	private Integer ceil(double numero, Integer ceil) {
		Integer root = this.extractRootElement();
		if (root != null) {
			if  (numero <= root && (ceil == null || root <= ceil)) {
				ceil = ceil(numero, root);
			} else {
				ceil = ceil(numero, ceil);
			}
		}
		return ceil;
	}

}
