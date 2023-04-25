package testes;


import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import sorting.variationsOfBubblesort.RecursiveBubbleSort;

public class Testes {

    Integer[] array1;
    RecursiveBubbleSort<Integer> recursiveBubbleSort;

    @BeforeEach
    public void setUp(){
        recursiveBubbleSort =  new RecursiveBubbleSort<>();
        array1 = new Integer[]{2, 1,4};
    }

    @Test
    public void test01(){
        Integer[] esperado = new Integer[] {1,2,4};
        recursiveBubbleSort.sort(array1);
        Assert.assertEquals(esperado, array1);
    }

}
