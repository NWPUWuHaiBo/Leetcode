package sortByCategory.DivideAndConquer;


/**
 * @author haiboWu
 * @create 2020-03-11 17:50
 */
public class No_95_UniqueBinaryTree {

    public static void main(String[] args) {

    }
/**
 * 这里设置了自动导包，导入swing下的TreeNode，影响代码
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new LinkedList<>();
        }

        return generate(1, n);
    }

    private List<TreeNode> generate(int i, int n) {
        LinkedList<TreeNode> list = new LinkedList();
        if (i > n) {
            list.add(null);
            return list;
        }
        for (int j = i; j <= n; j++) {
            List<TreeNode> left = generate(i, j - 1);
            List<TreeNode> right = generate(j + 1, n);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode cur=new TreeNode(j);
                    cur.left=l;
                    cur.right=r;
                    list.add(cur);
                }
            }
        }
        return list;
    }
 */
}
