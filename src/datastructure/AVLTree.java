package datastructure;

public class AVLTree<K extends Comparable<K>, V> extends BinarySearchTree {

	public AVLTree() {

	}

	@Override
	public BinarySearchTreeNode<K, V> returnMethod(BinarySearchTreeNode<K, V> b) {
		update((AVLNode) b);
		return rotate((AVLNode) b);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean delete(K key, V value) {
		if (search((Comparable) key) != null) {
			AVLNode avl = new AVLNode(key, value);
			setRoot(delete((AVLNode) getRoot(), avl));
			setSize(getSize() - 1);
			return true;
		}

		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private AVLNode<K, V> delete(AVLNode b, AVLNode avl) {
		if (b == null) {
			return b;
		}

		if (b.compareTo(avl) > 0) {
			b.setLeft(delete((AVLNode) b.getLeft(), avl));
		} else if (b.compareTo(avl) < 0) {
			b.setRight(delete((AVLNode) b.getRight(), avl));
		} else {
			if (b.getLeft() == null) {
				return (AVLNode) b.getRight();
			} else if (b.getRight() == null) {
				return (AVLNode) b.getLeft();
			} else {
				if (b.getLeft().getHeight() > b.getRight().getHeight()) {

					// Swap the value of the successor into the node.
					AVLNode s = findMax((AVLNode<K, V>) b.getLeft());
					AVLNode l = (AVLNode) b.getLeft();
					b = s;

					l = delete(l, s);

				} else {

					// Swap the value of the successor into the node.
					AVLNode s = findMin((AVLNode<K, V>) b.getRight());
					AVLNode r = (AVLNode) b.getRight();
					b = s;

					r = delete(r, s);
				}
			}

		}
		update(b);
		return rotate(b);

	}

	// Helper method to find the leftmost node (which has the smallest value)
	@SuppressWarnings("unchecked")
	private AVLNode<K, V> findMin(AVLNode<K, V> avl) {
		while (avl.getLeft() != null) {
			avl = (AVLNode<K, V>) avl.getLeft();
		}
		return avl;

	}

	// Helper method to find the rightmost node (which has the largest value)
	@SuppressWarnings("unchecked")
	private AVLNode<K, V> findMax(AVLNode<K, V> avl) {
		while (avl.getRight() != null) {
			avl = (AVLNode<K, V>) avl.getRight();
		}
		return avl;
	}

	@SuppressWarnings("rawtypes")
	private void update(AVLNode b) {
		int lHeight = (b.getLeft() == null) ? -1 : b.getLeft().getHeight();
		int rHeight = (b.getRight() == null) ? -1 : b.getRight().getHeight();

		b.setHeight(1 + Math.max(lHeight, rHeight));

		b.setBalanceFactor(lHeight - rHeight);
	}

	@SuppressWarnings("rawtypes")
	private AVLNode rotate(AVLNode b) {
		if (b.getBalanceFactor() == 2) {
			if (((AVLNode) b.getLeft()).getBalanceFactor() >= 0) {
				return leftLeftCase(b);

			} else {
				return leftRightCase(b);
			}

		} else if (b.getBalanceFactor() == -2) {

			if (((AVLNode) b.getRight()).getBalanceFactor() <= 0) {
				return rightRightCase(b);

			} else {
				return rightLeftCase(b);
			}
		}

		return b;
	}

	@SuppressWarnings("rawtypes")
	private AVLNode leftLeftCase(AVLNode b) {
		return rightRotation(b);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private AVLNode leftRightCase(AVLNode b) {
		b.setLeft(leftRotation((AVLNode) b.getLeft()));
		return leftLeftCase(b);
	}

	@SuppressWarnings("rawtypes")
	private AVLNode rightRightCase(AVLNode b) {
		return leftRotation(b);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private AVLNode rightLeftCase(AVLNode b) {
		b.setRight(rightRotation((AVLNode) b.getRight()));
		return rightRightCase(b);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private AVLNode leftRotation(AVLNode b) {
		AVLNode a = (AVLNode) b.getRight();
		b.setRight(a.getLeft());
		a.setLeft(b);
		update(b);
		update(a);
		return a;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private AVLNode rightRotation(AVLNode b) {
		AVLNode a = (AVLNode) b.getLeft();
		b.setLeft(a.getRight());
		a.setRight(b);
		update(b);
		update(a);
		return a;
	}

}