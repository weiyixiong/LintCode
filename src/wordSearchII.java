import apple.laf.JRSUIUtils;

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
    public static ArrayList<String> wordSearchII2(char[][] board, ArrayList<String> words) {
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
        if (root.childs.get(board[i][j]) == null)
            root.childs.put(board[i][j], new TreeNode());
        flag[i][j] = true;
        buildTree(root.childs.get(board[i][j] - 'a'), board, flag, i, j, maxDeep--);
        flag[i][j] = false;
    }

    public static void buildTree(TreeNode root, char[][] board, boolean[][] flag, int i, int j, int maxDeep) {
        if (maxDeep <= 0) {
            return;
        }
        char i1 = 0;
        if (i + 1 < board.length && !flag[i + 1][j]) {
            i1 = board[i + 1][j];
            if (root.childs.get(i1) == null)
                root.childs.put(i1, new TreeNode());
            flag[i + 1][j] = true;
            buildTree(root.childs.get(i1), board, flag, i + 1, j, maxDeep - 1);
            flag[i + 1][j] = false;
        }

        if (j + 1 < board[i].length && !flag[i][j + 1]) {
            i1 = board[i][j + 1];
            if (root.childs.get(i1) == null)
                root.childs.put(i1, new TreeNode());
            flag[i][j + 1] = true;
            buildTree(root.childs.get(i1), board, flag, i, j + 1, maxDeep - 1);
            flag[i][j + 1] = false;
        }


        if (i - 1 >= 0 && !flag[i - 1][j]) {
            i1 = board[i - 1][j];
            if (root.childs.get(i1) == null)
                root.childs.put(i1, new TreeNode());
            flag[i - 1][j] = true;
            buildTree(root.childs.get(i1), board, flag, i - 1, j, maxDeep - 1);
            flag[i - 1][j] = false;
        }

        if (j - 1 >= 0 && !flag[i][j - 1]) {
            i1 = board[i][j - 1];
            if (root.childs.get(i1) == null)
                root.childs.put(i1, new TreeNode());
            flag[i][j - 1] = true;
            buildTree(root.childs.get(i1), board, flag, i, j - 1, maxDeep - 1);
            flag[i][j - 1] = false;
        }

    }

    //以上解法适用于字典多,矩阵少的情况
    static class TreeNode {
        Map<Character, TreeNode> childs;

        public TreeNode() {
            childs = new HashMap<>();
        }

    }
    //////////////////////////////////////
    //以下解法适用于字典少,矩阵多的情况

    public static void buildTree(String word, TreeNode root, int i) {
        if (i == word.length()) {
            return;
        }
        if (root.childs.get(word.charAt(i)) == null) {
            root.childs.put(word.charAt(i), new TreeNode());
        }
        buildTree(word, root.childs.get(word.charAt(i)), i + 1);
    }

    public static void findWordRoot(TreeNode root, char[][] board, boolean[][] flag, int i, int j, int maxDeep, ArrayList<String> ans, ArrayList<String> words) {
        flag[i][j] = true;
        if (root.childs.containsKey(board[i][j]))
            findWord(root.childs.get(board[i][j]), board, flag, i, j, maxDeep - 1, board[i][j] + "", ans, words);
        flag[i][j] = false;
    }

    public static void findWord(TreeNode root, char[][] board, boolean[][] flag, int i, int j, int maxDeep, String target, ArrayList<String> ans, ArrayList<String> words) {
        if (words.contains(target) && !ans.contains(target)) {
            ans.add(target);
        }

        char i1 = 0;
        if (i + 1 < board.length && !flag[i + 1][j] && root.childs.containsKey(board[i + 1][j])) {
            i1 = board[i + 1][j];
            flag[i + 1][j] = true;
            findWord(root.childs.get(i1), board, flag, i + 1, j, maxDeep - 1, target + i1, ans, words);
            flag[i + 1][j] = false;
        }

        if (j + 1 < board[i].length && !flag[i][j + 1] && root.childs.containsKey(board[i][j + 1])) {
            i1 = board[i][j + 1];
            flag[i][j + 1] = true;
            findWord(root.childs.get(i1), board, flag, i, j + 1, maxDeep - 1, target + i1, ans, words);
            flag[i][j + 1] = false;
        }
        if (i - 1 >= 0 && !flag[i - 1][j] && root.childs.containsKey(board[i - 1][j])) {
            i1 = board[i - 1][j];
            flag[i - 1][j] = true;
            findWord(root.childs.get(i1), board, flag, i - 1, j, maxDeep - 1, target + i1, ans, words);
            flag[i - 1][j] = false;
        }

        if (j - 1 >= 0 && !flag[i][j - 1] && root.childs.containsKey(board[i][j - 1])) {
            i1 = board[i][j - 1];
            flag[i][j - 1] = true;
            findWord(root.childs.get(i1), board, flag, i, j - 1, maxDeep - 1, target + i1, ans, words);
            flag[i][j - 1] = false;
        }
    }


    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     * 转变思路,对字典建树
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
        for (String word : words) {
            buildTree(word, root, 0);
        }
        boolean[][] flag = new boolean[board.length][maxLen];
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                findWordRoot(root, board, flag, i, j, maxDeep, ans, words);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        char[][] borad = {{'d', 'o', 'a', 'f'}, {'a', 'g', 'a', 'i'}, {'d', 'c', 'a', 'n'}};

        ArrayList<String> words = new ArrayList<>();
        words.add("doafinaag");
        words.add("dog");
        words.add("ina");
        words.add("cani");
        words.add("again");
        ArrayList<String> word = wordSearchII(borad, words);
        System.out.print(Arrays.toString(word.toArray()));
    }

}
