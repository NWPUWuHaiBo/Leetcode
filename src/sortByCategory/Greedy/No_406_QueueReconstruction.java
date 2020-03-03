package sortByCategory.Greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-03-02 22:32
 */
public class No_406_QueueReconstruction {
    @Test
    public  void TestQueue(){
        int [][]arr={{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        reconstructQueue(arr);
    }
    public int[][] reconstructQueue(int[][] people) {
        if(people==null||people.length==0||people[0].length==0){
            return new int[0][0];
        }
        Arrays.sort(people,(o1,o2)->{return o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0];});
        List<int[]>queue=new ArrayList<>();
        for(int[] q:people){
            queue.add(q[1],q);
        }
        return  queue.toArray(new int[queue.size()][2]);
    }
}
