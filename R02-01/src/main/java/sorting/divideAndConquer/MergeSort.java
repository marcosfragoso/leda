package sorting.divideAndConquer;

import sorting.AbstractSorting;

import java.util.Arrays;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {


	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex <= rightIndex && leftIndex >= 0 && rightIndex >= 0 && rightIndex <= (array.length - 1)) {
			if (leftIndex >= rightIndex) {
				return;
			} else {
				int middle = (leftIndex + rightIndex) / 2;
				sort(array, leftIndex, middle);
				sort(array, middle + 1, rightIndex);
				merge(array, leftIndex, middle, rightIndex);
			}
		}
		
	}


	private void merge(T[] array, int leftIndex, int middle, int rightIndex) {
		T[] helper = (T[]) new Comparable[array.length];
		for (int i = leftIndex; i <= rightIndex; i++) {
			helper[i] = array[i];
		}

		int k = leftIndex;
		int i = leftIndex;
		int j = middle + 1;


		while (i <= middle && j <= rightIndex) {
			if (helper[i].compareTo(helper[j]) > 0) {
				array[k++] = helper[j++];
			} else {
				array[k++] = helper[i++];
			}

		}
		whileRecursive(array, helper, i, k, middle);
		whileRecursive(array, helper, j, k, middle);
	}


	private void whileRecursive(T[] array, T[] helper, int index, int k, int middle) {
		if (index <= middle) {
			array[k] = helper[index];
			whileRecursive(array, helper, index + 1, k + 1, middle);
		}
	}
}
