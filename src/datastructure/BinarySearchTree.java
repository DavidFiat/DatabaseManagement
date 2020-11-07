package datastructure;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<K extends Comparable<K>, V> {

	private BinarySearchTreeNode<K, V> root;
	private int size;

	public BinarySearchTree() {
		size = 0;
	}

	public boolean isEmpty() {
		return getSize() == 0;
	}

	public BinarySearchTreeNode<K, V> search(K key) {
		return root == null ? null : root.search(key);
	}

	public BinarySearchTreeNode<K, V> getRoot() {
		return root;
	}

	public int height() {
		return root == null ? 0 : root.getHeight();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean add(K key, V value) {
		BinarySearchTreeNode<K, V> bstn = new BinarySearchTreeNode<>(key, value);
		return add(bstn);
	}

	public boolean delete(K key) {
		boolean deleted = false;
		BinarySearchTreeNode<K, V> bstn = search(key);
		if (bstn != null) {
			setSize(getSize() - 1);
			deleted = delete(bstn);
		}
		return deleted;
	}

	protected boolean delete(BinarySearchTreeNode<K, V> bstn) {
		BinarySearchTreeNode<K, V> parent = bstn.getParent();
		int i = 0;
		if (parent.getLeft().compareTo(bstn) == 0) {
			i = 1;
		} else {
			i = 2;
		}

		if (bstn.getLeft() == null) {
			switch (i) {
			case 1:
				parent.setLeft(bstn.getRight());
				break;

			case 2:
				parent.setRight(bstn.getRight());
				break;
			}
			return true;
		} else if (bstn.getRight() == null) {
			switch (i) {
			case 1:
				parent.setLeft(bstn.getLeft());
				break;
			case 2:
				parent.setRight(bstn.getLeft());
				break;
			}
			return true;

		} else {
			if (bstn.getLeft().getHeight() > bstn.getRight().getHeight()) {
				BinarySearchTreeNode<K, V> s = findMax(bstn.getLeft());
				bstn.setKey(s.getKey());
				bstn.setValue(s.getValue());
				return delete(s);
			} else {
				BinarySearchTreeNode<K, V> s = findMin(bstn.getRight());
				bstn.setKey(s.getKey());
				bstn.setValue(s.getValue());
				return delete(s);
			}
		}

	}

	private BinarySearchTreeNode<K, V> findMin(BinarySearchTreeNode<K, V> bstn) {
		while (bstn.getLeft() != null) {
			bstn = bstn.getLeft();
		}
		return bstn;

	}

	private BinarySearchTreeNode<K, V> findMax(BinarySearchTreeNode<K, V> bstn) {
		while (bstn.getRight() != null) {
			bstn = (bstn.getRight());
		}
		return bstn;
	}

	protected boolean add(BinarySearchTreeNode<K, V> bstn) {
		if (root == null) {
			root = bstn;
		} else {
			add(root, bstn);
		}
		setSize(getSize() + 1);
		return true;

	}

	private void add(BinarySearchTreeNode<K, V> b, BinarySearchTreeNode<K, V> newNode) {
		if (b.compareTo(newNode) > 0) {
			if (b.getLeft() == null) {
				b.setLeft(newNode);
				newNode.setParent(b);
			} else {
				add(b.getLeft(), newNode);
			}

		} else {
			if (b.getRight() == null) {
				b.setRight(newNode);
				newNode.setParent(b);

			} else {
				add(b.getRight(), newNode);
			}
		}
	}

	public List<V> autoComplete(String word) {
		List<V> c = new ArrayList<>();
		if (root != null) {
			autoComplete(c, root, word);
		}
		return c;

	}

	private void autoComplete(List<V> c, BinarySearchTreeNode<K, V> node, String word) {
		String key = (String) node.getKey();
		if (node != null) {

			if (key.charAt(0) - (word.charAt(0)) > 0) {
				autoComplete(c, node.getLeft(), word);
			} else if (key.charAt(0) - (word.charAt(0)) < 0) {
				autoComplete(c, node.getRight(), word);
			} else {

				int l = word.length();
				boolean different = false;
				for (int i = 0; i < l; i++) {
					if (word.charAt(i) != key.charAt(i)) {
						different = true;
					}

				}
				if (!different) {
					c.add(node.getValue());
				}
			}
		}
	}

	public void update(K key, V value) {
		BinarySearchTreeNode<K, V> bstn = search(key);
		bstn.setValue(value);
	}
}
