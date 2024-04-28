package adt.bst.extended;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FloorCeilBSTTest {

    private FloorCeilBSTImpl floorCeilBSTImpl;
    private Integer[] arrayOrdenado;
    private Integer[] arrayDesordenado;

    @Before
    public void setup() {
        this.floorCeilBSTImpl = new FloorCeilBSTImpl();
        this.arrayOrdenado = new Integer[] {-3, 13, 22, 31, 46, 77, 80, 98};
        this.arrayDesordenado = new Integer[] {46, 31, 98, 77, -3, 13, 80, 22};
    }

    // Floor

    @Test
    public void testFloorComArrayJaOrdenadoComNumeroExistente() {
        Integer resultadoObtido = this.floorCeilBSTImpl.floor(arrayOrdenado, 22);
        Integer resultadoEsperado = 22;
        assertEquals(resultadoEsperado,resultadoObtido);
    }

    @Test
    public void testFloorComArrayJaOrdenadoComNumeroNaoExistente() {
        Integer resultadoObtido = this.floorCeilBSTImpl.floor(arrayOrdenado, 79);
        Integer resultadoEsperado = 77;
        assertEquals(resultadoEsperado,resultadoObtido);
    }

    @Test
    public void testFloorComArrayJaOrdenadoComNumeroMaiorQueTodosDoArray() {
        Integer resultadoObtido = this.floorCeilBSTImpl.floor(arrayOrdenado, 992);
        Integer resultadoEsperado = 98;
        assertEquals(resultadoEsperado,resultadoObtido);
    }

    @Test
    public void testFloorComArrayJaOrdenadoComNumeroMenorQueTodosDoArray() {
        Integer resultadoObtido = this.floorCeilBSTImpl.floor(arrayOrdenado, -170);
        Integer resultadoEsperado = null;
        assertEquals(resultadoEsperado,resultadoObtido);
    }

    @Test
    public void testFloorComArrayDesordenadoComNumeroExistente() {
        Integer resultadoObtido = this.floorCeilBSTImpl.floor(arrayDesordenado, 22);
        Integer resultadoEsperado = 22;
        assertEquals(resultadoEsperado,resultadoObtido);
    }

    @Test
    public void testFloorComArrayDesordenadoComNumeroNaoExistente() {
        Integer resultadoObtido = this.floorCeilBSTImpl.floor(arrayDesordenado, 79);
        Integer resultadoEsperado = 77;
        assertEquals(resultadoEsperado,resultadoObtido);
    }

    @Test
    public void testFloorComArrayDesordenadoComNumeroMaiorQueTodosDoArray() {
        Integer resultadoObtido = this.floorCeilBSTImpl.floor(arrayDesordenado, 992);
        Integer resultadoEsperado = 98;
        assertEquals(resultadoEsperado,resultadoObtido);
    }

    @Test
    public void testFloorComArrayDesordenadoComNumeroMenorQueTodosDoArray() {
        Integer resultadoObtido = this.floorCeilBSTImpl.floor(arrayDesordenado, -170);
        Integer resultadoEsperado = null;
        assertEquals(resultadoEsperado,resultadoObtido);
    }


    // Ceil

    @Test
    public void testCeilComArrayJaOrdenadoComNumeroExistente() {
        Integer resultadoObtido = this.floorCeilBSTImpl.ceil(arrayOrdenado, 22);
        Integer resultadoEsperado = 22;
        assertEquals(resultadoEsperado,resultadoObtido);
    }

    @Test
    public void testCeilComArrayJaOrdenadoComNumeroNaoExistente() {
        Integer resultadoObtido = this.floorCeilBSTImpl.ceil(arrayOrdenado, 79);
        Integer resultadoEsperado = 80;
        assertEquals(resultadoEsperado,resultadoObtido);
    }

    @Test
    public void testCeilComArrayJaOrdenadoComNumeroMaiorQueTodosDoArray() {
        Integer resultadoObtido = this.floorCeilBSTImpl.ceil(arrayOrdenado, 992);
        Integer resultadoEsperado = null;
        assertEquals(resultadoEsperado,resultadoObtido);
    }

    @Test
    public void testCeilComArrayJaOrdenadoComNumeroMenorQueTodosDoArray() {
        Integer resultadoObtido = this.floorCeilBSTImpl.ceil(arrayOrdenado, -170);
        Integer resultadoEsperado = -3;
        assertEquals(resultadoEsperado,resultadoObtido);
    }

    @Test
    public void testCeilComArrayDesordenadoComNumeroExistente() {
        Integer resultadoObtido = this.floorCeilBSTImpl.ceil(arrayDesordenado, 22);
        Integer resultadoEsperado = 22;
        assertEquals(resultadoEsperado,resultadoObtido);
    }

    @Test
    public void testCeilComArrayDesordenadoComNumeroNaoExistente() {
        Integer resultadoObtido = this.floorCeilBSTImpl.ceil(arrayDesordenado, 79);
        Integer resultadoEsperado = 80;
        assertEquals(resultadoEsperado,resultadoObtido);
    }

    @Test
    public void testCeilComArrayDesordenadoComNumeroMaiorQueTodosDoArray() {
        Integer resultadoObtido = this.floorCeilBSTImpl.ceil(arrayDesordenado, 992);
        Integer resultadoEsperado = null;
        assertEquals(resultadoEsperado,resultadoObtido);
    }

    @Test
    public void testCeilComArrayDesordenadoComNumeroMenorQueTodosDoArray() {
        Integer resultadoObtido = this.floorCeilBSTImpl.ceil(arrayDesordenado, -170);
        Integer resultadoEsperado = -3;
        assertEquals(resultadoEsperado,resultadoObtido);
    }





    
}
