package sortByOrder.part1;

import java.util.HashMap;
import java.util.Map;

public class No_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] twoSum(int[] nums, int target) {
		int []index=new int[2];

		Map<Integer,Integer> hash=new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++){
			if(hash.containsKey(nums[i])){
				index[0]=i;
				index[1]=hash.get(nums[i]);
				return index;
			}
			hash.put(target-nums[i],i);
		}
		return index;
	}

}