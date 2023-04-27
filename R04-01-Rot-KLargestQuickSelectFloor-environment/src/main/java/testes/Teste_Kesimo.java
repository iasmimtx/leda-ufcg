package testes;

import orderStatistic.KLargestOrderStatisticsImpl;
import orderStatistic.QuickSelect;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import problems.FloorBinarySearchImpl;


public class Teste_Kesimo {
    KLargestOrderStatisticsImpl<Integer> kLargestOrderStatistics;
    QuickSelect<Integer> quickSelect;
    FloorBinarySearchImpl floorBinarySearch;
    Integer[] array1;
    Integer[] array2;
    Integer[] array3;
    Integer[] array4;
    Integer[] array5;

    @Before
    public void setUp() {
        this.kLargestOrderStatistics = new KLargestOrderStatisticsImpl<>();
        this.quickSelect = new QuickSelect<>();
        this.floorBinarySearch = new FloorBinarySearchImpl();
        this.array1 = new Integer[]{1, 3, 0, 5, 4};
        this.array2 = new Integer[]{1, 12, 1, 2, 5, 7, 2, 12, 4, 5};
        this.array3 = new Integer[]{10, 4, 5, 8, 6, 11, 26};
        this.array4 = new Integer[]{4, 6, 8, 10};
        this.array5 = new Integer[]{13, 3, 42, 5, 8};
    }

    @Test
    public void testOrderStatic() {
        Assert.assertEquals(Integer.valueOf(1), kLargestOrderStatistics.orderStatistics(array1, 2));
        Assert.assertEquals(Integer.valueOf(5), kLargestOrderStatistics.orderStatistics(array1, 5));
        Assert.assertEquals(Integer.valueOf(4), kLargestOrderStatistics.orderStatistics(array1, 4));
        Assert.assertEquals(Integer.valueOf(3), kLargestOrderStatistics.orderStatistics(array1, 3));
        Assert.assertEquals(null, kLargestOrderStatistics.orderStatistics(array1, 7));
    }

    @Test
    public void testGetKLargest() {
        Integer[] esperado1 = new Integer[]{5, 4};
        Integer[] esperado2 = new Integer[]{12, 12, 7, 5, 5};
        Assert.assertArrayEquals(esperado1, kLargestOrderStatistics.getKLargest(array1, 2));
        Assert.assertArrayEquals(esperado2, kLargestOrderStatistics.getKLargest(array2, 5));
    }

    @Test
    public void testQuickSelect() {
        Assert.assertEquals(Integer.valueOf(11), quickSelect.quickSelect(array3, 6));
    }

    @Test
    public void testFloor() {
        Assert.assertEquals(Integer.valueOf(6), floorBinarySearch.floor(array4, 7));
    }

}
