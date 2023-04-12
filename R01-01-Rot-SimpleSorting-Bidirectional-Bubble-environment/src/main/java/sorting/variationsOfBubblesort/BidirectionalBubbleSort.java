package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (isValidation(array, leftIndex, rightIndex)) {
			while (leftIndex < rightIndex) {
				boolean trocou = false;

				for (int i = leftIndex; i < rightIndex; i++) {
					if (array[i].compareTo(array[i + 1]) > 0) {
						Util.swap(array, i, i + 1);
						trocou = true;
					}
				}

				for (int j = rightIndex - 1; j > leftIndex; j--) {
					if (array[j].compareTo(array[j - 1]) < 0) {
						Util.swap(array, j, j - 1);
						trocou = true;
					}
				}

				leftIndex++;
				rightIndex--;
				if (!trocou) {
					break;
				}
			}
		}
	}
	private boolean isValidation(T[] array, int leftIndex, int rightIndex) {
		boolean result = true;
		if ((leftIndex > rightIndex || leftIndex < 0 || rightIndex < 0 || rightIndex > array.length || array.equals(null)))
			result = false;
		return result;
	}
}
