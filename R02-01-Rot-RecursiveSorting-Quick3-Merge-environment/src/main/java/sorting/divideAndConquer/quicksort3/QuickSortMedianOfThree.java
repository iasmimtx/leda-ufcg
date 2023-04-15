package sorting.divideAndConquer.quicksort3;

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
        if(isValidation(array, leftIndex, rightIndex)) {
            if (leftIndex < rightIndex) {
                int index_pivot = partition(array, leftIndex, rightIndex);
                sort(array, leftIndex, index_pivot - 1);
                sort(array, index_pivot + 1, rightIndex);
            }
        }
    }

    private int partition(T[] array, int leftIndex, int rightIndex) {
        ordena(array, leftIndex, rightIndex);

        int middle = (leftIndex + rightIndex) / 2;
        T pivot = array[middle];
        Util.swap(array, middle, rightIndex - 1);


        int i = leftIndex + 1;
        int j = rightIndex - 1;
        while (i < j) {
            if (array[i].compareTo(pivot) >= 0) {
                j--;
                Util.swap(array, i, j);
            } else {
                i++;
            }
        }
        Util.swap(array, rightIndex - 1, j);
        return j;
    }

    private void ordena(T[] array, int leftIndex, int rightIndex) {
        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            int j = i;
            while (j > 0 && array[j].compareTo(array[j - 1]) < 0) {
                Util.swap(array, j, j - 1);
                j--;
            }
        }
    }

    private boolean isValidation(T[] array, int leftIndex, int rightIndex) {
        return leftIndex < rightIndex && array != null &&  array.length > 1 && leftIndex >= 0 && rightIndex <= array.length-1;
    }
}
