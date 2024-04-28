package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		boolean resp = false;
		if (tree1 != null && tree2 != null) resp = equals( (BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
		return resp;
	}

	private boolean equals(BSTNode<T> node1, BSTNode<T> node2) {
		boolean resp = false;
		if (node1.isEmpty() && node2.isEmpty()) {  // caso base
			resp = true;
		} else if (node1.getData().equals(node2.getData())) {
			BSTNode<T> filhoAEsquerdaNode1 = (BSTNode<T>) node1.getLeft();
			BSTNode<T> filhoAEsquerdaNode2 = (BSTNode<T>) node2.getLeft();
			BSTNode<T> filhoADireitaNode1 = (BSTNode<T>) node1.getRight();
			BSTNode<T> filhoADireitaNode2 = (BSTNode<T>) node2.getRight();
			resp = equals(filhoAEsquerdaNode1, filhoAEsquerdaNode2) && equals(filhoADireitaNode1, filhoADireitaNode2);
		}
		return resp;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		boolean resp = false;
		if (tree1 != null && tree2 != null) resp = isSimilar( (BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
		return resp;
	}

	private boolean isSimilar(BSTNode<T> node1, BSTNode<T> node2) {
		boolean resp = false;
		if (node1.isEmpty() && node2.isEmpty()) { // caso base
			resp = true;
		} else if (!node1.isEmpty() && !node2.isEmpty()) {
			BSTNode<T> filhoAEsquerdaNode1 = (BSTNode<T>) node1.getLeft();
			BSTNode<T> filhoAEsquerdaNode2 = (BSTNode<T>) node2.getLeft();
			BSTNode<T> filhoADireitaNode1 = (BSTNode<T>) node1.getRight();
			BSTNode<T> filhoADireitaNode2 = (BSTNode<T>) node2.getRight();
			resp = isSimilar(filhoAEsquerdaNode1, filhoAEsquerdaNode2) && isSimilar(filhoADireitaNode1, filhoADireitaNode2);
		}
		return resp;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		T resp = null;
		if (k <= tree.size() && k > 0) {
			if (k == 1) {
				resp = tree.minimum().getData();
			} else if (k == tree.size()) {
				resp = tree.maximum().getData();
			} else {
				resp = this.orderStatistic(tree, tree.minimum(), k);
			}
		}
		return resp;
	}

	private T orderStatistic(BST<T> tree, BSTNode<T> node, int k) {
		T resp = null;
		if (k == 1) {
			resp = node.getData();
		} else {
			BSTNode<T> sucessor = tree.sucessor(node.getData());
			k -= 1;
			resp = this.orderStatistic(tree, sucessor, k);
		}
		return resp;
	}

}
