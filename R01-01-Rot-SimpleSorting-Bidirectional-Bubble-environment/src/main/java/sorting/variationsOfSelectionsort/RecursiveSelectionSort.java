package sorting.variationsOfSelectionsort;



import sorting.AbstractSorting;

import sorting.simpleSorting.SelectionSort;
import sorting.variationsOfBubblesort.RecursiveBubbleSort;
import util.Util;

import java.util.Arrays;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (validation(array, leftIndex, rightIndex)) {
			if (leftIndex < rightIndex) {
				int minIndex = findMinIndex(array, leftIndex, rightIndex);
				Util.swap(array, leftIndex, minIndex);
				sort(array, leftIndex + 1, rightIndex);
			}
		}
	}

	private int findMinIndex(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex == rightIndex) return leftIndex;
		int nextMinIndex = findMinIndex(array, leftIndex + 1, rightIndex);
		if (array[leftIndex].compareTo(array[nextMinIndex]) < 0) return leftIndex;
		return nextMinIndex;
	}

	private boolean validation(T[] array, int leftIndex, int rightIndex) {
		boolean resp = true;
		if (array == null || leftIndex > rightIndex || leftIndex < 0 || rightIndex < 0 || rightIndex > array.length - 1) {
			resp = false;
		}
		return resp;
	}

	public static void main(String[] args) {
		Integer[] array = {5, 9, 1, 8, 3, 6, 2, 7, 10, 4};
		System.out.println(Arrays.toString(array));
		RecursiveSelectionSort<Integer> r1 = new RecursiveSelectionSort<>();
		r1.sort(array);
		System.out.println(Arrays.toString(array));
	}
}
