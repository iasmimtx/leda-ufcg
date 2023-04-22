package testes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problems.BitonicPointBinarySearch;
import problems.BitonicPointBinarySearchImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class teste {
    BitonicPointBinarySearch<Integer> bitonicPointBinarySearch;
    Integer[] array1;
    Integer[] array2;
    Integer[] array3;
    Integer[] array4;

    @BeforeEach
    public void setUp() {
        bitonicPointBinarySearch = new BitonicPointBinarySearchImpl<Integer>();
        array1 = new Integer[]{1, 2, 3, 4};
        array2 = new Integer[]{1, 7, 3};
        array3 = new Integer[]{7};
        array4 = new Integer[]{7, 1, 0};
    }

    @Test
    public void testArray1() {
        assertEquals(4, bitonicPointBinarySearch.bitonicPoint(array1));
    }

    @Test
    public void testArray2() {
        assertEquals(7, bitonicPointBinarySearch.bitonicPoint(array2));
    }

    @Test
    public void testArray3() {
        assertEquals(7, bitonicPointBinarySearch.bitonicPoint(array3));
    }

    @Test
    public void testArray4() {
        assertEquals(7, bitonicPointBinarySearch.bitonicPoint(array4));
    }

}
