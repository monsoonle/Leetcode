public class Sqrt_x {
	public int sqrt(int x) {

		if (x < 0)
			return -1;
		if (x == 0)
			return 0;

		int low = 1;
		int high = x / 2 + 1;

		// ֻ�ǽ����������������ҽ�Ĳ�ľ���ֵС��ĳһ�� epsilon����Сֵ������
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid <= x / mid && x / (mid + 1) < mid + 1)
				return mid;
			if (x < mid * mid) {
				high = mid - 1; // not hi = mid
			} else {
				low = mid + 1;
			}
		}
		return 0;
	}

}
