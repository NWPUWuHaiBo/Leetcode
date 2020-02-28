package sortByOrder.part2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-02-03 19:33
 */
public class No_17 {
    public static List<String> letterCombinations(String digits) {
        //边界条件判断
        List<String> list = new ArrayList<>();
        if (digits.equals("") || digits == null) {
            return list;
        }
        //先存入一个空字符，从而开始遍历
        list.add("");

        //1.第一个循环目的是：一共要放入的字符次数
        for (int i = 0; i < digits.length(); i++) {
            //获取当前字符对应的字符数组
            char letters[] = getValue(digits.charAt(i));
            //当前字符对应的长度
            int size = list.size();

            //取出当前list中的所有元素
            for (int j = 0; j < size; j++) {
                String tmp = list.remove(0);
                //然后跟“def”这样的字符串拼接起来
                for (int k = 0; k < letters.length; k++) {
                    list.add(tmp + letters[k]);
                }
            }
        }
        return list;
    }

    public static List<String> letterCombinations2(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.equals("") || digits == null) {
            return list;
        }
        getList(digits, 0, list, "");
        return list;
    }

    public static void getList(String digits, int cur, List<String> list, String curStr) {
        if (cur == digits.length()) {
            list.add(curStr);
            return;
        }
        char[] arrays = getValue(digits.charAt(cur));
        for (int i = 0; i < arrays.length; i++) {
            getList(digits, cur + 1, list, curStr + String.valueOf(arrays[i]));
        }
    }

    private static char[] getValue(char num) {
        if (num == '2') {
            char nums[] = {'a', 'b', 'c'};
            return nums;
        } else if (num == '3') {
            char nums[] = {'d', 'e', 'f'};
            return nums;
        } else if (num == '4') {
            char nums[] = {'g', 'h', 'i'};
            return nums;
        } else if (num == '5') {
            char nums[] = {'j', 'k', 'l'};
            return nums;
        } else if (num == '6') {
            char nums[] = {'m', 'n', 'o'};
            return nums;
        } else if (num == '7') {
            char nums[] = {'p', 'q', 'r', 's'};
            return nums;
        } else if (num == '8') {
            char nums[] = {'t', 'u', 'v'};
            return nums;
        } else if (num == '9') {
            char nums[] = {'w', 'x', 'y', 'z'};
            return nums;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
