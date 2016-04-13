import sun.swing.StringUIClientPropertyKey;

import java.util.*;

/**
 * Created by winney on 16/4/13.
 */
public class WordDictionary {

    class node {
        node[] child = new node[26];
        List<Integer> index = new ArrayList<>();
        boolean isEnd = false;
    }

    private node root = new node();

    // Adds a word into the data structure.
    public void addWord(String word) {
        node tmp = root;
        for (int i = 0; i < word.length(); i++) {
            if (tmp.child[word.charAt(i) - 'a'] == null) {
                tmp.child[word.charAt(i) - 'a'] = new node();
                tmp.index.add(word.charAt(i) - 'a');
            }
            tmp = tmp.child[word.charAt(i) - 'a'];
        }
        tmp.isEnd = true;

    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(root, word, 0);
    }

    public boolean search(node root, String word, int index) {
        if (root.index.isEmpty() && index != word.length()) {
            return false;
        }
        node tmp = root;
        for (int i = index; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                boolean res = false;
                for (int j = 0; j < tmp.index.size(); j++) {
                    res |= search(tmp.child[tmp.index.get(j)], word, i + 1);
                }
                return res;
            } else if (tmp.child[word.charAt(i) - 'a'] != null) {
                tmp = tmp.child[word.charAt(i) - 'a'];
            } else {
                return false;
            }
        }
        if (tmp.isEnd) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord("abc");
        System.out.print(wordDictionary.search("abc"));
    }
}
