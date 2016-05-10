/**
 * Created by winney on 16/5/9.
 */
class TrieNode {
    // Initialize your data structure here.
    // Initialize your data structure here.
    TrieNode[] next = new TrieNode[26];
    final static int DISTANCE = 97;
    public boolean value = false;

    public TrieNode() {
    }

    public TrieNode insert(char val) {
        if (this.next[val - DISTANCE] == null) {
            this.next[val - DISTANCE] = new TrieNode();
        }
        return this.next[val - DISTANCE];
    }

    public TrieNode getValue(char val) {
        return this.next[val - DISTANCE];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }


    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode tmp = root;
        for (int i = 0; i < word.length(); i++) {
            tmp = tmp.insert(word.charAt(i));
        }
        tmp.value = true;

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode tmp = root;
        for (int i = 0; i < word.length(); i++) {
            if (tmp.getValue(word.charAt(i)) != null) {
                tmp = tmp.getValue(word.charAt(i));
            } else {
                return false;
            }
        }
        return tmp.value;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (tmp.getValue(prefix.charAt(i)) != null) {
                tmp = tmp.getValue(prefix.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }

}
