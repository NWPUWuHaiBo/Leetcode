package sortByCategory.BucketSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-02-29 17:55
 */
public class No_347_KthFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0) return list;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            Integer val = hashMap.getOrDefault(num, 0);
            hashMap.put(num, val + 1);
        }
        ArrayList[] bucket = new ArrayList[nums.length+1];
        for (Integer key : hashMap.keySet()) {
            if (bucket[hashMap.get(key)] == null) {
                bucket[hashMap.get((key))] = new ArrayList();
            }
            bucket[hashMap.get(key)].add(key);
        }

        for (int i = bucket.length - 1; i >= 0 && list.size() < k; i--) {
            if (bucket[i] == null) continue;
            if(bucket[i].size()<=k-list.size()){
                list.addAll(bucket[i]);
            }else{
                list.addAll(bucket[i].subList(0,k-list.size()));
            }

        }
        return list;
    }
}
