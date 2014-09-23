package com.ll.Frequency_5;

public class StrStr {
	public String strStr(String haystack, String needle) {
		if (needle.length() == 0 || needle.equals(haystack))
			return haystack;
		if (haystack.length() < needle.length())
			return null;
		int R = 256;
		int M = needle.length();
		int N = haystack.length();
		long Q = java.math.BigInteger.probablePrime(31, new java.util.Random())
				.longValue();
		// precompute R^(M-1) % Q for use in removing leading digit
		long RM = 1;
		for (int i = 1; i <= M - 1; i++)
			RM = (R * RM) % Q;
		long needleHash = hash(needle, M, R, Q);
		long haystackHash = hash(haystack, M, R, Q);

		// check for match at offset 0
		if ((needleHash == haystackHash) && check(haystack, needle, 0))
			return haystack;

		// check for hash match; if hash match, check for exact match
		for (int i = M; i < N; i++) {
			// Remove leading digit, add trailing digit, check for match.
			haystackHash = (haystackHash + Q - RM * haystack.charAt(i - M) % Q)
					% Q;
			haystackHash = (haystackHash * R + haystack.charAt(i)) % Q;

			// match
			int offset = i - M + 1;
			if ((needleHash == haystackHash) && check(haystack, needle, offset))
				return haystack.substring(i - M + 1);
		}
		// no match
		return null;
	}

	// Compute hash for key[0..M-1].
	private static long hash(String key, int M, int R, long Q) {
		long h = 0;
		for (int j = 0; j < M; j++)
			h = (R * h + key.charAt(j)) % Q;
		return h;
	}

	private static boolean check(String txt, String pat, int i) {
		for (int j = 0; j < pat.length(); j++)
			if (pat.charAt(j) != txt.charAt(i + j))
				return false;
		return true;
	}
}
