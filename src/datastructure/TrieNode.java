package datastructure;

import java.util.LinkedList;

public class TrieNode {

	private char element;
	private LinkedList<TrieNode> children;
	private TrieNode parent;
	private boolean isEnd;

	public TrieNode(char element) {
		this.element = element;
		children = new LinkedList<TrieNode>();
	}

}
