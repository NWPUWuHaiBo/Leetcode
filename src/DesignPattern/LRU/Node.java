package DesignPattern.LRU;

/**
 * @author haiboWu
 * @create 2020-06-19 11:22
 */
public class Node {
    public int key, val;
    public Node next, pre;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}
