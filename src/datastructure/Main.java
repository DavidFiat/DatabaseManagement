package datastructure;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Trie t = new Trie();
		t.add("iron man");
		t.add("iron");
		t.add("amazing");
		t.add("amazing spider man");
		t.add("amazing thor");
		t.add("ant man");
		t.add("ali baba");
		t.add("aligator");
		List<String> a = t.autoComplete("ama");
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
	}

}
