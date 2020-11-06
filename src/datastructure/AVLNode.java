package datastructure;

public class AVLNode<K extends Comparable<K>, V> extends BinarySearchTreeNode<K, V> {

	private int balanceFactor;

	public AVLNode(K key, V value) {
		super(key, value);
	}

	public int getBalanceFactor() {
		return balanceFactor;
	}

	public void setBalanceFactor(int balanceFactor) {
		this.balanceFactor = balanceFactor;
	}

}
