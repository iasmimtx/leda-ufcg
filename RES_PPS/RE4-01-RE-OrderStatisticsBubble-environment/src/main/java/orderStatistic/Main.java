package orderStatistic;

public class Main {


    public static void main(String[] args) {
        OrderStatisticsSelectionImpl<Integer> nd = new OrderStatisticsSelectionImpl<>();
        Integer[] array1 = new Integer[] {1,6,43,2,4};

        Integer saida = nd.getOrderStatistics(array1,3);
        System.out.println(saida);

    }
}
