package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * A mediana de uma colecao/array de valores é o valor que divide a coleção na metade.
 * A forma mais custosa de encontrar a mediana seria ordenar o array completo e
 * escolher o elemento do meio do array. Essa abordagem limita o tempo de execucao ao
 * tempo do algoritmo de ordenacao utilizado. Sabe-se que a mediana é um
 * excelente pivot para garantir um bom tempo de execução do quicksort.
 * <p>
 * Voce deve implementar o algoritmo do quicksort que seleciona a mediana dos
 * dados a serem ordenados como pivot. Utilize a estrategia de selection sort
 * para encontrar a mediana (sem modificar o array original). Depois use-a
 * como o pivot do quicksort.
 * <p>
 * Requisitos:
 * - Voce nao pode ordenar o array e escolher o elemento da metade
 * - Voce nao pode utilizar array extra (tem que ser in-place)
 * - O uso do selection eh apenas para encontrar a mediana, mas nao deve
 * modificar o array de forma alguma.
 */
public class QuickSortComMediana<T extends Comparable<T>> extends
        AbstractSorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int pivot_index = partition(array, leftIndex, rightIndex);
            sort(array, leftIndex, pivot_index - 1);
            sort(array, pivot_index + 1, rightIndex);
        }
    }

    private int partition(T[] array, int leftIndex, int rightIndex) {

        T pivot =mediana(array, leftIndex, rightIndex);
        int i = leftIndex;
        for (int j = leftIndex + 1; j <= rightIndex; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                Util.swap(array, i, j);
            }
        }
        Util.swap(array, leftIndex, i);
        return i;
    }

    public T mediana(T[] array, int leftIndex, int rightIndex) {
        int menor_index = leftIndex;
        int maior_index = leftIndex;
        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            if (array[i].compareTo(array[menor_index]) < 0) {
                menor_index = i;
            }
            if (array[i].compareTo(array[maior_index]) > 0) {
                maior_index = i;
            }
        }

    }


}
