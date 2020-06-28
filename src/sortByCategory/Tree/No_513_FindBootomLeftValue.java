package sortByCategory.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author haiboWu
 * @create 2020-06-11 16:37
 */
public class No_513_FindBootomLeftValue {
    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null)
                queue.add(root.right);
            if (root.left != null)
                queue.add(root.left);
        }
        return root.val;
    }
}
