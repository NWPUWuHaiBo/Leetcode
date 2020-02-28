package sortByOrder.part5;

/**
 * @author haiboWu
 * @create 2020-02-18 18:42
 */
public class No_43 {
    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }

    public static String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) return "0";
        int l1 = num1.length();
        int l2 = num2.length();
        int[] result = new int[l1 + l2];
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                int mul = (num1.charAt(l1 - i - 1) - '0') * (num2.charAt(l2 - j - 1) - '0');
                mul += result[l1 + l2 - i - j - 1];
                result[l1 + l2 - i - j - 1] = mul % 10;
                result[l1 + l2 - i - j - 2] += mul / 10;

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int res : result) {
            if (sb.length() == 0 && res == 0) continue;
            sb.append(res);
        }
        return sb.length() == 0 ? "0" : sb.toString();
           /*for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                result[i + j + 1] += mul % 10;
                result[i + j] += mul / 10;
            }
        }*/
    }

}
