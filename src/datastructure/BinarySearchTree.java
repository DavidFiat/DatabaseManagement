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

	public boolean add(BinarySearchTreeNode<K, V> bstn) {
		if (search(bstn.getKey()) == null) {
			setRoot(this.add(getRoot(), bstn));
			setSize(getSize() + 1);
			return true;
		}
		return false;
	}

	private BinarySearchTreeNode<K, V> add(BinarySearchTreeNode<K, V> b, BinarySearchTreeNode<K, V> avl) {

		if (b == null) {
			return avl;
		} else {
			if (b.compareTo(avl) > 0) {
				b.setLeft(add(b.getLeft(), avl));
			} else {
				b.setRight(add(b.getRight(), avl));
			}

			return returnMethod(b);

		}
	}

	public BinarySearchTreeNode<K, V> returnMethod(BinarySearchTreeNode<K, V> b) {
		return b;
	}

}
