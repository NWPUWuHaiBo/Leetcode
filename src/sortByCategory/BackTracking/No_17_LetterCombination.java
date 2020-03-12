package sortByCategory.BackTracking;

/**
 * @author haiboWu
 * @create 2020-03-12 19:12
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 模板
 * result = []
 * def backtrack(路径, 选择列表):
 * if 满足结束条件:
 * result.add(路径)
 * return
 * <p>
 * for 选择 in 选择列表:
 * 做选择
 * backtrack(路径, 选择列表)
 * 撤销选择
 */

public class No_17_LetterCombination {
    public static void main(String[] args) {
        System.out.println(new No_17_LetterCombination().letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        backTrack(sb, digits, res);
        return res;
    }

    private void backTrack(StringBuilder sb, String digits, ArrayList<String> res) {
        if (sb.length() == digits.length()) {
            res.add(new StringBuilder(sb).toString());
            return;
        }
        char [] cur=getLetter(digits.charAt(sb.length()));
        for (char c : cur) {
            sb.append(c);
            backTrack(sb,digits,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public char[] getLetter(int num) {
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
}
