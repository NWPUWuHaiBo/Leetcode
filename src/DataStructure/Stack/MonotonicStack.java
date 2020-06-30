package DataStructure.Stack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author haiboWu
 * @create 2020-06-28 10:23
 */
public class MonotonicStack {

    int[] nextGreaterElement(LinkedList<Integer> nums) {
        //存的是具体的值
        int[] res = new int[nums.size()];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums.get(i)) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums.get(i));
        }
        return res;
    }

    @Test
    public void testNextGreatEle() {
        LinkedList list = new LinkedList();
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(3);
        int[] ints = nextGreaterElement(list);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        //存的是index
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return res;
    }

    int[] nextGreaterElementInCyc(int nums[]) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i%n]);
        }
        return res;
    }

}
