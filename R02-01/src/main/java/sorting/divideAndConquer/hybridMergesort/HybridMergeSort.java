package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;


	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (rightIndex + 1 - leftIndex > SIZE_LIMIT) {
			mergeSort(array, leftIndex, rightIndex);
			MERGESORT_APPLICATIONS++;
		} else {
			insertionSort(array, leftIndex, rightIndex);
			INSERTIONSORT_APPLICATIONS++;
		}
	}


	public void insertionSort(T[] array, int leftIndex, int rightIndex) {
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


	private void mergeSort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex) {
			return;
		} else {
			int middle = (leftIndex + rightIndex) / 2;
			mergeSort(array, leftIndex, middle);
			mergeSort(array, middle + 1, rightIndex);
			merge(array, leftIndex, middle, rightIndex);
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
