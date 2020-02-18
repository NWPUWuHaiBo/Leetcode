package part4;

import java.util.Stack;

/**
 * @author haiboWu
 * @create 2020-02-13 20:51
 */
public class No_32 {
    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        if (s.length() <= 0) return 0;
        int leftmost = -1, max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            if (s.charAt(i) == ')' && stack.size() == 0) {
                leftmost = i;
            } else if (s.charAt(i) == ')') {
                stack.pop();
                int temp = 0;
                if (stack.size() == 0) {
                    temp = i - leftmost;
                } else {
                    temp = i - stack.peek();
                }
                max = Math.max(max, temp);
            }

        }
        return max;
    }
}
