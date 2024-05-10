package adt.avltree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import adt.bst.BSTNode;
import adt.bt.Util;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {
		
	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		if (array != null && array.length > 0) {
			List<T> list = new ArrayList<>();

			for (T element : this.preOrder()){
				list.add(element);
			} 

			for (T element : array) {
				if (!list.contains(element)) {
					list.add(element);
				}
			}

			this.root = new BSTNode<>();
			Collections.sort(list);
			Map<Integer, List<T>> map = new HashMap<>();
			auxFillWithoutRebalance(map, 0, 0, list.size() - 1, list);

			int height = 0;
			while (map.containsKey(height)) {
				for (T element : map.get(height)){
					insert(element);
				}
				height ++;
			}
  		}
	}

	private void auxFillWithoutRebalance(Map<Integer, List<T>> map, int height, int leftIndex, int rightIndex, List<T> array) {
		if (leftIndex <= rightIndex) {
			int middle = (leftIndex + rightIndex) / 2;
			T element = array.get(middle);
			if (!map.containsKey(height)){
				map.put(height, new ArrayList<T>());
			}
			map.get(height).add(element);
			auxFillWithoutRebalance(map, height + 1, leftIndex, middle - 1, array);
			auxFillWithoutRebalance(map, height + 1, middle + 1, rightIndex, array);
		}
	}


	@Override
	protected void rebalance(BSTNode<T> node) {

		int balance = calculateBalance(node);

		if (balance > 1){
			BSTNode<T> newRoot;
			if (calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
				newRoot = Util.rightRotation(node);
				LLcounter++;
			} else {
				Util.leftRotation((BSTNode<T>) node.getLeft());
				newRoot = Util.rightRotation(node);
				LRcounter++;
			}
			if (newRoot.getParent() == null){
				this.root = newRoot;
			}
		} else if (balance < -1){
			BSTNode<T> newRoot;
			if (calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
				newRoot = Util.leftRotation(node);
				RRcounter++;
			} else {	
				Util.rightRotation((BSTNode<T>) node.getRight());
				newRoot = Util.leftRotation(node);
				RLcounter++;
			}
			if (newRoot.getParent() == null){
				this.root = newRoot;
			}
		}
	}



}
