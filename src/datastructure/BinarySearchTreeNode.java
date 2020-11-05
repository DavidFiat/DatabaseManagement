package datastructure;

public class BinarySearchTreeNode<K extends Comparable<K>, V> {

	private K key;
	private V value;
	private int height;

	private BinarySearchTreeNode<K, V> left;
	private BinarySearchTreeNode<K, V> right;

	public BinarySearchTreeNode(K key, V value) {
		this.key = (key);
		this.value = (value);
	}

	public void add(BinarySearchTreeNode<K, V> b) {
		if (search(b.getKey()) == null) {

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

	}

	public int compareTo(BinarySearchTreeNode<K, V> b) {
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

	public BinarySearchTreeNode<K, V> search(K key) {
		if (this.key.compareTo(key) == 0) {
			return this;
		} else if (this.key.compareTo(key) > 0) {
			return (left == null) ? null : left.search(key);

		} else {
			return (right == null) ? null : right.search(key);

		}
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
