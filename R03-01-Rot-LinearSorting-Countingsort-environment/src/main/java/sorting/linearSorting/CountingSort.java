package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 * <p>
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 * <p>
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 */
public class CountingSort extends AbstractSorting<Integer> {

    @Override
    public void sort(Integer[] array, int leftIndex, int rightIndex) {
        if (isValidation(array, leftIndex, rightIndex)) {
            int max = leftIndex;
            //verificando qual é o número maior do array
            for (int i = leftIndex; i <= rightIndex; i++) {
                if (array[i] > max) max = array[i];
            }

            int[] C = new int[max + 1];
            //frequencia
            for (int i = leftIndex; i <= rightIndex; i++) {
                C[array[i]] += 1;
            }

            //cumulativa
            for (int i = 1; i < C.length; i++) {
                C[i] += C[i - 1];
            }

            int[] B = new int[rightIndex - leftIndex + 1];

            for (int i = rightIndex; i >= leftIndex; i--) {
                B[C[array[i]] - 1] = array[i];
                C[array[i]] -= 1;
            }
            int index = 0;
            for (int i = leftIndex; i <= rightIndex; i++) {
                array[i] = B[index];
                index++;
            }
        }
    }

	private boolean isValidation(Integer[] array, int leftIndex, int rightIndex) {
		return array != null && leftIndex >= 0 && leftIndex < rightIndex && rightIndex < array.length;
	}
}
