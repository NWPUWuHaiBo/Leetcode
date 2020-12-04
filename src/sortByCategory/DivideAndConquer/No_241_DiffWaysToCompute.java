package sortByCategory.DivideAndConquer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-03-10 13:56
 */
public class No_241_DiffWaysToCompute {

    @Test
    public void test(){
        String input="2*3-4*5";
        List<Integer> integers = diffWaysToCompute(input);
        System.out.println(integers.toString());
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            list.add(Integer.valueOf(input));
            return list;
        }
        for (int i = 0; i < input.length(); i++) {
            if (isOper(input.charAt(i))) {
                //获取第一个数组
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                //获取第二个数组
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for (Integer l : left) {
                    for (Integer r : right) {
                        int compute = doCompute(l, r, input.charAt(i));
                        list.add(compute);
                    }
                }
            }
        }
        return list;

    }

    private int doCompute(Integer l, Integer r, char c) {
        switch (c) {
            case '-':
                return l - r;
            case '+':
                return l + r;
            case '*':
                return l * r;
            default:
                return 0;
        }
    }

    private boolean isOper(char ch) {
        return ch == '+' || ch == '-' || ch == '*';
    }
}
