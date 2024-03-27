class Solution {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		Map<Character, Integer> charCounter = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			charCounter.compute(s.charAt(i), (key, count) -> count == null ? 1 : count + 1);
			charCounter.compute(t.charAt(i), (key, count) -> count == null ? -1 : count - 1);
		}

		return charCounter.values().stream()
			.allMatch(count -> count == 0);
	}

	public boolean isAnagram2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		Map<Character, Boolean> checked = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (checked.getOrDefault(ch, false)) {
				break;
			}

			int sCharCount = 0;
			int tCharCount = 0;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == ch) {
					sCharCount++;
				}

				if (t.charAt(j) == ch) {
					tCharCount++;
				}
			}

			if (sCharCount != tCharCount) {
				return false;
			}

			checked.put(ch, true);
		}

		return true;
	}

	public boolean isAnagram3(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		char[] sArray = s.toCharArray();
		Arrays.sort(sArray);

		char[] tArray = t.toCharArray();
		Arrays.sort(tArray);

		return Arrays.equals(sArray, tArray);
	}
}
