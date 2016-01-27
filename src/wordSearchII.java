import java.util.*;

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
        int maxDeep = 0;
        for (String word : words) {
            maxDeep = Math.max(word.length(), maxDeep);
        }
        boolean[][] flag = new boolean[board.length][maxLen];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                buildRoot(root, board, flag, i, j, maxDeep);
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
                root = root.childs.get(target.charAt(i) - 'a');
            } else {
                return false;
            }
        }
        if (root == null)
            return false;
        return true;
    }

    public static void buildRoot(TreeNode root, char[][] board, boolean[][] flag, int i, int j, int maxDeep) {
        if (root.childs.get(board[i][j] - 'a') == null)
            root.childs.put(board[i][j] - 'a', new TreeNode());
        flag[i][j] = true;
        buildTree(root.childs.get(board[i][j] - 'a'), board, flag, i, j, maxDeep--);
        flag[i][j] = false;
    }

    public static void buildTree(TreeNode root, char[][] board, boolean[][] flag, int i, int j, int maxDeep) {
        if (maxDeep <= 0) {
            return;
        }
        int i1 = 0;
        if (i + 1 < board.length && !flag[i + 1][j]) {
            i1 = board[i + 1][j] - 'a';
            if (root.childs.get(i1) == null)
                root.childs.put(i1, new TreeNode());
            flag[i + 1][j] = true;
            buildTree(root.childs.get(i1), board, flag, i + 1, j, maxDeep - 1);
            flag[i + 1][j] = false;
        }

        if (j + 1 < board[i].length && !flag[i][j + 1]) {
            i1 = board[i][j + 1] - 'a';
            if (root.childs.get(i1) == null)
                root.childs.put(i1, new TreeNode());
            flag[i][j + 1] = true;
            buildTree(root.childs.get(i1), board, flag, i, j + 1, maxDeep - 1);
            flag[i][j + 1] = false;
        }


        if (i - 1 >= 0 && !flag[i - 1][j]) {
            i1 = board[i - 1][j] - 'a';
            if (root.childs.get(i1) == null)
                root.childs.put(i1, new TreeNode());
            flag[i - 1][j] = true;
            buildTree(root.childs.get(i1), board, flag, i - 1, j, maxDeep - 1);
            flag[i - 1][j] = false;
        }

        if (j - 1 >= 0 && !flag[i][j - 1]) {
            i1 = board[i][j - 1] - 'a';
            if (root.childs.get(i1) == null)
                root.childs.put(i1, new TreeNode());
            flag[i][j - 1] = true;
            buildTree(root.childs.get(i1), board, flag, i, j - 1, maxDeep - 1);
            flag[i][j - 1] = false;
        }

    }

    static class TreeNode {
        Map<Integer, TreeNode> childs;

        public TreeNode() {
            childs = new HashMap<>();
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
