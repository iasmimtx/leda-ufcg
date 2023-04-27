package orderStatistic;

public class Kesimo {


    /*
     * Descubra o K maior de um array bitônico.
     * A complexidade de tempo deve ser O(n).
     * Você pode usar um array auxiliar de TAMANHO MÁXIMO n (tamanho do array
     * original).
     * Se kMaior não existir, retorne -1;
     * by Kenned
     */
    public static int kLargestBitonic(int[] array, int k) {
        int result = -1;
        if (k - 1 < array.length && k - 1 > -1) {
            int left = max(array);
            int right = left;
            result = array[left];
            left--;
            right++;
            k--;
            while (k != 0 && left > -1 && right < array.length) {
                if (array[left] > array[right]) {
                    result = array[left--];
                    ;
                } else {
                    result = array[right++];
                }
                k--;
            }
            while (k != 0 && left > -1) {
                result = array[left--];
                k--;
            }
            while (k != 0 && right < array.length) {
                result = array[right++];
                k--;
            }
        }
        return result;
    }

    private static int max(int[] array) {
        int max = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[max]) {
                max = i;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] array = new int[]{0, 3, 8, 2, 1};

        int saida = kLargestBitonic(array, 2);
        System.out.println(saida);


    }
}
