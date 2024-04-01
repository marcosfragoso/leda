package sorting.variationsOfBubblesort;



import sorting.AbstractSorting;

import sorting.variationsOfSelectionsort.RecursiveSelectionSort;
import util.Util;

import java.util.Arrays;

public class RecursiveBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex <= rightIndex && leftIndex >= 0 && rightIndex >= 0 && rightIndex <= (array.length - 1)) {
			if (leftIndex < rightIndex) {
				if (array[leftIndex].compareTo(array[leftIndex + 1]) > 0) {
					Util.swap(array, leftIndex, leftIndex + 1);
				}
			}
			sort(array, leftIndex + 1, rightIndex);
			sort(array, leftIndex, rightIndex - 1);
		}	
	}
}
