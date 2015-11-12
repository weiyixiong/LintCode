import java.util.ArrayList;

/**
 * Created by winney on 15/11/12.
 */
public class searchRange2 {
    /**
     * @param root: The root of the binary search tree.
     * @param k1    and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        searchHelper(root, k1, k2, res);
        return res;

    }

    public void searchHelper(TreeNode root, int k1, int k2, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        searchHelper(root.left, k1, k2, res);
        if (root.val >= k1 && root.val <= k2) {
            res.add(root.val);
        }
        searchHelper(root.right, k1, k2, res);
    }
}
