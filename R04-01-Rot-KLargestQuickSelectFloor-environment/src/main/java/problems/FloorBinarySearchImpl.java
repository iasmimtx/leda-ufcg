package problems;


import util.Util;

/**
 * Retorna o elemento do array que eh igual ou menor e mais proximo possivel dele.
 * <p>
 * Restricoes:
 * - seu metodo deve ter tempo O(n.log n)
 * - seu metodo DEVE usar a estrategia de busca binaria (recursiva) para buscar o floor
 * - toda sua solucao deve ser in-place (nao pode usar memoria extra)
 * - voce nao pode usar nenhum metodo pronto de qualquer biblioteca.
 * - voce pode assumir que o array nao tem elementos repetidos
 * - todo e qualquer codigo que voce implementar deve estar na classe FloorBinarySearchImpl.
 **/
public class FloorBinarySearchImpl implements Floor {

    @Override
    public Integer floor(Integer[] array, Integer x) {
        if (array != null && array.length > 0 && x != null) {
            quickSort(array, 0, array.length - 1);
            return search(array, 0, array.length - 1, x);
        }
        return null;
    }

    private void quickSort(Integer[] array, int left, int right) {
        if (array != null && left >= 0 && left < right && right < array.length) {
            int indexPivot = partition(array, left, right);
            quickSort(array, left, indexPivot - 1);
            quickSort(array, indexPivot + 1, right);
        }
    }

    private int partition(Integer[] array, int left, int right) {
        int pivot = array[left];
        int i = left;

        for (int j = left + 1; j <= right; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i += 1;
                Util.swap(array, i, j);
            }
        }

        Util.swap(array, left, i);

        return i;
    }

    private Integer search(Integer[] array, int left, int right, Integer x) {
        if (left > right) {
            if (right < 0) {
                return null;
            } else {
                return array[right];
            }
        }
        Integer result;
        int middle = (left + right) / 2;
        if (array[middle].equals(x)) result = x;
        else if (array[middle] > x)
            result = search(array, left, middle-1, x); // x é menor que o elemento do meio, proc na metdade esquerda
        else result = search(array, middle + 1, right, x);
        return result;
    }
}
