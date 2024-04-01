package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

import java.util.Arrays;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex <= rightIndex && leftIndex >= 0 && rightIndex >= 0 && rightIndex <= (array.length - 1)) {
			if (leftIndex < rightIndex) {
				int pivot = partition(array, leftIndex, rightIndex);
				sort(array, leftIndex, pivot - 1);
				sort(array, pivot + 1, rightIndex);
			}
		}
	}


	private int partition(T[] array, int leftIndex, int rightIndex) {

		T pivot = array[leftIndex];
		int i = leftIndex;

		i = forRecursive(array, leftIndex, rightIndex, leftIndex + 1, pivot, i);

		Util.swap(array, leftIndex, i);
		return i;
	}


	private int forRecursive(T[] array, int leftIndex, int rightIndex, int j, T pivot, int i) {
		int resp = i;
		if (j <= rightIndex) {
			if (array[j].compareTo(pivot) <= 0) {
				i++;
				Util.swap(array, i, j);
			}
			resp = forRecursive(array, leftIndex, rightIndex, j + 1, pivot, i);
		}
		return resp;
	} 
}
