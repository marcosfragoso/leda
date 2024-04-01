package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		// Algoritmo de ordenação O(n.log n)
		quickSort(array, 0, array.length - 1);
		int last = array[array.length - 1];
		// Se o array for maior que o último elemento do array ordenado, retorne o último elemento
		if (x > last) return last;
		return search(array, x, 0, array.length);
	}

	private Integer search(Integer[] v, Integer x, int l, int r){
		if (l <= r) {
			int meio = (l + r) / 2;
			
			if (v[meio] == x) return v[meio];

			if (v[meio] < x && v[meio + 1] > x) return v[meio];
	
			if (x < v[meio])
				return search(v, x, l, meio - 1);
			else
				return search(v, x, meio + 1, r);
		} else {
			return null;
		}
	}

	private void quickSort(Integer[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex <= rightIndex && leftIndex >= 0 && rightIndex >= 0 && rightIndex <= (array.length - 1)) {
			if (leftIndex < rightIndex) {
				int pivot = partition(array, leftIndex, rightIndex);
				quickSort(array, leftIndex, pivot - 1);
				quickSort(array, pivot + 1, rightIndex);
			}
		}
	}

	private int partition(Integer[] array, int leftIndex, int rightIndex) {

		Integer pivot = array[leftIndex];
		int i = leftIndex;

		i = forRecursive(array, leftIndex, rightIndex, leftIndex + 1, pivot, i);

		swap(array, leftIndex, i);
		return i;
	}

	private int forRecursive(Integer[] array, int leftIndex, int rightIndex, int j, Integer pivot, int i) {
		int resp = i;
		if (j <= rightIndex) {
			if (array[j].compareTo(pivot) <= 0) {
				i++;
				swap(array, i, j);
			}
			resp = forRecursive(array, leftIndex, rightIndex, j + 1, pivot, i);
		}
		return resp;
	}
	
	
	public static void swap(Integer[] array, int i, int j) {
		Integer temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
