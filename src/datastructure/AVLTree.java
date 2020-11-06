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
				leftLeftCase(b);

			} else {
				leftRightCase(b);
			}

		} else if (b.getBalanceFactor() == -2) {

			if (((AVLNode<K, V>) b.getRight()).getBalanceFactor() <= 0) {
				rightRightCase(b);

			} else {
				rightLeftCase(b);
			}
		}

		return b;
	}

	private void leftLeftCase(AVLNode<K, V> b) {
		rightRotation(b);
	}

	private void leftRightCase(AVLNode<K, V> b) {
		leftRotation((AVLNode<K, V>) b.getLeft());
		leftLeftCase(b);
	}

	private void rightRightCase(AVLNode<K, V> b) {
		leftRotation(b);
	}

	private void rightLeftCase(AVLNode<K, V> b) {
		rightRotation((AVLNode<K, V>) b.getRight());
		rightRightCase(b);
	}

	private void leftRotation(AVLNode<K, V> b) {
		AVLNode<K, V> parent = (AVLNode<K, V>) b.getParent();
		AVLNode<K, V> right = (AVLNode<K, V>) b.getRight();
		b.setRight(right.getLeft());
		if (right.getLeft() != null) {
			right.getLeft().setParent(b);
		}
		right.setLeft(b);
		b.setParent(right);
		right.setParent(parent);
		if (parent != null) {
			if (parent.getLeft().compareTo(b) == 0) {
				parent.setLeft(right);
			} else {
				parent.setRight(right);
			}
		}

	}

	private void rightRotation(AVLNode<K, V> b) {
		AVLNode<K, V> parent = (AVLNode<K, V>) b.getParent();
		AVLNode<K, V> left = (AVLNode<K, V>) b.getLeft();
		b.setLeft(left.getRight());
		if (left.getRight() != null) {
			left.getRight().setParent(b);
		}
		left.setRight(b);
		b.setParent(left);
		left.setParent(parent);
		if (parent != null) {
			if (parent.getLeft().compareTo(b) == 0) {
				parent.setLeft(left);
			} else {
				parent.setRight(left);
			}
		}

	}

}