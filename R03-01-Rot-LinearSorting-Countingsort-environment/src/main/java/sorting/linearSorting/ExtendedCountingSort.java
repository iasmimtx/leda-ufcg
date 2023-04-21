package sorting.linearSorting;

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
        if (isValidation(array, leftIndex, rightIndex)) {
            int max = max(array, leftIndex, rightIndex);
            int min = min(array, leftIndex, rightIndex);


            int[] C = new int[max - min + 1];
            //frequencia
            for (int i = leftIndex; i <= rightIndex; i++) {
                C[array[i] - min] += 1;
            }

            //cumulativa
            for (int i = 1; i < C.length; i++) {
                C[i] += C[i - 1];
            }

            int[] B = new int[rightIndex - leftIndex + 1];

            for (int i = rightIndex; i >= leftIndex; i--) {
                B[C[array[i] - min] - 1] = array[i];
                C[array[i] - min] -= 1;
            }

            int indice = 0;
            for (int i = leftIndex; i <= rightIndex; i++) {
                array[i] = B[indice];
                indice++;

            }
        }
    }

    private boolean isValidation(Integer[] array, int leftIndex, int rightIndex) {
        return array != null && leftIndex >= 0 && leftIndex < rightIndex && rightIndex < array.length;
    }

    private int min(Integer[] array, int leftIndex, int rightIndex) {
        int min = leftIndex;
        //verificando qual é o número menor do array
        for (int i = leftIndex; i <= rightIndex; i++) {
            if (array[i] < min) min = array[i];
        }
        return min;
    }

    private int max(Integer[] array, int leftIndex, int rightIndex) {
        int max = leftIndex;
        //verificando qual é o número maior do array
        for (int i = leftIndex; i <= rightIndex; i++) {
            if (array[i] > max) max = array[i];
        }
        return max;
    }


}
