package part1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abba";
		System.out.println(lengthOfLongestSubstring2(s));
	}
	public static int lengthOfLongestSubstring2(String s){
		int n=s.length(),ans=0,left=0;
		Map<Character,Integer> map=new HashMap<>();
		for(int j=0;j<n;j++){
			
			if(map.containsKey(s.charAt(j))){
				left=map.get(s.charAt(j))+1;
			}
			map.put(s.charAt(j), j);
			ans=Math.max(ans, j-left+1);
		}	
		return ans;
	}
	
	public static int lengthOfLongestSubstring(String s){
		
		int n=s.length();
		Set<Character> set=new HashSet<>();	
		int ans=0,i=0,j=0;
		while(i<n&&j<n){
			if(!set.contains(s.charAt(j))){
				set.add(s.charAt(j++));
				ans=Math.max(ans, j-i);
			}else{
				set.remove(s.charAt(i++));
			}
		}
		
		return ans;
	}

}
