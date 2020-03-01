package sortByCategory.BucketSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author haiboWu
 * @create 2020-03-01 9:23
 */
public class No_451_CharacterFrequency {
    public String frequencySort(String s) {
        Map<Character,Integer> frequencyMap=new HashMap<>();
        for(Character ch:s.toCharArray()){
            frequencyMap.put(ch,frequencyMap.getOrDefault(ch,0)+1);
        }
        ArrayList<Character> []bucket=new ArrayList[s.length()+1];
        for(Character ch:frequencyMap.keySet()){
            int fre=frequencyMap.get(ch);
            if(bucket[fre]==null){
                bucket[fre]=new ArrayList<>();
            }
            bucket[fre].add(ch);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]==null)continue;
            for (int j = 0; j < bucket[i].size(); j++) {
                for (int k = 0; k < i; k++) {
                    sb.append(bucket[i].get(j));
                }
            }
        }
        return sb.toString();
    }

}
