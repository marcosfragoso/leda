package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex <= rightIndex && leftIndex >= 0 && rightIndex >= 0 && rightIndex <= (array.length - 1)) {
			int maior = array[leftIndex];
			int menor = array[leftIndex];
			for (int i = leftIndex + 1; i <= rightIndex; i++) {
				if(array[i] > maior) {
					maior = array[i];
				}
				if(array[i] < menor) {
					menor = array[i];
				}
			}
			// 1º passo: cria um array int de tamanho k (maior elemento) + 1 - o menor elemnto (por causa dos numeros negativos) registrando a freq
			int[] C = new int[maior + 1 - menor];

			// 2º passo: itera de left até right e faz C[array[i] - menor] += 1
			for (int i = leftIndex; i <= rightIndex; i++) {
				C[array[i] - menor] += 1;
			}
	
			// 3º passo: itera de left + 1 ate len(C) e faz C[i] += C[i - 1] (soma cumulativa)
			for (int i = leftIndex + 1; i < C.length; i++) {
				C[i] = C[i] + C[i - 1];
			}
	
			// 4º passo: cria o array B do tamanho de array
			int[] B = new int[array.length];
			// itera do right ao left e faz: B[C[array[i] - menor] - 1] = array[i] e C[array[i] - menor] -=1
			for (int i = rightIndex; i >= leftIndex; i--) {
				B[C[array[i] - menor] - 1] = array[i];
				C[array[i] - menor] -= 1;
			}
	
			// passando os elementos para o array original
			for (int i = 0; i < array.length; i++) {
				array[i] = B[i - leftIndex];
			}
		}
	}

}
