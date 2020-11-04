package datastructure;

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

	public void setRoot(BinarySearchTreeNode<K, V> root) {
		this.root = root;
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

	public void add(K key, V value) {
		BinarySearchTreeNode<K, V> b = new BinarySearchTreeNode<K, V>(key, value);
		if (root == null) {
			setRoot(b);
		} else {
			root.add(b);
		}
		size++;
	}

}
