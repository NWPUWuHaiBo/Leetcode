package sortByOrder.part2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author haiboWu
 * @create 2020-02-06 19:25
 */
public class No_20 {
    public static void main(String[] args) {
        System.out.println(isValid("){"));
    }

    public static boolean isValid(String s) {
        boolean flag = true;
        Map<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('[', ']');
        hashMap.put('{', '}');

        Stack<Character> stack = new Stack();


        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()&&!hashMap.containsKey(s.charAt(i))){
                flag=false;
                return flag;
            }
            if(hashMap.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }else{
                if(hashMap.get(stack.pop())==s.charAt(i)){
                    continue;
                }else {
                    flag=false;
                    return flag;
                }
            }
        }
        if(!stack.isEmpty()){
            flag=false;
        }
        return flag;
    }

}
