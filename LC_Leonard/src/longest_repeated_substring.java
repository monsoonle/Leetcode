import java.util.ArrayList;
import java.util.Collections;


public class longest_repeated_substring {
	static public String lrs(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		ArrayList<Character> array = new ArrayList<Character>();
		char[] charArray = s.toCharArray();
		for (char c : charArray) {
			array.add(c);
		}
		
		Collections.sort(array);
		int max_len = 0;
		int start = 0;
		char last = s.charAt(s.length() - 1);
		
		for (int i = 0; i < array.size() - 1; i++) {
			char a = array.get(i);
			char b = array.get(i + 1);
			int len = 0;
			while (a <= last && b <= last && a == b) {
				a++; 
				b++;
				len++;
				if (max_len < len) {
					max_len = len;
					start = array.get(i) - s.charAt(0);
				}
			}
		}
		if (max_len == 0) {
			return "";
		}
		System.out.println(start + "1231" + max_len);
		
		return s.substring(start, start + max_len);


	}
	public static void main(String[] args) {
		lrs("bababajgfsghfgsfdhdsfgsdfhfdg");
	}

}
