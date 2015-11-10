import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by winney on 15/11/9.
 */
public class levelOrder {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> quque = new LinkedList<TreeNode>();
        LinkedList<TreeNode> quque2 = new LinkedList<TreeNode>();
        quque.add(root);
        while (true && root != null) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            while (quque.size() != 0) {
                TreeNode tmpRoot = quque.pollFirst();
                tmp.add(tmpRoot.val);
                if (tmpRoot.left != null)
                    quque2.add(tmpRoot.left);
                if (tmpRoot.right != null)
                    quque2.add(tmpRoot.right);
            }
            res.add(tmp);
            quque.addAll(quque2);
            if (quque2.isEmpty()) {
                break;
            }
            quque2.clear();
        }
        return res;
    }
}
