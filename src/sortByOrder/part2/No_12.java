package sortByOrder.part2;

/**
 * @author haiboWu
 * @create 2020-02-02 10:36
 */
public class No_12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(3));
    }

    public static String intToRoman(int num) {
        //ctrl+alt+L
        new StringBuilder();
        StringBuilder builder = new StringBuilder();
        int[] moneys = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] moneyToStr = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        while (num > 0) {
            if (index < 0) index = 0;
            if (num >= moneys[index]) {
                builder.append(moneyToStr[index]);
                num -= moneys[index];
                index--;
            }
            index++;
        }
        return builder.toString();
    }

}
