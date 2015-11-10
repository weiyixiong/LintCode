import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Createdbywinneyon15/11/9.
 */
public class buildTree {
    /**
     * @parampreorder:Alistofint egersthatpreordertraversalofatree
     * @paraminorder:Alistofint egersthatinordertraversalofatree
     * @return:Rootofatree
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        boolean deep = true;
        if (preorder.length <= 3 && preorder.length > 1) {
            if (preorder[0] == inorder[1] && preorder[1] == inorder[0]) {
                deep = false;
                if (inorder.length == 3 && inorder[2] == preorder[1]) {
                    deep = false;
                }
            } else if (preorder[0] == inorder[0] && preorder[1] == inorder[1]) {
                deep = false;
            }
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (deep) {
            int lSize = 0;
            int rSize = 0;
            boolean mid = false;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] != preorder[0] && !mid) {
                    lSize++;
                } else if (mid) {
                    rSize++;
                } else {
                    mid = true;
                }

            }
            int[] lArrPre = new int[lSize];
            int[] rArrPre = new int[rSize];
            int[] lArrIn = new int[lSize];
            int[] rArrIn = new int[rSize];
//            System.out.println();
            for (int i = 0; i < lSize; i++) {
                if (inorder[i] != preorder[0]) {
                    lArrPre[i] = preorder[i + 1];
                    lArrIn[i] = inorder[i];
                }
            }
            for (int i = lArrIn.length + 1; i < inorder.length; i++) {
                rArrPre[i - lArrIn.length - 1] = preorder[i];
                rArrIn[i - lArrIn.length - 1] = inorder[i];
//                System.out.println(inorder[i]);
            }
            root.left = buildTree(lArrPre, lArrIn);
            root.right = buildTree(rArrPre, rArrIn);
        } else if (preorder.length <= 3) {
            if (preorder[0] == inorder[1] && preorder[1] == inorder[0]) {
                TreeNode left = new TreeNode(inorder[0]);
                root.left = left;
                if (inorder.length == 3 && inorder[2] == preorder[2]) {
                    TreeNode right = new TreeNode(preorder[2]);
                    root.right = right;
                }
            } else if (preorder[0] == inorder[0] && preorder[1] == inorder[1]) {
                TreeNode right = new TreeNode(inorder[1]);
                root.right = right;
            }
        } else {
            return new TreeNode(preorder[0]);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] a = {6, 2, 3, 4, 5};
        int[] b = {2, 4, 5, 3, 6};
        ArrayList<ArrayList<Integer>> testCase = levelOrder.levelOrder(buildTree(a, b));
        for (int i = 0; i < testCase.size(); i++) {
            System.out.println(Arrays.toString(testCase.get(i).toArray()));
        }
        ArrayList<Integer> list = preorderTraversal.preorderTraversal(buildTree(a, b));
        System.out.print(Arrays.toString(list.toArray()));
    }

}
