package adt.bst;

import adt.bt.BTNode;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		return this.bst.isEmpty() || this.isBST(this.bst.getRoot());
	}


	private boolean isBST (BTNode<T> node){
		boolean resp = true;
	    if (!node.isEmpty()) {
            if (this.isLeftValid(node) && this.isRightValid(node)) {
                resp = this.isBST(node.getLeft()) && this.isBST(node.getRight());
			} else {
                resp = false;
			}
		}
		return resp;
	}

	private boolean isLeftValid(BTNode<T> node) {
        return this.isLeftValid(node.getLeft(), node);
    }

    private boolean isLeftValid (BTNode<T> node, BTNode<T> root) {
        boolean resp = true;
        if (!node.isEmpty()){
            if (node.getData().compareTo(root.getData()) < 0){
                resp = this.isLeftValid(node.getLeft(), root) && this.isLeftValid(node.getRight(), root);
			} else {
                resp = false;
			}
		}
		return resp;

	}

    private boolean isRightValid (BTNode<T> node) {
        return this.isRightValid(node.getRight(), node);
    }

    private boolean isRightValid (BTNode<T> node, BTNode<T> root) {
        boolean resp = true;
        if (!node.isEmpty()) {
            if (node.getData().compareTo(root.getData()) > 0) {
                resp = this.isRightValid(node.getLeft(), root) && this.isRightValid(node.getRight(), root);
			} else {
                resp = false;
			}
		}
		return resp;
    }
	
}
