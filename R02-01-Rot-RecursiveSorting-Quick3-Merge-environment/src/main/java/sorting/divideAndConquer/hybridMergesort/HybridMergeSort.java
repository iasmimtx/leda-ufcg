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
		if(isValidation(array, leftIndex, rightIndex)){
			if ((leftIndex + rightIndex) + 1 <= SIZE_LIMIT) {
				this.insertionSort(array, leftIndex, rightIndex);
				INSERTIONSORT_APPLICATIONS++;
			} else {
				if (leftIndex < rightIndex) {
					int middle = (leftIndex + rightIndex) / 2;
					this.sort(array, leftIndex, middle);
					this.sort(array, middle + 1, rightIndex);
					this.merge(array, leftIndex, middle, rightIndex);
					MERGESORT_APPLICATIONS++;
				}
			}
		}
	}

	private void merge(T[] array, int leftIndex, int meio, int rightIndex) {
		T[] helper = array.clone();
		int i = leftIndex;
		int j = meio + 1;
		int k = leftIndex;

		while(i <= meio && j <= rightIndex){
			if(helper[i].compareTo(helper[j]) <= 0) {
				array[k++] = helper[i++];
			} else {
				array[k++] = helper[j++];
			}
		}

		while(i <= meio) {
			array[k++] = helper[i++];
		}

		while(j <= rightIndex){
			array[k++] = helper[j++];
		}
	}

	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		for(int i = leftIndex + 1; i <= rightIndex; i++){
			int j = i;
			while(j > 0 && array[j].compareTo(array[j-1]) <= 0) {
				Util.swap(array, j, j-1);
				j--;
			}
		}
	}
	private boolean isValidation(T[] array, int leftIndex, int rightIndex) {
		return leftIndex < rightIndex && array != null &&  array.length > 1 && leftIndex >= 0 && rightIndex <= array.length-1;
	}
}
