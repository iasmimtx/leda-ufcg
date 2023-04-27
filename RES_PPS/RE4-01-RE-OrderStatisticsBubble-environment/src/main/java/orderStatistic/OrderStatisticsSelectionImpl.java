package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

    /**
     * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia
     * de usar o selection sem modificar o array original. Note que seu algoritmo vai
     * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem
     * desejada sem modificar o array original.
     * <p>
     * Restricoes:
     * - Preservar o array original, ou seja, nenhuma modificacao pode ser feita no
     * array original
     * - Nenhum array auxiliar deve ser criado e utilizado.
     * - Voce nao pode encontrar a k-esima estatistica de ordem por contagem de
     * elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
     * como o selectionsort mas sem modificar nenhuma posicao do array).
     * - Caso a estatistica de ordem nao exista no array, o algoritmo deve retornar null.
     * - Considerar que k varia de 1 a N
     * - Sugestao: o uso de recursao ajudara sua codificacao.
     */
    @Override
    public T getOrderStatistics(T[] array, int k) {
        if (k < 0 || k > array.length) {
            return null;
        }
        //qual o sentido de um atributo qtdMinimo??????
        return statistic(array, 1, 0, array.length -1, k);
    }

    private T statistic(T[] array, int qtdMinimo, int left, int right, int k) {
        if (qtdMinimo == k) return array[left];

        //nao entendii
        int menor = right;
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(array[menor]) < 0 && array[i].compareTo(array[left]) > 0) {
                menor = i;
            }
        }
        return statistic(array, qtdMinimo + 1, menor, right, k);
    }
}

//    private int insertion(T[] array, int left, int right, int k) {
//        int menor = left;
//        if (left < right) {
//            for (int i = left + 1; i < right; i++) {
//                if (array[i].compareTo(array[menor]) < 0) {
//                    menor = i;
//                    k = -1;
//                }
//            }
//            if (k == 1) {
//                return menor;
//            } else {
//                insertion(array, menor + 1, right, k);
//            }
//        }
//        return menor;
//    }


//    public T getOrderStatistics(T[] array, int k) {
//
//        boolean valid = inputValidation(array);
//
//        if (valid) {
//
//            int maximoValue = 0;
//            int minimoValue = 0;
//            for (int i = 0; i < array.length; i++) {
//                if (array[i].compareTo(array[maximoValue]) > 0)
//                    maximoValue = i;
//                if (array[i].compareTo(array[minimoValue]) < 0)
//                    minimoValue = i;
//            }
//
//            return getOrderStatisticsRec(array, k, 1, minimoValue, maximoValue);
//        }
//
//        return null;
//    }
//
//    private T getOrderStatisticsRec(T[] array, int k, int qtdMinimo, int lastMinimo, int maxIndex) {
//
//        if (qtdMinimo == k)
//            return array[lastMinimo];
//
//        if (qtdMinimo == array.length)
//            return null;
//
//        int minimo = maxIndex;
//
//        for (int i = 0; i < array.length; i++) {
//
//            if (array[i].compareTo(array[minimo]) < 0) {
//                if (array[i].compareTo(array[lastMinimo]) > 0)
//                    minimo = i;
//            }
//        }
//
//        return getOrderStatisticsRec(array, k, qtdMinimo + 1, minimo, maxIndex);
//
//    }