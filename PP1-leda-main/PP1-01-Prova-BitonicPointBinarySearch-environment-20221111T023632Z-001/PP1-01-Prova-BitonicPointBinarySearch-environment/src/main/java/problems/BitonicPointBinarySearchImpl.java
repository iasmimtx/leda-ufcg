package problems;

public class BitonicPointBinarySearchImpl<T extends Comparable<T>> implements BitonicPointBinarySearch<T> {

    @Override
    public T bitonicPoint(T[] array) {
        return bitonic(array, 0, array.length - 1);
    }

    private T bitonic(T[] array, int left, int rigth) {
        T result = null;
        if (left == rigth) {
            result = array[left];
        } else if (left < rigth) {
            int middle = (left + rigth) / 2;
            if(array[middle].compareTo(array[middle + 1]) > 0){
                result = bitonic(array, left, middle);
            } else{
                result = bitonic(array, middle + 1, rigth);
            }
        }
        return result;

    }


//    private T bitonic(T[] array, int middle) {
//        T result;
//        if (array[middle].equals(array[0]) ||  array[middle].equals(array[array.length -1]) || array[middle].compareTo(array[middle + 1]) > 0 && array[middle].compareTo(array[middle - 1]) > 0) {
//            result = array[middle];
//        } else if (array[middle].compareTo(array[middle - 1]) < 0) {
//            result = bitonic(array, middle - 1);
//        } else {
//            result = bitonic(array, middle + 1);
//        }
//        return result;
//    }
}
