package datastructure;

import datastructureExceptions.RepeatedElementException;

public class BinarySearchTreeNode<K extends Comparable<K>, V> {

	private K key;
	private V value;

	private BinarySearchTreeNode<K, V> left;
	private BinarySearchTreeNode<K, V> right;
	private BinarySearchTreeNode<K, V> parent;

	public BinarySearchTreeNode(K key, V value) {
		this.setKey(key);
		this.setValue(value);
	}

	public void add(BinarySearchTreeNode<K, V> b) throws RepeatedElementException {
		if (compareTo(b) == 0)
			throw new RepeatedElementException(b.getKey());

		if (compareTo(b) > 0) {
			if (left == null) {
				setLeft(b);
			} else {
				left.add(b);
			}
		} else {
			if (right == null) {
				right = b;
			} else {
				right.add(b);
			}

		}

	}

	private int compareTo(BinarySearchTreeNode<K, V> b) {
		return (this.getKey()).compareTo(b.getKey());

	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public BinarySearchTreeNode<K, V> getLeft() {
		return left;
	}

	public void setLeft(BinarySearchTreeNode<K, V> left) {
		this.left = left;
	}

	public BinarySearchTreeNode<K, V> getRight() {
		return right;
	}

	public void setRight(BinarySearchTreeNode<K, V> right) {
		this.right = right;
	}

	public BinarySearchTreeNode<K, V> getParent() {
		return parent;
	}

	public void setParent(BinarySearchTreeNode<K, V> parent) {
		this.parent = parent;
	}

}
