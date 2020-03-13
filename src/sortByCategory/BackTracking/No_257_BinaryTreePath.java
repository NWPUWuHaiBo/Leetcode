package sortByCategory.BackTracking;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

}


/**
 * @author haiboWu
 * @create 2020-03-13 20:19
 */
public class No_257_BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        generatePath(root, res, values);
        return res;
    }

    private void generatePath(TreeNode root, List<String> res, List<Integer> values) {
        if (root == null) {
            return;
        }
        values.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(getPath(values));
        } else {
            generatePath(root.right, res, values);
            generatePath(root.left, res, values);
        }
        values.remove(values.size() - 1);
    }

    private String getPath(List<Integer> values) {
        StringBuilder sb = new StringBuilder();
        for (Integer value : values) {
            String cur = value + "";
            if (sb.length() != 0) {
                cur = "->" + cur;
            }
            sb.append(cur);
        }
        return sb.toString();
    }
}
