package DesignPattern.LRU;

/**
 * @author haiboWu
 * @create 2020-06-19 11:23
 */
public class DoubleList {
    //头插法，时间复杂度为O(1)
    public void addFirst(Node x){};
    //删除链表中的X节点(X一定存在)
    //由于是双向链表，并且给的是目标节点Node，时间O(1)
    public void remove(Node x){};
    //删除链表中最后一个节点，并返回该节点
    public Node removeLast(){return new Node(1,2);};
    //返回链表长度
    public int size(){return 0;};
}
