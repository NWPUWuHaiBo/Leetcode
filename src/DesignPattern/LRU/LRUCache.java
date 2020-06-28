package DesignPattern.LRU;

import java.io.PushbackInputStream;
import java.util.HashMap;



/**
 * @author haiboWu
 * @create 2020-06-19 11:28
 */
public class LRUCache {
    private HashMap<Integer,Node>map;
    private DoubleList cache;
    private int cap;

    public LRUCache(int capacity){
        this.cap=capacity;
        map=new HashMap<>();
        cache=new DoubleList();
    }
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        int val=map.get(key).val;
        put(key,val);
        return val;
    }
    public void put(int key,int val){
        Node x=new Node(key,val);
        if(map.containsKey(key)){
            cache.remove(map.get(key));
            cache.addFirst(x);
            map.put(key,x);
        }else {
            if(cap==cache.size()){
                Node last=cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(x);
            map.put(key,x);
        }
    }
}
