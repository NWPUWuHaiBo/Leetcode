package sortByOrder.part1;

public class No_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// char a='1';
		// System.out.println((int)a-48);
		System.out.println(revese(-90100));
	}

	public static int revese(int x) {
		if (x == 0) {
			return 0;
		}
		int n = 0;
		String re = "";
		// 1.判断正负号
		boolean flag = true;// true表示正
		if (x < 0) {
			flag = false;
			x = -1 * x;
		}

		// 2.删除末尾的0
		while (x % 10 == 0) {
			x = x / 10;
		}
		// 3.取余将数字存为一个字符串
		while (x > 0) {
			re += ("" + x % 10);
			x = x / 10;
		}
		for (int i = 0; i < re.length(); i++) {
			n += (re.charAt(i) - 48) * Math.pow(10, re.length() - 1 - i);
		}
		if (flag) {
			return n;
		} else {
			return -1 * n;
		}
	}

}
