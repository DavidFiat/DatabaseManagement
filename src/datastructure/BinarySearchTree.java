package datastructure;

import datastructureExceptions.RepeatedElementException;

public class BinarySearchTree<K extends Comparable<K>, V> {

	private BinarySearchTreeNode<K, V> root;

	public BinarySearchTree() {

	}

	public void add(K key, V value) throws RepeatedElementException {
		BinarySearchTreeNode<K, V> b = new BinarySearchTreeNode<K, V>(key, value);
		if (root == null) {
			setRoot(b);
		} else {
			root.add(b);
		}

	}

	public V Search(K key) {
		return null;

	}

	public BinarySearchTreeNode<K, V> getRoot() {
		return root;
	}

	public void setRoot(BinarySearchTreeNode<K, V> root) {
		this.root = root;
	}

}
