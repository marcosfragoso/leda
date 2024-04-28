package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		for (Integer value : array) 
			this.insert(value);
		return floor(this.root, numero, null);
	}

	private Integer floor(BSTNode<Integer> node, double number, Integer floor) {
		if (!node.isEmpty()) {
			if (number < node.getData()) {
				floor = this.floor((BSTNode<Integer>) node.getLeft(), number, floor);
			} else if (number > node.getData()) {
				floor = this.floor((BSTNode<Integer>) node.getRight(), number, node.getData());
			} else {
				floor = node.getData();
			}
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		for (Integer value : array) 
			this.insert(value);
		return ceil(this.root, numero, null);
	}

	private Integer ceil(BSTNode<Integer> node, double number, Integer ceil) {
		if (!node.isEmpty()) {
			if (number < node.getData()) {
				ceil = this.ceil((BSTNode<Integer>) node.getLeft(), number, node.getData());
			} else if (number > node.getData()) {
				ceil = this.ceil((BSTNode<Integer>) node.getRight(), number, ceil);
			} else {
				ceil = node.getData();
			}
		}
		return ceil;
	}
}
