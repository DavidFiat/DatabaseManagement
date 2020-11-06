package datastructure;

public class AVLTree<K extends Comparable<K>, V> extends BinarySearchTree<K, V> {

	public AVLTree() {

	}

	@Override
	public boolean add(K key, V value) {
		AVLNode<K, V> avlNode = new AVLNode<>(key, value);
		boolean added = add(avlNode);
		if (added) {
			update(avlNode);
			rotate(avlNode);
		}
		return added;
	}

	@Override
	public boolean delete(K key) {
		boolean deleted = false;
		AVLNode<K, V> avlNode = (AVLNode<K, V>) search(key);
		if (avlNode != null) {
			setSize(getSize() - 1);
			deleted = delete(avlNode);
			update(avlNode);
			rotate(avlNode);
		}
		return deleted;

	}

	private void update(AVLNode<K, V> b) {
		int lHeight = (b.getLeft() == null) ? -1 : b.getLeft().getHeight();
		int rHeight = (b.getRight() == null) ? -1 : b.getRight().getHeight();

		b.setHeight(1 + Math.max(lHeight, rHeight));

		b.setBalanceFactor(lHeight - rHeight);
	}

	private AVLNode<K, V> rotate(AVLNode<K, V> b) {
		if (b.getBalanceFactor() == 2) {
			if (((AVLNode<K, V>) b.getLeft()).getBalanceFactor() >= 0) {
				return leftLeftCase(b);

			} else {
				return leftRightCase(b);
			}

		} else if (b.getBalanceFactor() == -2) {

			if (((AVLNode<K, V>) b.getRight()).getBalanceFactor() <= 0) {
				return rightRightCase(b);

			} else {
				return rightLeftCase(b);
			}
		}

		return b;
	}

	private AVLNode<K, V> leftLeftCase(AVLNode<K, V> b) {
		return rightRotation(b);
	}

	private AVLNode<K, V> leftRightCase(AVLNode<K, V> b) {
		b.setLeft(leftRotation((AVLNode<K, V>) b.getLeft()));
		return leftLeftCase(b);
	}

	private AVLNode<K, V> rightRightCase(AVLNode<K, V> b) {
		return leftRotation(b);
	}

	private AVLNode<K, V> rightLeftCase(AVLNode<K, V> b) {
		b.setRight(rightRotation((AVLNode<K, V>) b.getRight()));
		return rightRightCase(b);
	}

	private AVLNode<K, V> leftRotation(AVLNode<K, V> b) {
		AVLNode<K, V> a = (AVLNode<K, V>) b.getRight();
		b.setRight(a.getLeft());
		a.setLeft(b);
		update(b);
		update(a);
		return a;
	}

	private AVLNode<K, V> rightRotation(AVLNode<K, V> b) {
		AVLNode<K, V> a = (AVLNode<K, V>) b.getLeft();
		b.setLeft(a.getRight());
		a.setRight(b);
		update(b);
		update(a);
		return a;
	}

}