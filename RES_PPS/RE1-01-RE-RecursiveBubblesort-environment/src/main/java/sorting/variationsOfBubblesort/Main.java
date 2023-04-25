package sorting.variationsOfBubblesort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[] array1 = new Integer[]{2, 1,4};
        RecursiveBubbleSort<Integer> nd = new RecursiveBubbleSort<>();
        nd.sort(array1);
        System.out.println(Arrays.toString(array1));
    }

}
