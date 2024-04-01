package sorting.divideAndConquer.quicksort3;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

			
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex <= rightIndex && leftIndex >= 0 && rightIndex >= 0 && rightIndex <= (array.length - 1)) {
			if (leftIndex < rightIndex) {
				int middleIndex = (rightIndex + leftIndex) / 2;
				T[] compareElements = (T[]) new Comparable[] {array[leftIndex], array[middleIndex], array[rightIndex]}; // passo 1: comparando os 3 elementos
				quickSort(compareElements, 0, 2); // passo 2: ordenando ded forma que o pivot fique no centro
				T pivot = compareElements[1]; // passo 3: pegando o elemento que é o pivot
				int indexPivot = findPosition(array, pivot, 0); // passo 4: pegando o índice do pivot
				Util.swap(array, indexPivot, rightIndex - 1); // passo 4: colocando o pivot na penultima posição
				quickSort(array, leftIndex, rightIndex); // passo 5 e 6: aplicando o algoritmo quick sort		
			}
		}
	}


	public void quickSort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex <= rightIndex && leftIndex >= 0 && rightIndex >= 0 && rightIndex <= (array.length - 1)) {
			if (leftIndex < rightIndex) {
				int pivot = partition(array, leftIndex, rightIndex);
				quickSort(array, leftIndex, pivot - 1);
				quickSort(array, pivot + 1, rightIndex);
			}
		}
	}


	private int findPosition(T[] array, T element, int index) {
		int resp = -1;
		if (index < array.length) {
			if (array[index].equals(element)) {
				resp = index;
			} else {
				resp = findPosition(array, element, index + 1);
			}
		}
		return resp;
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
