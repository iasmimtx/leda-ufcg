package testes;

import orderStatistic.OrderStatisticsSelectionImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Testes {
   // OrderStatisticsSelectionImpl<Integer> orderStatisticsSelection;
    Integer[] array1;


    @Before
    public void setUp(){
       // this.orderStatisticsSelection = new OrderStatisticsSelectionImpl<>();
        this.array1 = new Integer[] {1,6,43,2,4};
    }

    @Test
    public void testO1(){
       // Assert.assertArrayEquals(6, orderStatisticsSelection.getOrderStatistics(array1,4));
    }

}
