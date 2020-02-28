package sortByCategory.DoublePointer;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author haiboWu
 * @create 2020-02-28 15:07
 */
//使用双指针指向待反转的两个元音字符，一个指针从头向尾遍历，一个指针从尾到头遍历
public class No_345_ReverseVowelsString {

    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<Character>(
                Arrays.asList('a', 'e', 'o', 'i', 'u', 'A', 'E', 'I', 'O', 'U'));

        int i = 0, j = s.length() - 1;
        char[] arr = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!set.contains(ci)) {
                arr[i++] = ci;
            } else if (!set.contains(cj)) {
                arr[j--] = cj;
            } else {
                arr[i++] = cj;
                arr[j--] = ci;
            }
        }
        return String.valueOf(arr);
    }
    @Test
    public void testReverse(){
        String s="leetcode";
        String s1 = reverseVowels(s);
        System.out.println(s1);
    }
}
