package orderStatistic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class QuickSelectTest {
    private QuickSelect<Integer> quickSelect;
    Integer[] array;

    @Before
    public void setup() {
        this.quickSelect = new QuickSelect<Integer>();
        this.array = new Integer[] {0, 7, 4, 5, 8, 2, 12};
    }

    @Test
    public void testPrimeiraEstatisticaDeOrdem() {
        Integer kEsima = quickSelect.quickSelect(array, 1);
        Integer valorEsperado = 0;
        assertEquals(valorEsperado, kEsima);
    }

    @Test
    public void testUltimaEstatisticaDeOrdem() {
        Integer kEsima = quickSelect.quickSelect(array, 7);
        Integer valorEsperado = 12;
        assertEquals(valorEsperado, kEsima);
    }

    @Test
    public void testTerceiraEstatisticaDeOrdem() {
        Integer kEsima = quickSelect.quickSelect(array, 3);
        Integer valorEsperado = 4;
        assertEquals(valorEsperado, kEsima);
    }

    @Test
    public void testQuartaEstatisticaDeOrdem() {
        Integer kEsima = quickSelect.quickSelect(array, 4);
        Integer valorEsperado = 5;
        assertEquals(valorEsperado, kEsima);
    }

    @Test
    public void testQuintaEstatisticaDeOrdem() {
        Integer kEsima = quickSelect.quickSelect(array, 5);
        Integer valorEsperado = 7;
        assertEquals(valorEsperado, kEsima);
    }

    @Test
    public void testSextaEstatisticaDeOrdem() {
        Integer kEsima = quickSelect.quickSelect(array, 6);
        Integer valorEsperado = 8;
        assertEquals(valorEsperado, kEsima);
    }

    @Test
    public void testSegundaEstatisticaDeOrdem() {
        Integer kEsima = quickSelect.quickSelect(array, 2);
        Integer valorEsperado = 2;
        assertEquals(valorEsperado, kEsima);
    }

    @Test
    public void testKMaiorQueOTamanhoDoArray() {
        Integer kEsima = quickSelect.quickSelect(array, 9);
        assertNull(kEsima);
    }

    @Test
    public void testKMenorQueZero() {
        Integer kEsima = quickSelect.quickSelect(array, -1);
        assertNull(kEsima);
    }

    @Test
    public void testKIgualAZero() {
        Integer kEsima = quickSelect.quickSelect(array, 0);
        assertNull(kEsima);
    }

    @Test
    public void testArrayVazio() {
        assertNull(quickSelect.quickSelect(new Integer[] {}, 4));
    }

    @Test
    public void testArrayNull() {
        assertNull(quickSelect.quickSelect(null, 4));
    }
}
