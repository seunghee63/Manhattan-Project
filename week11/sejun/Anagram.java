class Solution {
		private Map<Character, Integer> sWordMap = new HashMap<>();
		private Map<Character, Integer> tWordMap = new HashMap<>();

		public boolean isAnagram(String s, String t) {
			makeHashMap(s, sWordMap);
			makeHashMap(t, tWordMap);

			return check();
		}

		public void makeHashMap(String word, Map<Character, Integer> anagram) {
			for (int index = 0; index < word.length(); index++) {
				Character temp = word.charAt(index);
				if (anagram.containsKey(temp)) {
					anagram.replace(temp, anagram.get(temp) + 1);
				} else {
					anagram.put(temp, 1);
				}
			}
		}

		public boolean check() {
			Set<Character> sKeys = sWordMap.keySet();
			Set<Character> tKeys = tWordMap.keySet();
			
			for (Character sKey : sKeys) {
				if (!tKeys.contains(sKey)) {
					return false;
				}

				if (!Objects.equals(sWordMap.get(sKey), tWordMap.get(sKey))) {
					return false;
				}
			}

			for (Character tKey : tKeys) {
				if (!sKeys.contains(tKey)) {
					return false;
				}

				if (!Objects.equals(sWordMap.get(tKey), tWordMap.get(tKey))) {
					return false;
				}
			}

			return true;
		}
}
