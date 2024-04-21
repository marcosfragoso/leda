package orderStatistic;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class KLargestOrderStatisticsImplTest {
    private KLargestOrderStatisticsImpl<Integer> kLargestOrderStatisticsImpl;
    Integer[] array;

    @Before
    public void setup() {
        this.kLargestOrderStatisticsImpl = new KLargestOrderStatisticsImpl<Integer>();
        this.array = new Integer[] {0, 7, 4, 5, 8, 2, 12};
    }

    @Test
    public void testPrimeiraEstatisticaDeOrdem() {
        Integer kEsima = kLargestOrderStatisticsImpl.orderStatistics(array, 1);
        Integer valorEsperado = 0;
        assertEquals(valorEsperado, kEsima);
    }

    @Test
    public void testUltimaEstatisticaDeOrdem() {
        Integer kEsima = kLargestOrderStatisticsImpl.orderStatistics(array, 7);
        Integer valorEsperado = 12;
        assertEquals(valorEsperado, kEsima);
    }

    @Test
    public void testKMaiorQueOTamanhoDoArray() {
        Integer kEsima = kLargestOrderStatisticsImpl.orderStatistics(array, 8);
        assertNull(kEsima);
    }

    @Test
    public void testKMenorQueZero() {
        Integer kEsima = kLargestOrderStatisticsImpl.orderStatistics(array, -1);
        assertNull(kEsima);
    }

    @Test
    public void testKIgualAZero() {
        Integer kEsima = kLargestOrderStatisticsImpl.orderStatistics(array, 0);
        assertNull(kEsima);
    }

    @Test
    public void test3MaioresElementos() {
        assertArrayEquals(new Integer[] {7, 8, 12}, kLargestOrderStatisticsImpl.getKLargest(array, 3));
    }

    @Test
    public void testKMaiorQueOTamanhoDoArray2() {
        assertArrayEquals(new Integer[] {}, kLargestOrderStatisticsImpl.getKLargest(array, 8));
    }

    @Test
    public void testKMenorQueZero2() {
        assertArrayEquals(new Integer[] {}, kLargestOrderStatisticsImpl.getKLargest(array, -1));
    }

    @Test
    public void testKIgualAZero2() {
        assertArrayEquals(new Integer[] {}, kLargestOrderStatisticsImpl.getKLargest(array, 0));
    }

    @Test
    public void testArrayNull() {
        assertArrayEquals(new Integer[] {}, kLargestOrderStatisticsImpl.getKLargest(null, 0));
    }

    @Test
    public void testArrayVazio() {
        assertArrayEquals(new Integer[] {}, kLargestOrderStatisticsImpl.getKLargest(new Integer[] {}, 0));
    }

    @Test
    public void testTamanhoDoArrayMaioresElementos() {
        assertArrayEquals(this.array, kLargestOrderStatisticsImpl.getKLargest(array, 7));
    }
}
