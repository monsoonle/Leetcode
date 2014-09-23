/***
 * 
 * @author Le
 *  https://oj.leetcode.com/problems/add-two-numbers/
 */

public class Add_Two_Numbers {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode result = new ListNode(0);
			ListNode cur = result;
			int carry = 0;
			while (l1 != null || l2 != null) {
				int a = l1 == null ? 0 : l1.val;
				int b = l2 == null ? 0 : l2.val;
				int c = (a + b + carry) % 10;
				cur.next = new ListNode(c);
				cur = cur.next;
				carry = (a + b + carry) / 10;
				if (l1 != null) {
					l1 = l1.next;
				}
				if (l2 != null) {
					l2 = l2.next;
				}
			}
			if (carry != 0) {
				cur.next = new ListNode(carry);
			}
			return result.next;
		}
	}

}