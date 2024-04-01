package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
        forRecursive(array, leftIndex, leftIndex, rightIndex);    		
	}

    private int findPosition(T[] array, T key, int i, int leftIndex) {
        int resp = i;
        if (i >= leftIndex && array[i].compareTo(key) > 0) {
            array[i + 1] = array[i];
            resp = findPosition(array, key, i - 1, leftIndex);
        }
        return resp;
    }

    private void forRecursive(T[] array, int last, int leftIndex, int rightIndex) {
        if (last >= leftIndex && last < rightIndex) {
            T key = array[last + 1];
            int next = findPosition(array, key, last, leftIndex);
            array[next + 1] = key;
            forRecursive(array, last + 1, leftIndex, rightIndex);
        }
    }
}
