package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return this.height(this.getRoot());
	}

	protected int height(BSTNode<T> node) {
		int height = -1;
		if (!node.isEmpty()) {
			int leftHeight = this.height((BSTNode<T>) node.getLeft());
			int rightHeight = this.height((BSTNode<T>) node.getRight());
			height = 1 + Math.max(leftHeight, rightHeight);
		}
		return height;
	}

	@Override
	public BSTNode<T> search(T element) {
		return search(element, this.getRoot());
	}

	private BSTNode<T> search(T element, BSTNode<T> node) {
		BSTNode<T> resp = new BSTNode<>();
		if (element != null && !node.isEmpty()) {
			if (element.compareTo(node.getData()) < 0) {
				resp = this.search(element, (BSTNode<T>) node.getLeft());
			} else if (element.compareTo(node.getData()) > 0) {
				resp = this.search(element, (BSTNode<T>) node.getRight());
			} else {
				resp = node;
			}
		}
		return resp;
	}

	@Override
	public void insert(T element) {
		if (element != null && search(element).isEmpty()) {
			this.insert(this.getRoot(), element);
		}
	}

	private void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<>());
			node.setRight(new BSTNode<>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		} else {
			if (element.compareTo(node.getData()) < 0) {
				insert((BSTNode<T>) node.getLeft(), element);
			} else if (element.compareTo(node.getData()) > 0) {
				insert((BSTNode<T>) node.getRight(), element);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> resp = null;
		if (!this.isEmpty()) resp = this.maximum(this.getRoot());
		return resp;
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		BSTNode<T> resp = node;
		if (!node.getRight().isEmpty()) {
			resp = maximum((BSTNode<T>) node.getRight());
		}
		return resp;
	}


	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> resp = null;
		if (!this.isEmpty()) resp = this.minimum(this.getRoot());
		return resp;
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		BSTNode<T> resp = node;
		if (!node.getLeft().isEmpty()) {
			resp = minimum((BSTNode<T>) node.getLeft());
		}
		return resp;
	}


	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);
		BSTNode<T> resp = new BSTNode<>();
		if (node.getRight() != null && !node.getRight().isEmpty()) {
			resp = minimum((BSTNode<T>) node.getRight());
		} else {
			BSTNode<T> parent = (BSTNode<T>) node.getParent();
			while (parent != null && !parent.isEmpty() && parent.getData().compareTo(node.getData()) < 0) {
				node = parent;
				parent = (BSTNode<T>) parent.getParent();
			}
			resp = parent;
		}
		return resp;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);
		BSTNode<T> resp = new BSTNode<>();
		if (node.getLeft() != null && !node.getLeft().isEmpty()) {
			resp = maximum((BSTNode<T>) node.getLeft());
		} else {
			BSTNode<T> parent = (BSTNode<T>) node.getParent();
			while (parent != null && !parent.isEmpty() && parent.getData().compareTo(node.getData()) > 0) {
				node = parent;
				parent = (BSTNode<T>) parent.getParent();
			}
			resp = parent;
		}
		return resp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		if (node!= null && !node.isEmpty()) {
			if (node.isLeaf()) {
				node.setData(null);
				node.setLeft(null);
				node.setRight(null);
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
				}
			} else {
				T sucessor = sucessor(node.getData()).getData();
				remove(sucessor);
				node.setData(sucessor);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] preOrder() {
		ArrayList<T> list = new ArrayList<>();
		preOrder(list, this.getRoot());
		return (T[]) list.toArray(new Comparable[list.size()]);
	}

	private void preOrder(ArrayList<T> list, BSTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			list.add(node.getData());
			preOrder(list, (BSTNode<T>) node.getLeft());
			preOrder(list, (BSTNode<T>) node.getRight());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] order() {
		ArrayList<T> list = new ArrayList<>();
		order(list, this.getRoot());
		return (T[]) list.toArray(new Comparable[list.size()]);
	}

	private void order(ArrayList<T> list, BSTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			order(list, (BSTNode<T>) node.getLeft());
			list.add(node.getData());
			order(list, (BSTNode<T>) node.getRight());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] postOrder() {
		ArrayList<T> list = new ArrayList<>();
		postOrder(list, this.getRoot());
		return (T[]) list.toArray(new Comparable[list.size()]);
	}

	private void postOrder(ArrayList<T> list, BSTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			postOrder(list, (BSTNode<T>) node.getLeft());
			postOrder(list, (BSTNode<T>) node.getRight());
			list.add(node.getData());
		}

	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
