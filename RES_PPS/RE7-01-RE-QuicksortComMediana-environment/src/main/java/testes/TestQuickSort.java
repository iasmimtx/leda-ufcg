package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sorting.divideAndConquer.QuickSortComMediana;

public class TestQuickSort {

    QuickSortComMediana<Integer> quickSortComMediana;
    Integer[] array;

    @Before
    public void setUp() {
        this.quickSortComMediana = new QuickSortComMediana<>();
        this.array = new Integer[]{5, 2, 10, 3, 8};
    }

    @Test
    public void testQuickSort() {
        Integer[] esperado = new Integer[]{2, 3, 5, 8, 10};
        quickSortComMediana.mediana(array, 0, array.length - 1);
        Assert.assertArrayEquals(esperado, array);
    }

    @Test
    public void testMediana() {
        Assert.assertEquals(Integer.valueOf(0), quickSortComMediana.mediana(array, 0, array.length - 1));
    }

}
