package sortByCategory.Greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-03-05 17:21
 */
public class No_763_PartitionLabels {
    @Test
    public void Test(){
        String s="ababcbacadefegdehijhklij";
        List<Integer> list = partitionLabels(s);
        System.out.println(list.toString());
    }
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for(int i = 0; i < S.length(); i++){
            last[S.charAt(i) - 'a'] = i;
        }

        int k = 0;
        List<Integer> result = new LinkedList<>();
        while(k < S.length()){
            int lastIndex = last[S.charAt(k)-'a'];
            int start = k;
            while(k <= lastIndex){
                lastIndex = Math.max(lastIndex, last[S.charAt(k)-'a']);
                k++;
            }
            result.add(lastIndex - start + 1);
        }
        return result;
    }
}
