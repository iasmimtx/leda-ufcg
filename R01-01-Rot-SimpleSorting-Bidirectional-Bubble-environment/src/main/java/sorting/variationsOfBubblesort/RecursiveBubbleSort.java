package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveBubbleSort<T extends Comparable<T>> extends
        AbstractSorting<T> {

    /**
     * Implementação recursiva do bubble sort. Você deve implementar apenas esse
     * método sem usar nenhum outro método auxiliar (exceto
     * Util.swap(array,int,int)). Para isso, tente definir o caso base do
     * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
     * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
     * quadrática O(n^2).
     */
    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {

        if (isValidation(array, leftIndex, rightIndex)) {
            if (leftIndex < rightIndex) {
                //percorre o array e troca os valores se nao tiverem na devida ordem.
                for (int i = leftIndex; i < rightIndex; i++) {
                    if (array[i].compareTo(array[i + 1]) > 0) Util.swap(array, i, i + 1);
                }

                //caso recursivo
                sort(array, leftIndex, rightIndex - 1);
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
