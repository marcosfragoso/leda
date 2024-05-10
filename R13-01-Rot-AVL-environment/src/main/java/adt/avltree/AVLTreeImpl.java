package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 *  - insert
 *  - preOrder
 *  - postOrder
 *  - remove
 *  - height
 *  - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		int resp = 0;
		if (node != null && !node.isEmpty()) {
			resp = height((BSTNode<T>) node.getLeft()) - height((BSTNode<T>) node.getRight());
		}
		return resp;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = calculateBalance(node);
		BSTNode<T> root = null;
		if (Math.abs(balance) > 1) {
			if (balance > 1) {
				if (calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
					root = Util.rightRotation(node);
				} else {
					root = Util.doubleRightRotation(node);
				}
			} else {
				if (this.calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
					root = Util.leftRotation(node);
				} else {
					root = Util.doubleLeftRotation(node);
				}
			}
		}
		if (root != null && this.getRoot().equals(node)) {
			this.root = root;
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		while (parent != null) {
			rebalance(parent);
			parent = (BSTNode<T>) parent.getParent();
		}
	}

	@Override
	public void insert(T element) {
		if (element != null && search(element).isEmpty()) {
			this.insertRecursive(this.getRoot(), element);
		}
	}

	private void insertRecursive(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<>());
			node.setRight(new BSTNode<>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		} else {
			if (element.compareTo(node.getData()) < 0) {
				insertRecursive((BSTNode<T>) node.getLeft(), element);
			} else if (element.compareTo(node.getData()) > 0) {
				insertRecursive((BSTNode<T>) node.getRight(), element);
			}
			rebalance(node);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		if (node != null && !node.isEmpty()) {
			if (node.isLeaf()) {
				node.setData(null);
				node.setLeft(null);
				node.setRight(null);
				rebalanceUp(node);
			} else if (node.getLeft().isEmpty() && !node.getRight().isEmpty() || !node.getLeft().isEmpty() && node.getRight().isEmpty()) {
				if (node.getParent() != null && !node.getParent().isEmpty()) {
					if (node.getParent().getData().compareTo(node.getData()) > 0) {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setLeft(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setLeft(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					} else {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setRight(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setRight(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					}
				} else {
					if (node.getLeft().isEmpty()) {
						root = (BSTNode<T>) node.getRight();
						root.setParent(null);
					} else {
						root = (BSTNode<T>) node.getLeft();
						root.setParent(null);
					}
					rebalanceUp(node);
				}
			} else {
				T sucessor = sucessor(node.getData()).getData();
				remove(sucessor);
				node.setData(sucessor);
			}
		}
	}
}
