package model;

import java.util.*;

import datastructure.*;

public class Database {

	private AVLTree<String, Person> nameTree;
	private AVLTree<String, Person> lastNameTree;
	private RedBlackTree<String, Person> nameAndLastNameTree;
	private AVLTree<String, Person> codeTree;

	public Database() {
		nameTree = new AVLTree<String, Person>();
		lastNameTree = new AVLTree<String, Person>();
		nameAndLastNameTree = new RedBlackTree<String, Person>();
		codeTree = new AVLTree<String, Person>();

	}

	public boolean addByName(Person p) {
		return nameTree.add(p.getName(), p);
	}

	public boolean addByLastName(Person p) {
		return lastNameTree.add(p.getLastName(), p);
	}

	public boolean addByNameAndLastName(Person p) {
		return nameAndLastNameTree.add(p.getName() + " " + p.getLastName(), p);
	}

	public boolean addByCode(Person p) {
		boolean added = false;
		if (codeTree.search(p.getCode()) == null) {
			added = codeTree.add(p.getCode(), p);
		}
		return added;
	}

	public Person searchByName(String k) {
		return nameTree.search(k).getValue();
	}

	public Person searchByLastName(String k) {
		return lastNameTree.search(k).getValue();
	}

	public Person searchByCode(String k) {
		return codeTree.search(k).getValue();
	}

	public Person searchByNameAndLastName(String k) {
		return nameAndLastNameTree.search(k).getValue();
	}

	public void delete(Person p) {
		nameTree.delete(p.getName());
		lastNameTree.delete(p.getLastName());
		codeTree.delete(p.getCode());
		nameAndLastNameTree.delete(p.getName() + " " + p.getLastName());

	}

	public AVLTree<String, Person> getNameTree() {
		return nameTree;
	}

	public void setNameTree(AVLTree<String, Person> nameTree) {
		this.nameTree = nameTree;
	}

	public AVLTree<String, Person> getLastNameTree() {
		return lastNameTree;
	}

	public void setLastNameTree(AVLTree<String, Person> lastNameTree) {
		this.lastNameTree = lastNameTree;
	}

	public RedBlackTree<String, Person> getNameAndLastName() {
		return nameAndLastNameTree;
	}

	public void setNameAndLastName(RedBlackTree<String, Person> nameAndLastNameTree) {
		this.nameAndLastNameTree = nameAndLastNameTree;
	}

	public AVLTree<String, Person> getCodeTree() {
		return codeTree;
	}

	public void setCodeTree(AVLTree<String, Person> codeTree) {
		this.codeTree = codeTree;
	}

	public List<String> autoCompleteName(String word) {
		Trie t = new Trie();
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < persons.size(); i++) {
			t.add(persons.get(i).getName());
		}

		return t.autoComplete(word);

	}

	public List<String> autoCompleteLastName(String word) {
		Trie t = new Trie();
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < persons.size(); i++) {
			t.add(persons.get(i).getLastName());
		}

		return t.autoComplete(word);

	}

	public List<String> autoCompleteCode(String word) {
		Trie t = new Trie();
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < persons.size(); i++) {
			t.add(persons.get(i).getCode());
		}

		return t.autoComplete(word);

	}

	public List<String> autoCompleteNameAndLastName(String word) {
		List<String> s = new ArrayList<String>();
		List<Person> persons = nameAndLastNameTree.autoComplete(word);
		for (int i = 0; i < persons.size(); i++) {
			String str = persons.get(i).getName() + " " + persons.get(i).getLastName();
			s.add(str);
		}
		return s;
	}

}