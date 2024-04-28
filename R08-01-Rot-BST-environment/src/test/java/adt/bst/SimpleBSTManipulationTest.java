package adt.bst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SimpleBSTManipulationTest {
    private SimpleBSTManipulationImpl<Integer> simpleBSTManipulationImpl;
    private BSTImpl<Integer> tree1;
    private BSTImpl<Integer> tree2;
    private BSTImpl<Integer> tree3;
    private BSTImpl<Integer> tree4;

    @Before
    public void setup() {
        this.simpleBSTManipulationImpl = new SimpleBSTManipulationImpl<>();
        this.tree1 = new BSTImpl<>();
        this.tree2 = new BSTImpl<>();
        this.tree3 = new BSTImpl<>();
        this.tree4 = new BSTImpl<>();
        Integer[] array1 = new Integer[] {46, 31, 98, 77, -3, 13, 80, 22};
        Integer[] array2 = new Integer[] {-3, 13, 22, 31, 46, 78, 80, 98};
        Integer[] array3 = new Integer[] {-4, 14, 23, 32, 47, 79, 81, 99};
        for (Integer num : array1) {
            tree1.insert(num);
            tree2.insert(num);
        }
        for (Integer num : array2) {
            tree3.insert(num);
        }
        for (Integer num : array3) {
            tree4.insert(num);
        }
    }

    @Test
    public void testBSTIguais() {
        assertTrue(this.simpleBSTManipulationImpl.equals(tree1, tree2));
    }

    @Test
    public void testBSTDiferentes() {
        assertFalse(this.simpleBSTManipulationImpl.equals(tree1, tree3));
        assertFalse(this.simpleBSTManipulationImpl.equals(tree2, tree3));
    }

    @Test
    public void testBSTSimilares() {
        assertTrue(this.simpleBSTManipulationImpl.isSimilar(tree3, tree4));
    }

    @Test
    public void testBSTNaoSimilares() {
        assertFalse(this.simpleBSTManipulationImpl.isSimilar(tree1, tree3));
        assertFalse(this.simpleBSTManipulationImpl.isSimilar(tree2, tree3));
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
        assertEquals(k0, this.simpleBSTManipulationImpl.orderStatistic(tree1, 0));
        assertEquals(k1, this.simpleBSTManipulationImpl.orderStatistic(tree1, 1));
        assertEquals(k2, this.simpleBSTManipulationImpl.orderStatistic(tree1, 2));
        assertEquals(k3, this.simpleBSTManipulationImpl.orderStatistic(tree1, 3));
        assertEquals(k4, this.simpleBSTManipulationImpl.orderStatistic(tree1, 4));
        assertEquals(k5, this.simpleBSTManipulationImpl.orderStatistic(tree1, 5));
        assertEquals(k6, this.simpleBSTManipulationImpl.orderStatistic(tree1, 6));
        assertEquals(k7, this.simpleBSTManipulationImpl.orderStatistic(tree1, 7));
        assertEquals(k8, this.simpleBSTManipulationImpl.orderStatistic(tree1, 8));
        assertEquals(k9, this.simpleBSTManipulationImpl.orderStatistic(tree1, 9));
    }

    




}
