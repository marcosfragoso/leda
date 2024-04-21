package problems;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class FloorBinarySearchTest {

    private FloorBinarySearchImpl floorBinarySearchImpl;
    Integer[] array;

    @Before
    public void setup() {
        this.floorBinarySearchImpl = new FloorBinarySearchImpl();
        this.array = new Integer[] {-5, 7, 4, 5, 8, 2, 12};
    }

    @Test
    public void testMaisProximoDoMaiorElemento(){
        Integer result = floorBinarySearchImpl.floor(array, 12);
        Integer esperado = 12;
        assertEquals(result, esperado);
    }

    @Test
    public void testTestMaisProximoDoMaiorElementoMenosUm(){
        Integer result = floorBinarySearchImpl.floor(array, 11);
        Integer esperado = 8;
        assertEquals(result, esperado);
    }

    @Test
    public void testMaisProximoDeZero(){
        Integer result = floorBinarySearchImpl.floor(array, 0);
        Integer esperado = -5;
        assertEquals(result, esperado);
    }

    @Test
    public void testMaisProximoDeValorMaiorQueOTamanhoDoArray(){
        Integer result = floorBinarySearchImpl.floor(array, 13);
        Integer esperado = 12;
        assertEquals(result, esperado);
    }

    @Test
    public void testNaoExisteMenor(){
        Integer result = floorBinarySearchImpl.floor(array, -100);
        assertNull(result);
    }
    
}
