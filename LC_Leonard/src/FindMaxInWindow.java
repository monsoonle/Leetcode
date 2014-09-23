import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 You are given an array of size n. There is a sliding window of size k(<n). 
 Return an array containing max element in each window position(from leftmost
 window position to rightmost).
 Eg.
 input: A=4,7,3,6,8,2,4,3,2,5,4 k=4
 output:B=7,8,8,8,8,4,5,5

 */

class pair {
	public int index;
	public int val;

	public pair(int value, int index) {
		this.val = value;
		this.index = index;
	}

}

public class FindMaxInWindow {

	public static List<Integer> findMaxInWindow(int[] array, int k) {
		// do some init check
		// ...

		int size = array.length;
		List<Integer> result = new ArrayList<Integer>();
		LinkedList<pair> monotone = new LinkedList<pair>();
		monotone.addFirst(new pair(array[0], 0));

		for (int i = 1; i < k; i++) {
			while (array[i] > monotone.getFirst().val) {
				monotone.removeFirst();
				if (monotone.size() == 0) {
					break;
				}
			}
			monotone.addFirst(new pair(array[i], i));
		}
		result.add(monotone.getLast().val);

		for (int i = k; i < size; i++) {
			if (i - k == monotone.getLast().index) {
				monotone.removeLast();
			}
			while (array[i] > monotone.getFirst().val) {
				monotone.removeFirst();
				if (monotone.size() == 0) {
					break;
				}
			}
			monotone.addFirst(new pair(array[i], i));

			result.add(monotone.getLast().val);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] A = { 4, 7, 3, 6, 8, 2, 4, 3, 2, 5, 4 ,8};
		ArrayList<Integer> list = (ArrayList<Integer>) findMaxInWindow(A, 5);
		for (int item : list) {
			System.out.print(item + ", ");
		}
	}

}
