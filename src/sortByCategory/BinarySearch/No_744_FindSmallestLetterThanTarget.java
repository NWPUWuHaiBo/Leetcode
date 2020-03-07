package sortByCategory.BinarySearch;

/**
 * @author haiboWu
 * @create 2020-03-07 15:15
 */
public class No_744_FindSmallestLetterThanTarget {
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
