package datastructure;

import java.util.*;

public class TrieNode {

	private char element;
	private LinkedList<TrieNode> children;
	private TrieNode parent;
	private boolean isEnd;

	public TrieNode(char element) {
		this.setElement(element);
		setChildren(new LinkedList<TrieNode>());
		setEnd(false);
	}

	public TrieNode getChild(char c) {
		if (getChildren() != null) {
			for (TrieNode ch : getChildren()) {
				if (ch.getElement() == c) {
					return ch;
				}
			}
		}
		return null;
	}

	protected List<String> getWords() {
		List<String> list = new ArrayList<String>();
		if (isEnd()) {
			list.add(toString());
		}

		if (getChildren() != null) {
			for (int i = 0; i < getChildren().size(); i++) {
				if (getChildren().get(i) != null) {
					list.addAll(getChildren().get(i).getWords());
				}
			}
		}
		return list;
	}

	public String toString() {
		if (getParent() == null) {
			return "";
		} else {
			return getParent().toString() + new String(new char[] { element });
		}
	}

	public char getElement() {
		return element;
	}

	public void setElement(char element) {
		this.element = element;
	}

	public LinkedList<TrieNode> getChildren() {
		return children;
	}

	public void setChildren(LinkedList<TrieNode> children) {
		this.children = children;
	}

	public TrieNode getParent() {
		return parent;
	}

	public void setParent(TrieNode parent) {
		this.parent = parent;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

}
