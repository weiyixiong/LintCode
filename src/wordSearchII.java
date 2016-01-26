import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by winney on 16/1/26.
 */
public class wordSearchII {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public static ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        TreeNode root = new TreeNode();
        int maxLen = 0;
        for (int i = 0; i < board.length; i++) {
            maxLen = Math.max(maxLen, board[i].length);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                buildRoot(root, board, new HashSet<String>(), i, j);
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for (String item : words) {
            if (findWord(root, item)) {
                res.add(item);
            }
        }
        return res;
    }

    public static boolean findWord(TreeNode root, String target) {
        for (int i = 0; i < target.length(); i++) {
            if (root != null) {
                root = root.childs[target.charAt(i) - 'a'];
            } else {
                return false;
            }
        }
        if (root == null)
            return false;
        return true;
    }

    public static void buildRoot(TreeNode root, char[][] board, Set<String> flag, int i, int j) {
        if (root.childs[board[i][j] - 'a'] == null)
            root.childs[board[i][j] - 'a'] = new TreeNode();
        flag.add(i * 100 + j + "");
        buildTree(root.childs[board[i][j] - 'a'], board, flag, i, j);
    }

    public static void buildTree(TreeNode root, char[][] board, Set<String> flag, int i, int j) {
        if (i + 1 < board.length && !flag.contains(cast(i + 1, j))) {
            if (root.childs[board[i + 1][j] - 'a'] == null)
                root.childs[board[i + 1][j] - 'a'] = new TreeNode();
            HashSet<String> tmp = new HashSet<>(flag);
            tmp.add(cast(i + 1, j));
            buildTree(root.childs[board[i + 1][j] - 'a'], board, tmp, i + 1, j);
        }
        if (j + 1 < board[i].length && !flag.contains(cast(i, j + 1))) {
            if (root.childs[board[i][j + 1] - 'a'] == null)
                root.childs[board[i][j + 1] - 'a'] = new TreeNode();
            HashSet<String> tmp = new HashSet<>(flag);
            tmp.add(cast(i, j + 1));
            buildTree(root.childs[board[i][j + 1] - 'a'], board, tmp, i, j + 1);
        }
        if (i - 1 >= 0 && !flag.contains(cast(i - 1, j))) {
            if (root.childs[board[i - 1][j] - 'a'] == null)
                root.childs[board[i - 1][j] - 'a'] = new TreeNode();
            HashSet<String> tmp = new HashSet<>(flag);
            tmp.add(cast(i - 1, j));
            buildTree(root.childs[board[i - 1][j] - 'a'], board, tmp, i - 1, j);
        }
        if (j - 1 >= 0 && !flag.contains(cast(i, j - 1))) {
            if (root.childs[board[i][j - 1] - 'a'] == null)
                root.childs[board[i][j - 1] - 'a'] = new TreeNode();
            HashSet<String> tmp = new HashSet<>(flag);
            tmp.add(cast(i, j - 1));
            buildTree(root.childs[board[i][j - 1] - 'a'], board, tmp, i, j - 1);
        }

    }

    public static String cast(int i, int j) {
        return i * 100 + j + "";
    }

    static class TreeNode {
        TreeNode[] childs;

        public TreeNode() {
            childs = new TreeNode[26];
        }

    }

    public static void main(String[] args) {

        char[][] borad = {{'d', 'o', 'a', 'f'}, {'a', 'g', 'a', 'i'}, {'d', 'c', 'a', 'n'}};

        ArrayList<String> words = new ArrayList<>();
        words.add("doafinaag");
        words.add("dad");
        words.add("dgdg");
        words.add("cana");
        words.add("againi");
        ArrayList<String> word = wordSearchII(borad, words);
        System.out.print(Arrays.toString(word.toArray()));
    }

}
