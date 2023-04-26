package teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sorting.variations.OddEvenSort;

public class Testes {
    OddEvenSort<Integer> oddEvenSort;
    Integer[] array1;

    @Before
    public void setUp() {
        this.oddEvenSort = new OddEvenSort<>();
        this.array1 = new Integer[] {2,4,1,3};
    }

    @Test
    public void test01(){
        Integer[] esperado = new Integer[]{1,2,3,4};
        oddEvenSort.sort(array1);
        Assert.assertArrayEquals(esperado, array1);
    }

}
