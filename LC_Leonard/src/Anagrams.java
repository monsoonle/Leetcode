import java.util.*;

public class Anagrams {
	public List<String> anagrams(String[] strs) {
		ArrayList<String> results = new ArrayList<String>();
		if (strs.length == 0){
			return results;
		}
		HashMap<String, ArrayList<String>> groups = new HashMap<String, ArrayList<String>>();
		for (String str : strs) {
			char[] strchars = str.toCharArray();
			Arrays.sort(strchars);
			String strlabel = String.copyValueOf(strchars);
			ArrayList<String> group = groups.get(strlabel);
			if (group == null) {
				group = new ArrayList<String>();
				groups.put(strlabel, group);
			}
			group.add(str);
		}
		for (ArrayList<String> group : groups.values()) {
			if (group.size() > 1){
			results.addAll(group);
			}
				
		}
		return results;
	}
}
