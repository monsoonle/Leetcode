import java.util.Set;


public class Word_Break {
	
	/*
	 *        res(i) = any_of(res(j) &&  s.subString(j, i + 1) in dict); 0 <= j < i
	 *        time O(n^2) space O(n)
	 */
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
			return true;
		}
		boolean[] res = new boolean[s.length() + 1];
		res[0] = true; // "" empty string
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				if (res[j] && dict.contains(s.substring(j, i + 1))) {
					res[i + 1] = true;
					break;
				}
			}
		}
		return res[s.length()];
	}
}
