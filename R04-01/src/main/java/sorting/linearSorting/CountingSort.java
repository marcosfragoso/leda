package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex <= rightIndex && leftIndex >= 0 && rightIndex >= 0 && rightIndex <= (array.length - 1)) {
			int maior = array[leftIndex];
			for (int i = leftIndex + 1; i <= rightIndex; i++) {
				if(array[i] > maior) {
					maior = array[i];
				}
			}
			// 1º passo: cria um array int de tamanho k (maior elemento) + 1 (por causa do 0) registrando a freq
			int[] C = new int[maior + 1];

			// 2º passo: itera de left até o right e faz C[array[i]] += 1
			for (int i = leftIndex; i <= rightIndex; i++) {
				C[array[i]] += 1;
			}
	
			// 3º passo: itera de 1 ate len(C) e faz C[i] += C[i - 1] (soma cumulativa)
			for (int i = leftIndex + 1; i < C.length; i++) {
				C[i] = C[i] + C[i - 1];
			}
	
			// 4º passo: cria o array B do tamanho de array
			int[] B = new int[array.length];
			// itera do right ao left e faz: B[C[array[i]] -1] = array[i] e C[array[i]] -=1
			for (int i = rightIndex; i >= leftIndex; i--) {
				B[C[array[i]] - 1] = array[i];
				C[array[i]] -= 1;
			}
	
			// passando os elementos para o array original
			for (int i = 0; i < array.length; i++) {
				array[i] = B[i - leftIndex];
			}
		}
	}
}
