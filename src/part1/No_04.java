package part1;

public class No_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums1[]={1,2,3};
		int nums2[]={4,5};
		System.out.println(find_kth(nums1, 0, nums2, 0, 3));;
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		// �����κ�һ��numsΪ����������
		if (m == 0) {
			if (n % 2 != 0)
				return 1.0 * nums2[n / 2];
			return (nums2[n / 2] + nums2[n / 2 - 1]) / 2.0;
		}
		if (n == 0) {
			if (m % 2 != 0)
				return 1.0 * nums1[m / 2];
			return (nums1[m / 2] + nums1[m / 2 - 1]) / 2.0;
		}
		int total = m + n;
		// ����Ϊ�������ҵ� total / 2 + 1 ����
		if ((total & 1) == 1) {
			return find_kth(nums1, 0, nums2, 0, total / 2 + 1);
		}
		// ����Ϊż�����ҵ� total / 2 �����͵�total / 2 + 1������ƽ��ֵ
		return (find_kth(nums1, 0, nums2, 0, total / 2) + find_kth(nums1, 0, nums2, 0, total / 2 + 1)) / 2.0;

	}

	// Ѱ��a �� b �����У���k������
	 static float find_kth(int[] a, int a_begin, int[] b, int b_begin, int k) {
		// ��a �� b �������鳤�ȣ����k����Ϊ����һ�������k����
		if (a_begin >= a.length)
			return b[b_begin + k - 1];
		if (b_begin >= b.length)
			return a[a_begin + k - 1];
		// kΪ1ʱ����������С���Ǹ�Ϊ��һ����
		if (k == 1)
			return Math.min(a[a_begin], b[b_begin]);

		int mid_a = Integer.MAX_VALUE;
		int mid_b = Integer.MAX_VALUE;
		// mid_a / mid_b �ֱ��ʾ a���顢b�����е� k / 2 ����
		if (a_begin + k / 2 - 1 < a.length)
			mid_a = a[a_begin + k / 2 - 1];
		if (b_begin + k / 2 - 1 < b.length)
			mid_b = b[b_begin + k / 2 - 1];
		// ���a����ĵ� k / 2 ����С��b����ĵ� k / 2 ��������ʾ�ܵĵ� k ����λ�� a�ĵ�k / 2�����ĺ��Σ�������b�ĵ� k
		// / 2������ǰ���
		// ���ڷ�Χ��С�� k / 2 ��������ʱ�ܵĵ� k ����ʵ���ϵ����µķ�Χ�ڵĵ� k - k / 2���������εݹ�
		if (mid_a < mid_b)
			return find_kth(a, a_begin + k / 2, b, b_begin, k - k / 2);
		// �����෴
		return find_kth(a, a_begin, b, b_begin + k / 2, k - k / 2);
	}

}
