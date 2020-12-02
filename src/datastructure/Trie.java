package datastructure;

import java.util.*;

public class Trie {
	

	private TrieNode root;

	public Trie() {
		root = new TrieNode(' ');
	}

	public void add(String word) {
		if (search(word) == true)
			return;

		TrieNode r = root;
		TrieNode pre = null;
		for (char ch : word.toCharArray()) {
			pre = r;
			TrieNode child = r.getChild(ch);
			if (child != null) {
				r = child;
				child.setParent(pre);
			} else {
				r.getChildren().add(new TrieNode(ch));
				r = r.getChild(ch);
				r.setParent(pre);
			}
		}
		r.setEnd(true);
	}

	public boolean search(String word) {
		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			if (current.getChild(ch) == null)
				return false;
			else {
				current = current.getChild(ch);
			}
		}
		if (current.isEnd() == true) {
			return true;
		}
		return false;
	}

	public List<String> autoComplete(String word) {
		TrieNode lastNode = root;
		for (int i = 0; i < word.length(); i++) {
			lastNode = lastNode.getChild(word.charAt(i));
			if (lastNode == null)
				return new ArrayList<String>();
		}

		return lastNode.getWords();
	}

}

