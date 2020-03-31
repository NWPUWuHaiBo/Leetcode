package sortByCategory.BinarySearch;

/**
 * @author haiboWu
 * @create 2020-03-07 15:15
 */
public class No_744_FindSmallestLetterThanTarget {

    /**
     * 找比目标字母大的最小字母
     *
     * 类似于二分查找中找最右边界
     *
     * 循环退出的边界是： left+1==right
     *
     * 如果是右边界，left正好是下一个大于给定元素的最小元素
     * 跟右边界一样，要注意越界情况的处理
     *
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] == target) {
                left = mid + 1;
            } else if (letters[mid] > target) {
                right = mid - 1;
            } else if (letters[mid] < target) {
                left = mid + 1;
            }
        }
        if (left >= letters.length) {
            return letters[0];
        } else {
            return letters[left];
        }
    }
}
