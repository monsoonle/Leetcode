import java.util.HashMap;

public class Roman_To_Integer {
	public int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			if (i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
				result -= map.get(s.charAt(i));
				result += map.get(s.charAt(i + 1));
				i++;
				continue;
			}

			result += map.get(s.charAt(i));
		}

		return result;

	}
}
