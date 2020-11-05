package datastructure;

public class AVLTree<K, V> extends BinarySearchTree {

	public AVLTree() {

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean add(K key, V value) {
		if (search((Comparable<K>) key) == null) {
			setRoot(this.add((AVLNode) getRoot(), key, value));
			super.setSize(getSize() + 1);
			return true;
		}
		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private AVLNode add(AVLNode b, K key, V value) {
		AVLNode avl = new AVLNode(key, value);
		if (b == null) {
			return avl;
		} else {
			if (b.compareTo(avl) < 0) {
				b.setLeft(add(b.getLeft(), avl));
			} else {
				b.setRight(add(b.getRight(), avl));
			}
			update(b);
			return rotate(b);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private AVLNode<K, V> add(BinarySearchTreeNode b, AVLNode avl) {
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