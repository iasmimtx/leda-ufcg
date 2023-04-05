package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (isValidation(array, leftIndex, rightIndex)) {
			boolean trocou = true;
			while (trocou) {
				trocou = false;
				for (int i = leftIndex; i < rightIndex; i++) {
					if (array[i].compareTo(array[i + 1]) > 0) {
						Util.swap(array, i, i + 1);
						trocou = true;
					}

				}
			}
		}
	}

	private boolean isValidation(T[] array, int leftIndex, int rightIndex) {
		boolean result = true;
		if(leftIndex > rightIndex || leftIndex < 0 || rightIndex < 0 ||  rightIndex > array.length || array.equals(null)) result = false;
		return result;
	}

}
