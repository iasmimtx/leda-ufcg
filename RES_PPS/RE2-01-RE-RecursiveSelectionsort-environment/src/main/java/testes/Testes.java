package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sorting.variationsOfSelectionsort.RecursiveSelectionSort;

public class Testes {
    RecursiveSelectionSort<Integer> recursiveSelectionSort;
    Integer[] array1;

    @Before
    public void setUp(){
        this.recursiveSelectionSort = new RecursiveSelectionSort<>();
        this.array1 = new Integer[]{2,5,1,0};
    }

    @Test
    public void testArray1(){
        Integer[] esperado = new Integer[] {0,1,2,5};
        recursiveSelectionSort.sort(array1);
        Assert.assertArrayEquals(esperado, array1);
    }

}
