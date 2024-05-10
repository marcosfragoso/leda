package orderStatistic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class OrderStatisticsHeapTest {
    private OrderStatisticsHeapImpl<Integer> orderStatisticsHeapImpl;
    private Integer[] arrayOrdenado;
    private Integer[] arrayDesordenado;

    @Before
    public void setup() {
        this.orderStatisticsHeapImpl = new OrderStatisticsHeapImpl<Integer>();
        this.arrayOrdenado = new Integer[] {-3, 13, 22, 31, 46, 77, 80, 98};
        this.arrayDesordenado = new Integer[] {46, 31, 98, 77, -3, 13, 80, 22};
    }

    @Test
    public void testBSTOrderStatistics() {
        Integer k0 = null;
        Integer k1 = -3;
        Integer k2 = 13;
        Integer k3 = 22;
        Integer k4 = 31;
        Integer k5 = 46;
        Integer k6 = 77;
        Integer k7 = 80;
        Integer k8 = 98;
        Integer k9 = null;
        // Array ordenado
        assertEquals(k0, this.orderStatisticsHeapImpl.getOrderStatistics(arrayOrdenado, 0));
        assertEquals(k1, this.orderStatisticsHeapImpl.getOrderStatistics(arrayOrdenado, 1));
        assertEquals(k2, this.orderStatisticsHeapImpl.getOrderStatistics(arrayOrdenado, 2));
        assertEquals(k3, this.orderStatisticsHeapImpl.getOrderStatistics(arrayOrdenado, 3));
        assertEquals(k4, this.orderStatisticsHeapImpl.getOrderStatistics(arrayOrdenado, 4));
        assertEquals(k5, this.orderStatisticsHeapImpl.getOrderStatistics(arrayOrdenado, 5));
        assertEquals(k6, this.orderStatisticsHeapImpl.getOrderStatistics(arrayOrdenado, 6));
        assertEquals(k7, this.orderStatisticsHeapImpl.getOrderStatistics(arrayOrdenado, 7));
        assertEquals(k8, this.orderStatisticsHeapImpl.getOrderStatistics(arrayOrdenado, 8));
        assertEquals(k9, this.orderStatisticsHeapImpl.getOrderStatistics(arrayOrdenado, 9));
        // Array desordenado
        assertEquals(k0, this.orderStatisticsHeapImpl.getOrderStatistics(arrayDesordenado, 0));
        assertEquals(k1, this.orderStatisticsHeapImpl.getOrderStatistics(arrayDesordenado, 1));
        assertEquals(k2, this.orderStatisticsHeapImpl.getOrderStatistics(arrayDesordenado, 2));
        assertEquals(k3, this.orderStatisticsHeapImpl.getOrderStatistics(arrayDesordenado, 3));
        assertEquals(k4, this.orderStatisticsHeapImpl.getOrderStatistics(arrayDesordenado, 4));
        assertEquals(k5, this.orderStatisticsHeapImpl.getOrderStatistics(arrayDesordenado, 5));
        assertEquals(k6, this.orderStatisticsHeapImpl.getOrderStatistics(arrayDesordenado, 6));
        assertEquals(k7, this.orderStatisticsHeapImpl.getOrderStatistics(arrayDesordenado, 7));
        assertEquals(k8, this.orderStatisticsHeapImpl.getOrderStatistics(arrayDesordenado, 8));
        assertEquals(k9, this.orderStatisticsHeapImpl.getOrderStatistics(arrayDesordenado, 9));
    }




}
