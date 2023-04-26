package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
        AbstractSorting<T> {

    /**
     * Implementação recursiva do selection sort. Você deve implementar apenas
     * esse método sem usar nenhum outro método auxiliar (exceto
     * Util.swap(array,int,int)). Para isso, tente definir o caso base do
     * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
     * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
     * quadrática O(n^2).
     * <p>
     * <p>
     * A ordenação por seleção (do inglês, selection sort) é um algoritmo de ordenação baseado
     * em se passar sempre o menor valor do vetor para a primeira posição (ou o maior dependendo
     * da ordem requerida), depois o de segundo menor valor para a segunda posição, e assim é feito
     * sucessivamente com os n-1 elementos restantes, até os últimos dois elementos.
     */
    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int menor = leftIndex;
            for (int i = leftIndex + 1; i <= rightIndex; i++) {
                if (array[i].compareTo(array[menor]) < 0) {
                    menor = i;
                }
            }
            swap(array, leftIndex, menor);
            sort(array, leftIndex + 1, rightIndex);

        }
    }

    private void swap(T[] array, int i, int j) {
        T aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}
