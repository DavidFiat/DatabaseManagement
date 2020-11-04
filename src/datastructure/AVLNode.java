package datastructure;

public class AVLNode<K, V> extends BinarySearchTreeNode {
	
	
	private int balanceFactor;


	@SuppressWarnings("unchecked")
	public AVLNode(K key, V value) {
		super((Comparable<K>) key, value);
	}

	public int getBalanceFactor() {
		return balanceFactor;
	}

	public void setBalanceFactor(int balanceFactor) {
		this.balanceFactor = balanceFactor;
	}
	
	

}
