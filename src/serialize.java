import java.util.LinkedList;

/**
 * Created by winney on 15/11/12.
 */
public class serialize {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> cache = new LinkedList<TreeNode>();
        LinkedList<TreeNode> levelCache = new LinkedList<TreeNode>();
        cache.add(root);
        while (true) {
            while (cache.size() != 0) {
                TreeNode tmp = cache.pollFirst();
                if (tmp != root) {
                    sb.append(",");
                }
                if (tmp == null) {
                    sb.append("#");
                    continue;
                }
                sb.append(tmp.val);
                levelCache.add(tmp.left);
                levelCache.add(tmp.right);
            }
            if (levelCache.size() == 0) {
                break;
            }
            cache.addAll(levelCache);
            levelCache.clear();
        }
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        TreeNode res = new TreeNode(data.charAt(0) - '0');
        LinkedList<TreeNode> cache = new LinkedList<TreeNode>();
        cache.add(res);
        int nodeNum = 1;
        for (int i = 0; i < data.length() - 1; ) {
            for (int j = 0; j < nodeNum; j++) {
                TreeNode tmp = cache.pollFirst();
                i++;
                if (i < data.length() - 1 && Character.isDigit(data.charAt(++i))) {
                    int intData = data.charAt(i) - '0';
                    while (i < data.length() - 1 && Character.isDigit(data.charAt(i + 1))) {
                        intData *= 10;
                        intData += data.charAt(++i) - '0';
                    }
                    tmp.left = new TreeNode(intData);
                    cache.add(tmp.left);
                }
                i++;
                if (i < data.length() - 1 && Character.isDigit(data.charAt(++i))) {
                    int intData = data.charAt(i) - '0';
                    while (i < data.length() - 1 && Character.isDigit(data.charAt(i + 1))) {
                        intData *= 10;
                        intData += data.charAt(++i) - '0';
                    }
                    tmp.right = new TreeNode(intData);
                    cache.add(tmp.right);
                }
            }
            nodeNum <<= 1;
        }
        return res;

    }

}
