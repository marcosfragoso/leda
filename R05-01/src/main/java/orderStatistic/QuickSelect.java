package orderStatistic;

import util.Util;

/**
 * O quickselect eh um algoritmo baseado no quicksort para
 * descobrir/selectionar, em tempo linear, a k-esima estatistica de ordem
 * (k-esimo menor elemento) de um conjunto de dados.
 *
 * O quiskselect escolhe um elemento para ser o pivot e particiona o array
 * inicial em dois subarrays da mesma forma que o quicksort (elementos menores
 * que o pivot a esquerda do pivot e elementos maiores que o pivot a direita
 * dele). Entretanto, ao inves de chamar o quicksort recursivo nas duas metades,
 * o quickselect eh executado (recursivamente) apenas na metade que contem o
 * elemento que ele procura (o k-esimo menor elemento). Isso reduz a
 * complexidade de O(n.log n) para O(n)
 *
 * @author adalberto e campelo
 *
 */
public class QuickSelect<T extends Comparable<T>> {

	/**
	 * O algoritmo quickselect usa a mesma abordagem do quicksort para calcular o
	 * k-esimo menor elemento (k-esima estatistica de ordem) de um determinado
	 * array de dados comparaveis. Primeiro ele escolhe um elemento como o pivot
	 * e particiona os dados em duas partes, baseando-se no pivot (exatemente da
	 * mesma forma que o quicksort). Depois disso, ele chama recursivamente o
	 * mesmo algoritmo em apenas uma das metades (a que contem o k-esimo menor
	 * elemento). Isso reduz a complexidade de O(n.log n) para O(n).
	 *
	 * Caso o array seja vazio ou a ordem (posicao) do elemento desejado esteja
	 * fora do tamanho do array, o metodo deve retornar null.
	 *
	 *
	 * @param array
	 *            o array de dados a procurar o k-esimo menor elemento
	 *            este array normalmente nao esta ordenado
	 * @param k
	 *            a ordem do elemento desejado. 1 significa primeiro menor
	 *            elemento, 2 significa segundo menor elemento e assim por
	 *            diante
	 * @return
	 *
	 */
	public T quickSelect(T[] array, int k) {
		T resp = null;
		if (array != null && array.length > 0 && k > 0 && k <= array.length) {
			resp = recursiveQuickSelect(array, 0, array.length - 1, k);
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
	
	private T recursiveQuickSelect(T[] array, int leftIndex, int rightIndex, int k) {
		if (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex >= 0 && rightIndex <= (array.length - 1)) {
			int pivot = partition(array, leftIndex, rightIndex); // escolhendo o pivot
			if (leftIndex < rightIndex) {
				// particionando o algoritmo onde contém a k-esima metade (OBS: CHAMAR APENAS UMA VEZ)
				if (pivot + 1 > k) {
					return recursiveQuickSelect(array, leftIndex, pivot - 1, k); // k na primeira metade
				} else if (pivot + 1 < k){
					return recursiveQuickSelect(array, pivot + 1, rightIndex, k); // k na segunda metaded
				}			
			}
			return array[pivot];
		}
		return array[k - 1];
	}
}