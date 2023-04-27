package orderStatistic;

import util.Util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * <p>
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1].
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * <p>
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as
 * estatisticas de ordem maiores que k.
 * <p>
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Porem, voce pode modificar o array original.
 * Voce pode criar ainda um array de tamanho k que vai armazenar apenas
 * os elementos a serem retornados.
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala
 * para calcular estatisticas de ordem.
 * - Se a entrada for invalida, deve-se retornar um array vazio (por exemplo,
 * ao solicitar os 5 maiores elementos em um array que soh contem 3 elementos).
 * Este metodo NUNCA deve retornar null.
 *
 * @param <T>
 * @author campelo and adalberto
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T> {

    @Override
    public T[] getKLargest(T[] array, int k) {
        // ordenaArraySelection(array, 0, array.length - 1);
        if (k < 0 || k > array.length) return (T[]) new Comparable[]{};
        T[] saida = (T[]) new Comparable[k];
        int cont = 0;
        int indexF = array.length;
        while (cont < k) {
            saida[cont] = orderStatistics(array, indexF);
            cont++;
            indexF--;
        }
        return saida;
    }

    private void ordenaArraySelection(T[] array, int left, int right) {
        int min = left;
        for (int i = left + 1; i < right; i++) {
            if (array[i].compareTo(array[min]) < 0)
                Util.swap(array, i, left);
            ordenaArraySelection(array, left + 1, right);
        }
    }


    /**
     * Metodo que retorna a k-esima estatistica de ordem de um array, usando
     * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista
     * a k-esima estatistica de ordem, entao retorna null.
     * <p>
     * Obs: o valor de k deve ser entre 1 e N.
     *
     * @param array
     * @param k
     * @return
     */
    public T orderStatistics(T[] array, int k) {
        if (k > array.length || k < 0) return null;
        ordenaArray(array, 0, array.length - 1);
        return array[k - 1];
    }

    private void ordenaArray(T[] array, int left, int rigth) {
        if (left < rigth) {
            for (int i = 0; i < rigth; i++) {
                if (array[i].compareTo(array[i + 1]) > 0)
                    Util.swap(array, i, i + 1);
            }
            ordenaArray(array, left, rigth - 1);
        }
    }
}
